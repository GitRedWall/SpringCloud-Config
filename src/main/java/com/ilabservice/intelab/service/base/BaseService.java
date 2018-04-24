package com.ilabservice.intelab.service.base;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.ilabservice.intelab.model.BaseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 公用的service接口
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18
 */
public interface BaseService<T extends BaseEntity> extends IService<T> {

    void add(T t);
    /**
     * 分页查询公共方法
     * @param entity
     * @return
     */
    Page<T> page(T entity);

    /**
     * 公用方法，查询返回实体，可分页，可不分页
     * @param entity
     * @return
     */
    List<T> list(@RequestBody T entity);

    /**
     * 根据参数创建分页条件
     * */
    Page createPage(T entity);

    /**
     * 根据参数创建分页查询条件
     * */
    Wrapper createPageWrapper(T entity);

    /**
     * 将参数追加到分页查询条件
     * */
    Wrapper appendWrapper(Wrapper wrapper, Field field, T entity);
}
