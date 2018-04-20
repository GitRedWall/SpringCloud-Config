package com.ilabservice.intelab.rest;

import com.ilabservice.intelab.common.ObjectRestResponse;
import com.ilabservice.intelab.common.TableResultResponse;
import com.ilabservice.intelab.rest.BaseController;
import com.ilabservice.intelab.model.LoginUser;
import com.ilabservice.intelab.service.loginuser.LoginUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;

/**
 * 
 *
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18 14:41:05
 */
@Controller
@RequestMapping("loginUser")
@Api(description = "登陆用户")
@Slf4j
public class LoginUserController extends BaseController<LoginUserService,LoginUser> {

    @Autowired
    private LoginUserService loginUserService;

    @RequestMapping(value = "page",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("分页模糊查询")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", dataType = "Integer", required = false),
            @ApiImplicitParam(paramType = "query", name = "current", value = "当前页", dataType = "Integer", required = false)
    })
    public TableResultResponse page(
            @RequestParam(value = "size", required = false,defaultValue = "10") Integer size,
            @RequestParam(value = "current", required = false,defaultValue = "0") Integer current){
        log.info("查询用户");
        LoginUser a = new LoginUser();

        a.setSize(size);
        a.setCurrent(current);
        return this.page(a);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据ID查询")
    public ObjectRestResponse<LoginUser> get(@PathVariable Serializable id){
        return super.get(id);
    }


    @ApiOperation("根据用户编号获取用户角色和权限信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "path", name = "id", value = "编号", dataType = "Integer", required = true)
    })
    @GetMapping(value = "getUserRoleAndPermissions/{id}")
    @ResponseBody
    public ObjectRestResponse<LoginUser> getUserRoleAndPermissions(@PathVariable("id") Integer id){
        return new ObjectRestResponse<>().rel(true).data(loginUserService.getUserRoleAndPermissionsByUserID(id));
    }




}