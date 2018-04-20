package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "common_lookup")
public class CommonLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_desc")
    private String categoryDesc;

    private String code;

    private String value;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "create_datetime")
    private Date createDateTime;

    public CommonLookup() {
    }

    public CommonLookup(String categoryName, String categoryDesc, String code, String value, Integer sortOrder,
                        Date createDateTime) {
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.code = code;
        this.value = value;
        this.sortOrder = sortOrder;
        this.createDateTime = createDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
