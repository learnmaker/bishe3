package com.yuan.relation.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.yuan.user.entity.Parent;
import com.yuan.user.entity.Student;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * (Relation)表实体类
 *
 * @author makejava
 * @since 2023-04-18 22:13:07
 */
@Data
@SuppressWarnings("serial")
public class Relation extends Model<Relation> {

    @TableId
    private String relId;

    private String stuId;

    private String parId;

    private String relName;

    @Transient
    @TableField(exist = false)
    private Student student;

    @Transient
    @TableField(exist = false)
    private Parent parent;

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.relId;
    }
}

