package com.ilabservice.intelab.model;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import  com.ilabservice.intelab.model.BaseEntity;
import com.ilabservice.intelab.common.annotation.EnableParam;
import com.ilabservice.intelab.common.annotation.FillAuto;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;


/**
 * 
 *
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18 14:41:05
 */
@Data
@ApiModel(value = "login_user")
@TableName("login_user")
@Alias("loginUser")
public class LoginUser extends BaseEntity{

    /**
     * @data 注解是lombok的特性，自动生成 setter getter 方法
     * 集成Swagger API调试更加实用方便
     * 建议使用代码生成工具 entity controller service mapper 每一层都能生成，基本CRUD 基本不用写了，快速提升效率
     * */

	private static final long serialVersionUID = 1L;
	
    @ApiModelProperty(value = "")
    @TableId(value = "id")
    @FillAuto
    private Integer id;
	
    @ApiModelProperty(value = "公司编号")
    @EnableParam
    @TableField(value = "company_id")
    private Integer companyId;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "user_name")
    private String userName;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "password")
    private String password;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "name")
    private String name;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "head_icon")
    private String headIcon;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "mobile")
    private String mobile;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "telephone")
    private String telephone;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "gender")
    private String gender;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "email")
    private String email;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "department")
    private String department;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "job")
    private String job;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "job_number")
    private String jobNumber;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "bind_mobile")
    private Integer bindMobile;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "bind_email")
    private Integer bindEmail;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "verify")
    private Integer verify;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "create_datetime")
    private Date createDatetime;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "update_datetime")
    private Date updateDatetime;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "last_password_error_date")
    private Date lastPasswordErrorDate;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "password_error_retry_times")
    private Integer passwordErrorRetryTimes;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "latest_password_update_time")
    private Date latestPasswordUpdateTime;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "alert_notification_type")
    private Integer alertNotificationType;
	
    @ApiModelProperty(value = "")
    @EnableParam
    @TableField(value = "block_chain_address")
    private String blockChainAddress;


    @TableField(exist = false)
    private List<Roles> roles;

}
