package com.ilabservice.intelab.model.enums;

/**
 * 填充字段的类型
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18
 */
public enum FillAutoValueType {

    UUID(0,"自动填充字段为UUID32位"),
    DATE(1,"自动填充字段为yyyy-MM-dd HH:mm:dd");

    private Integer key;
    private String desc;

    FillAutoValueType(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
