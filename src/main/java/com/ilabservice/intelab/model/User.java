package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "login_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String name;

    @Column(name = "head_icon")
    private String headIcon;

    private String mobile;

    private String telephone;

    private String gender;

    private String email;

    private String department;

    private String job;

    @Column(name = "job_number")
    private String jobNumber;

    @Column(name = "bind_mobile")
    private Integer bindMobile;

    @Column(name = "bind_email")
    private Integer bindEmail;

    private Integer verify;

    @Column(name = "create_datetime")
    private Date createDateTime;

    @Column(name = "update_datetime")
    private Date updateDateTime;

    @Column(name = "latest_password_update_time")
    private Date latestPasswordUpdateTime;

    @Column(name = "alert_notification_type")
    private Integer alertNotificationType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "site_role_user_map",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false)})
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Company company, String userName, String password, String name, String headIcon, String mobile,
                String telephone, String gender, String email, String department, String job, String jobNumber,
                Integer bindMobile, Integer bindEmail, Integer verify, Date createDateTime, Date updateDateTime) {
        this.company = company;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.headIcon = headIcon;
        this.mobile = mobile;
        this.telephone = telephone;
        this.gender = gender;
        this.email = email;
        this.department = department;
        this.job = job;
        this.jobNumber = jobNumber;
        this.bindMobile = bindMobile;
        this.bindEmail = bindEmail;
        this.verify = verify;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Integer getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(Integer bindMobile) {
        this.bindMobile = bindMobile;
    }

    public Integer getBindEmail() {
        return bindEmail;
    }

    public void setBindEmail(Integer bindEmail) {
        this.bindEmail = bindEmail;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Date getLatestPasswordUpdateTime() {
        return latestPasswordUpdateTime;
    }

    public void setLatestPasswordUpdateTime(Date latestPasswordUpdateTime) {
        this.latestPasswordUpdateTime = latestPasswordUpdateTime;
    }

    public Integer getAlertNotificationType() {
        return alertNotificationType;
    }

    public void setAlertNotificationType(Integer alertNotificationType) {
        this.alertNotificationType = alertNotificationType;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

}
