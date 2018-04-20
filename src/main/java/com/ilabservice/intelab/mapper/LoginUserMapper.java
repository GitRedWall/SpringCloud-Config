package com.ilabservice.intelab.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ilabservice.intelab.model.LoginUser;
import com.ilabservice.intelab.model.Permissions;
import com.ilabservice.intelab.model.Roles;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * 
 *
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18 14:41:05
 */
@Mapper
public interface LoginUserMapper extends BaseMapper<LoginUser> {

    public List<Roles> listAllRolesByUserid(Serializable userid);

    public List<Permissions> listAllPermissionsByRoleid(Serializable roleid);
	
}
