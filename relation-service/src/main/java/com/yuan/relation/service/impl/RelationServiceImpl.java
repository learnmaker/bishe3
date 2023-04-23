package com.yuan.relation.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.relation.clients.UserClient;
import com.yuan.relation.dao.RelationDao;
import com.yuan.relation.entity.Relation;
import com.yuan.relation.service.RelationService;
import com.yuan.user.entity.Parent;
import com.yuan.user.entity.Student;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * (Relation)表服务实现类
 *
 * @author makejava
 * @since 2023-04-18 22:13:08
 */
@Service("relationService")
public class RelationServiceImpl extends ServiceImpl<RelationDao, Relation> implements RelationService {

    @Autowired
    private RelationDao relationDao;

    @Autowired
    private UserClient userClient;

    public Relation mygetById(Serializable id){
        Relation relation=relationDao.selectById(id);

        R par_res=userClient.findByParentId(relation.getParId());
        JSONObject jsonObject=JSONObject.fromObject(par_res.getData()); // 将数据转成json字符串
        Parent parent = (Parent) JSONObject.toBean(jsonObject, Parent.class); //将json转成需要的对象

        R stu_res=userClient.findByStudentId(relation.getStuId());
        JSONObject jsonObject1=JSONObject.fromObject(stu_res.getData()); // 将数据转成json字符串
        Student student = (Student) JSONObject.toBean(jsonObject1, Student.class); //将json转成需要的对象

        relation.setParent(parent);
        relation.setStudent(student);
        return relation;
    }
}

