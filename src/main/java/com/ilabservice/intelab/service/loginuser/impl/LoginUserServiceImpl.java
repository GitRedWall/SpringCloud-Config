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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Serializable id) {
        UserRolesMap userRolesMap = new UserRolesMap();
        userRolesMap.setUserID(String.valueOf(id));
        // 在映射关系这张表中把所有user_id 为 指定id 的用户删除
        userRolesMapper.delete(new EntityWrapper<>(userRolesMap));
        return loginUserMapper.deleteById(id) == 1 ? true : false;
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