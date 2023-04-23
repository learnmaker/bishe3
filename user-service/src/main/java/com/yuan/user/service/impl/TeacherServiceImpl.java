package com.yuan.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.user.dao.TeacherDao;
import com.yuan.user.entity.Teacher;
import com.yuan.user.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * (Teacher)表服务实现类
 *
 * @author makejava
 * @since 2023-04-18 16:20:43
 */
@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {

}

