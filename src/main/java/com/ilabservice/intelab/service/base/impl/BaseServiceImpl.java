package com.ilabservice.intelab.service.base.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ilabservice.intelab.common.CamelCaseToUnderscore;
import com.ilabservice.intelab.common.annotation.EnableParam;
import com.ilabservice.intelab.common.annotation.FillAuto;
import com.ilabservice.intelab.common.annotation.IsSortParam;
import com.ilabservice.intelab.model.BaseEntity;
import com.ilabservice.intelab.model.enums.FillAutoValueType;
import com.ilabservice.intelab.service.base.BaseService;
import com.ilabservice.intelab.utils.DateUtil;
import com.ilabservice.intelab.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 公用的service
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {

    @Autowired
    protected M baseMapper;

    @Override
    public void add(T t) {

        fillFieldAuto(t,"INSERT");
        baseMapper.insert(t);
    }
    @Override
    public boolean updateById(T t){

        fillFieldAuto(t,"UPDATE");
        return super.updateById(t);
    }
    /**
     * 分页查询公共方法
     * @param entity
     * @return
     */
    public Page<T> page(T entity){
        Page queryPage = createPage(entity);
        Wrapper entityWrapper = createPageWrapper(entity);

        return this.selectPage(queryPage, entityWrapper);
    }
    /**
     * 公用方法，查询返回实体，可分页，可不分页
     * 修改或支持查询所有
     * @param entity
     * @return
     */
    public List<T> list(@RequestBody T entity){
        Wrapper entityWrapper = createPageWrapper(entity);
        return Optional.ofNullable(baseMapper.selectList(entityWrapper))
                    .orElseGet(() -> Collections.EMPTY_LIST);
    }
    /**
     * 根据参数创建分页条件
     * */
    public Page createPage(T entity) {

        Page<T> queryPage = new Page<>();
        if(entity != null){
            Integer size = entity.getSize();
            Integer current = entity.getCurrent();
            queryPage.setCurrent(current);
            queryPage.setSize(size);
            return queryPage;
        }
        queryPage.setCurrent(1);
        queryPage.setSize(10);
        return queryPage;
    }
    /**
     * 根据参数创建分页查询条件
     * */
    public Wrapper createPageWrapper(T entity){

        EntityWrapper entityWrapper = new EntityWrapper();
        if(entity != null){
            Class clazz = entity.getClass();
            Arrays.stream(clazz.getDeclaredFields())
                    .forEach(field -> this.appendWrapper(entityWrapper, field, entity));
        }
        return entityWrapper;
    }
    /**
     * 将参数追加到分页查询条件
     * EnableParam
     * IsSortParam
     * 主要通过上面两个注解来控制模糊搜索字段的规则，
     * 第一个注解是控制该字段是like还是大小于还是等于
     * 第二个注解主要是控制查出结果的排序规则
     * */
    public Wrapper appendWrapper(Wrapper wrapper, Field field, T entity) {
        field.setAccessible(true); //设置些属性是可以访问的
        String name = field.getName();
        try {
            if (field.getAnnotation(EnableParam.class) != null) {
                Object object = field.get(entity);
                String annotationvalue = field.getAnnotation(EnableParam.class).value();
                if (object != null) {
                    if (StringUtils.isEmpty(annotationvalue)) {
                        String value = (String) object;
                        if (!value.trim().equals(""))
                            wrapper.like(CamelCaseToUnderscore.humpToLine2(name), value);
                    } else if (annotationvalue.contains(">")) {
                        wrapper.ge(CamelCaseToUnderscore.humpToLine2(
                                annotationvalue.substring(annotationvalue.indexOf("_") + 1, annotationvalue.length())), object);
                    } else if (annotationvalue.contains("<")) {
                        wrapper.ge(CamelCaseToUnderscore.humpToLine2(
                                annotationvalue.substring(annotationvalue.indexOf("_") + 1, annotationvalue.length())), object);
                    } else if ("=".equals(annotationvalue)) {
                        try {
                            /**
                             * 如果前端传过来的是空串，则需要将空串忽略掉，不作为搜索条件
                             */
                            String value = (String) object;
                            if (!"".equals(value.trim())) {
                                wrapper.eq(CamelCaseToUnderscore.humpToLine2(name), value);
                            }
                        } catch (Exception e) {
                            wrapper.eq(CamelCaseToUnderscore.humpToLine2(name), object);
                        }
                    }

                }
                if (field.getAnnotation(IsSortParam.class) != null) {

                    boolean sortRule = field.getAnnotation(IsSortParam.class).sortRule();
                    wrapper.orderBy(CamelCaseToUnderscore.humpToLine2(name), sortRule);
                }
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return wrapper;
    }

        /**
    * 字段自动填充
    * @param entity 实体
    * @param type 操作数据库的类型
    * @return
    * @description
    */
        void fillFieldAuto(T entity,String type){
            if(entity != null){
                Class clazz = entity.getClass();
                Field[] fields = clazz.getDeclaredFields();
                try{
                    for(Field field : fields){
                        field.setAccessible(true);
                        if (field.getAnnotation(FillAuto.class) != null){
                            FillAutoValueType value = field.getAnnotation(FillAuto.class).value();
                            /**
                             * 1 INSERT 当为INSERT的时候，只在INSERT情况下填充
                             * 2 UPDATE 当为UPDATE的时候，在INSERT,UPDATE情况都填充
                             */
                            if(type.equals("INSERT") || type.equals(field.getAnnotation(FillAuto.class).type())){
                                if(FillAutoValueType.UUID.equals(value)){
                                    field.set(entity, UUIDUtils.getUUID());
                                }else if(FillAutoValueType.DATE.equals(value)){
                                    field.set(entity, DateUtil.getCurrentDateDefultFormat());
                                }
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
}
