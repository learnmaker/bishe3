package com.yuan.relation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.relation.entity.Relation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Relation)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-18 22:13:07
 */
@Repository
public interface RelationDao extends BaseMapper<Relation> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Relation> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Relation> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Relation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Relation> entities);

}

