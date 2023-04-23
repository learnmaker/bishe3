package com.yuan.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.user.config.PatternProperties;
import com.yuan.user.entity.Parent;
import com.yuan.user.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

/**
 * (Parent)表控制层
 *
 * @author makejava
 * @since 2023-04-18 16:30:21
 */
@RestController
@RequestMapping("parent")
public class ParentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ParentService parentService;


    @Autowired
    private PatternProperties properties;

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    @GetMapping("prop")
    public PatternProperties properties(){
        return properties;
    }

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param parent 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Parent> page, Parent parent) {
        return success(this.parentService.page(page, new QueryWrapper<>(parent)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.parentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param parent 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Parent parent) {
        return success(this.parentService.save(parent));
    }

    /**
     * 修改数据
     *
     * @param parent 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Parent parent) {
        return success(this.parentService.updateById(parent));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.parentService.removeByIds(idList));
    }
}

