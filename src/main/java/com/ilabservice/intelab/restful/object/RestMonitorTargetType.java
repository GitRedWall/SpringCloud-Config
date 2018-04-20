package com.ilabservice.intelab.restful.object;

import com.ilabservice.intelab.model.MonTargetType;

public class RestMonitorTargetType {

    private Long id;
    private String name;
    private String description;
    private String logo_url;

    public RestMonitorTargetType(MonTargetType monTargetType){
        id = monTargetType.getId();
        name = monTargetType.getName() != null ? monTargetType.getName() : "";
        description = monTargetType.getDescription() != null ? monTargetType.getDescription() : "";
        logo_url = monTargetType.getLogoURL() != null ? monTargetType.getLogoURL() : "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }
}
