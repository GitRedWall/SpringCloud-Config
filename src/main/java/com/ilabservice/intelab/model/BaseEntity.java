package com.ilabservice.intelab.model;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * 实体的公用类，一些公用的属性
 * @author RedWall
 * @email walkmanlucas@gmail.com
 * @date 2018-04-18
 */
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    //当前页
    @TableField(exist = false)
    private Integer current = 1;

    //页大小
    @TableField(exist = false)
    private Integer size = 10;

    /**
     * sql分页查询时用到，起始
     */
    @TableField(exist = false)
    private Integer startRow;

    public Integer getStartRow(){

        if(current != null && size != null)
            return current *size - size;
        else
            return 0;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
