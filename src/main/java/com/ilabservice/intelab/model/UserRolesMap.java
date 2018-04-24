package com.ilabservice.intelab.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName(value = "site_role_user_map")
public class UserRolesMap extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField(value = "role_id")
    private String roleID;

    @TableField(value = "user_id")
    private String userID;
}
