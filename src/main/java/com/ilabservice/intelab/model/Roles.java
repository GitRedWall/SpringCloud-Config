package com.ilabservice.intelab.model;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-20
 * @desc 用户角色
 */
@Data
@TableName("role_definition")
public class Roles extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField(value = "name")
    private String roleName;

    @TableField(value = "description")
    private String roleDesc;

    @TableField(value = "role_type")
    private String roleType;

    @TableField(value = "create_datetime")
    private Date createDateTime;

    @TableField(exist = false)
    private List<Permissions> permissions;

}
