package com.yuan.user.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Parent)表实体类
 *
 * @author makejava
 * @since 2023-04-18 16:30:21
 */
@Data
@SuppressWarnings("serial")
public class Parent extends Model<Parent> {

    @TableId
    private String parId;

    private String parName;

    private String parSex;

    private Integer parAge;

    private String parPhone;


    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId;
    }

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName = parName;
    }

    public String getParSex() {
        return parSex;
    }

    public void setParSex(String parSex) {
        this.parSex = parSex;
    }

    public Integer getParAge() {
        return parAge;
    }

    public void setParAge(Integer parAge) {
        this.parAge = parAge;
    }

    public String getParPhone() {
        return parPhone;
    }

    public void setParPhone(String parPhone) {
        this.parPhone = parPhone;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.parId;
    }
}

