package com.ilabservice.intelab.service.loginuser.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ilabservice.intelab.mapper.LoginUserMapper;
import com.ilabservice.intelab.mapper.PermissionsMapper;
import com.ilabservice.intelab.mapper.RolesMapper;
import com.ilabservice.intelab.mapper.UserRolesMapper;
import com.ilabservice.intelab.model.LoginUser;
import com.ilabservice.intelab.model.Permissions;
import com.ilabservice.intelab.model.Roles;
import com.ilabservice.intelab.model.UserRolesMap;
import com.ilabservice.intelab.service.base.impl.BaseServiceImpl;
import com.ilabservice.intelab.service.loginuser.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 
 *
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18 14:41:05*/

@Service
public class LoginUserServiceImpl extends BaseServiceImpl<LoginUserMapper,LoginUser> implements LoginUserService {

    @Autowired
    LoginUserMapper loginUserMapper;

    @Autowired
    RolesMapper rolesMapper;

    @Autowired
    PermissionsMapper permissionsMapper;

    @Autowired
    UserRolesMapper userRolesMapper;


    /**
     * 删除用户需要同时把用户和角色的关联关系删除
     * 其他有关联关系的同样操作几张表即可
     * */
    /**
     * @Retryable注解
     * 被注解的方法发生异常时会重试
        value			指定发生的异常进行重试
        include			和value一样，默认空，当exclude也为空时，所有异常都重试
        exclude 		指定异常不重试，默认空，当include也为空时，所有异常都重试
        maxAttemps:  	重试次数，默认3
        backoff   		重试补偿机制，默认没有
        RetryOperations定义了重试的API，RetryTemplate提供了模板实现，线程安全的，
        同于Spring 一贯的API风格，RetryTemplate将重试、熔断功能封装到模板中，提供健壮和不易出错的API供大家使用。
        backoff 重试机制有很多种
                1：固定时间重试
                2：随机时间重试
                3：渐变式重试  比如一开始1秒钟重试一次，再5秒重试一次，等等类似等差或者等比数列这种
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    /**
     * maxAttempts 最大重试次数
     * backoff 100-500 毫秒之间
     *
     * */
    @Retryable(value = { Exception.class }, maxAttempts = 3, backoff = @Backoff(delay=100, maxDelay=500))
    public boolean deleteById(Serializable id) {
        UserRolesMap userRolesMap = new UserRolesMap();
        userRolesMap.setUserID(String.valueOf(id));
        // 在映射关系这张表中把所有user_id 为 指定id 的用户删除
        userRolesMapper.delete(new EntityWrapper<>(userRolesMap));
        return loginUserMapper.deleteById(id) == 1 ? true : false;
    }

    @Recover
    public boolean recover(Exception e,Serializable id) {
        /**
         * 重试方法中的参数必须和原方法的参数一致
         * */
        return this.deleteById(id);
    }


    @Override
    public LoginUser getUserRoleAndPermissionsByUserID(Serializable id){
        LoginUser loginUser = loginUserMapper.selectById(id);
        List<Roles> roles = loginUserMapper.listAllRolesByUserid(id);
        if (!roles.isEmpty()){
            loginUser.setRoles(roles);
            roles.forEach(role -> {
                List<Permissions> permissions = loginUserMapper.listAllPermissionsByRoleid(role.getId());
                if (!permissions.isEmpty()){
                    role.setPermissions(permissions);
                }
            });
        }
        return loginUser;
    }



}