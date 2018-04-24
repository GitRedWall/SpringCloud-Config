package com.ilabservice.intelab.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-20
 * @desc 用户权限
 */
@Data
@TableName("permission")
public class Permissions extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField(value = "permission_type")
    private String permissionType;

    @TableField(value = "name")
    private String permissionName;

    @TableField(value = "description")
    private String permissionDesc;

    @TableField(value = "create_datetime")
    private Date createDatetime;
}
