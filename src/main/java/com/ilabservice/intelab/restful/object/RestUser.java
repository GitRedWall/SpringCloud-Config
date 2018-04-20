package com.ilabservice.intelab.restful.object;

import com.ilabservice.intelab.model.User;

import java.util.Date;

public class RestUser {
    private String name;
    private String username;
    private String mobile;
    private String telephone;
    private String gender;
    private String email;
    private String headIcon;
    private String department;
    private String job;
    private String jobNum;
    private String companyDomain;
    private String verificationCode;
    private Integer bindMobile;
    private Integer bindEmail;
    private Integer alertNotificationType;
    private Date latestPasswordUpdateTime;

    public RestUser(User user){
        name = user.getName();
        username = user.getUserName();
        mobile = user.getMobile();
        telephone = user.getTelephone();
        gender = user.getGender();
        email = user.getEmail();
        headIcon = user.getHeadIcon();
        department = user.getDepartment();
        job = user.getJob();
        jobNum = user.getJobNumber();
        companyDomain = user.getCompany().getSysCode();
        verificationCode = user.getVerify() != null ? user.getVerify().toString() : "";
        bindMobile = user.getBindMobile();
        bindEmail = user.getBindEmail();
        alertNotificationType = user.getAlertNotificationType();
        latestPasswordUpdateTime = user.getLatestPasswordUpdateTime();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getMobile() {
        return mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public String getDepartment() {
        return department;
    }

    public String getJob() {
        return job;
    }

    public String getJobNum() {
        return jobNum;
    }

    public String getCompanyDomain() {
        return companyDomain;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public Integer getBindMobile() {
        return bindMobile;
    }

    public Integer getBindEmail() {
        return bindEmail;
    }

    public Integer getAlertNotificationType() {
        return alertNotificationType;
    }

    public Date getLatestPasswordUpdateTime() {
        return latestPasswordUpdateTime;
    }
}
