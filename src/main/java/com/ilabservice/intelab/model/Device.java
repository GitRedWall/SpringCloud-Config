package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private String name;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    private String photo;

    private String manufacturer;

    @Column(name = "product_model")
    private String productModel;

    @Column(name = "health_score")
    private Float healthScore;

    @Column(name = "create_datetime")
    private Date createDateTime;

    public Device() {
    }

    public Device(String code, String name, Date purchaseDate, String photo, String manufacturer, String productModel,
                  Float healthScore, Date createDateTime) {
        this.code = code;
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.photo = photo;
        this.manufacturer = manufacturer;
        this.productModel = productModel;
        this.healthScore = healthScore;
        this.createDateTime = createDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Float getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(Float healthScore) {
        this.healthScore = healthScore;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
