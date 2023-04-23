package com.yuan.relation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.relation.entity.Relation;

import java.io.Serializable;

/**
 * (Relation)表服务接口
 *
 * @author makejava
 * @since 2023-04-18 22:13:08
 */
public interface RelationService extends IService<Relation> {
    public Relation mygetById(Serializable id);
}

