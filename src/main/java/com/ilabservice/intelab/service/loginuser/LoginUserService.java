package com.ilabservice.intelab.service.loginuser;


import com.ilabservice.intelab.model.LoginUser;
import com.ilabservice.intelab.service.base.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * 
 *
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18 14:41:05
 */
public interface LoginUserService extends BaseService<LoginUser> {

    /**
     * 根据用户ID获取用户信息和其角色及权限
     *
     * */
    LoginUser getUserRoleAndPermissionsByUserID(Serializable id);
}