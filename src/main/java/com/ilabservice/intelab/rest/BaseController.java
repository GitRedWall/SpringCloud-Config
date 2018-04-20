package com.ilabservice.intelab.rest;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ilabservice.intelab.common.ObjectRestResponse;
import com.ilabservice.intelab.common.TableResultResponse;
import com.ilabservice.intelab.model.BaseEntity;
import com.ilabservice.intelab.service.base.BaseService;
import com.ilabservice.intelab.utils.StringHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 公用的controller
 * 基本CRUD方法 特殊需要重写即可
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18 11:57:00
 */
public class BaseController<Biz extends BaseService, Entity extends BaseEntity> {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增")
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity){
        baseBiz.add(entity);
        return new ObjectRestResponse<Entity>().rel(true);
    }

    public ObjectRestResponse<Entity> get(Serializable id){
        return new ObjectRestResponse<Entity>().rel(true).data(baseBiz.selectById(id));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("根据ID更新")
    public ObjectRestResponse<Entity> update(@RequestBody Entity entity){
        baseBiz.updateById(entity);
        return new ObjectRestResponse<Entity>().rel(true);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("根据ID删除")
    public ObjectRestResponse<Entity> remove(@PathVariable Integer id){

        baseBiz.deleteById(id);
        return new ObjectRestResponse<Entity>().rel(true);
    }

    @RequestMapping(value = "/removeBatch",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据ID批量删除")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "ids", value = "id用,分隔", dataType = "String", required = true)
    })
    public ObjectRestResponse<Entity> removeBatch(@RequestParam(value = "ids",required = true) String ids){

        List<String> idList = StringHelper.splitString(ids,",");
        baseBiz.deleteBatchIds(idList);
        return new ObjectRestResponse<Entity>().rel(true);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有")
    public List<Entity> all(){
        return baseBiz.selectList(new EntityWrapper<Entity>().where("1=1"));
    }

    @RequestMapping(value = "/updateBatch",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("根据ID批量更新")
    public ObjectRestResponse<Entity> updateBatch(@RequestBody List<Entity> entities){

        if(entities != null && entities.size() > 0)
            baseBiz.updateBatchById(entities);
        return new ObjectRestResponse<Entity>().rel(true);
    }

    /**
     * 分页查询公共方法
     * @param entity
     *
     * @return
     */
    public TableResultResponse page(Entity entity){
        return Optional.ofNullable(baseBiz.page(entity))
                .map(results -> new TableResultResponse(results.getTotal(), results.getRecords()))
                .orElseGet(() -> new TableResultResponse(0, Collections.EMPTY_LIST));

    }
    /**
     * 公用方法，查询返回实体，可分页，可不分页
     * @param entity
     * @return
     */
    public List<Entity> list(@RequestBody Entity entity){
        return baseBiz.list(entity);
    }

}
