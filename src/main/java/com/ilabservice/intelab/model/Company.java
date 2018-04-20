package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "company")
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sys_code")
    private String sysCode;

    private String name;

    private String address;

    private String email;

    private String telephone;

    @Column(name = "contract_no")
    private String contractNo;

    @Column(name = "sign_date")
    private Date signDate;

    @Column(name = "contract_start_date")
    private Date contractStartDate;

    @Column(name = "login_url")
    private String loginUrl;

    @Column(name = "background_url")
    private String backgroundUrl;

    private String logo;

    @Column(name = "create_datetime")
    private Date createDatetime;

    @Column(name = "update_datetime")
    private Date updateDatetime;

    @Column(name = "contract_end_date")
    private Date contractEndDate;

    public Company() {
    }

    public Company(String sysCode, String name, String address, String email, String telephone, String contractNo,
                   Date signDate, Date contractStartDate, String loginUrl, String backgroundUrl, String logo,
                   Date createDatetime, Date updateDatetime, Date contractEndDate) {
        this.sysCode = sysCode;
        this.name = name;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.contractNo = contractNo;
        this.signDate = signDate;
        this.contractStartDate = contractStartDate;
        this.loginUrl = loginUrl;
        this.backgroundUrl = backgroundUrl;
        this.logo = logo;
        this.createDatetime = createDatetime;
        this.updateDatetime = updateDatetime;
        this.contractEndDate = contractEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }
}
