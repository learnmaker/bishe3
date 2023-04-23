package com.yuan.relation.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.relation.entity.Relation;
import com.yuan.relation.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Relation)表控制层
 *
 * @author makejava
 * @since 2023-04-18 22:13:07
 */
@RestController
@RequestMapping("relation")
public class RelationController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RelationService relationService;

    @Autowired
    private RestTemplate template;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param relation 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Relation> page, Relation relation) {
        return success(this.relationService.page(page, new QueryWrapper<>(relation)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {

//        Relation relation=this.relationService.getById(id);
//        String parentUrl="http://userservice/parent/"+relation.getParId();
//        R par_res = template.getForObject(parentUrl, R.class);
//        JSONObject jsonObject=JSONObject.fromObject(par_res.getData()); // 将数据转成json字符串
//        Parent parent = (Parent) JSONObject.toBean(jsonObject, Parent.class); //将json转成需要的对象
//        System.out.println("parent: "+parent);

        return success(this.relationService.mygetById(id));
//
//        String studentUrl="http://userservice/student/"+relation.getStuId();
//        R stu_res=template.getForObject(studentUrl, R.class);
//        JSONObject jsonObject1=JSONObject.fromObject(stu_res.getData()); // 将数据转成json字符串
//        Student student = (Student) JSONObject.toBean(jsonObject1, Student.class); //将json转成需要的对象
//        relation.setStudent(student);
//
//        System.out.println(relation);
//        return success(relation);
    }

    /**
     * 新增数据
     *
     * @param relation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Relation relation) {
        return success(this.relationService.save(relation));
    }

    /**
     * 修改数据
     *
     * @param relation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Relation relation) {
        return success(this.relationService.updateById(relation));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.relationService.removeByIds(idList));
    }
}

