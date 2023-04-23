package com.yuan.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.user.dao.ParentDao;
import com.yuan.user.entity.Parent;
import com.yuan.user.service.ParentService;
import org.springframework.stereotype.Service;

/**
 * (Parent)表服务实现类
 *
 * @author makejava
 * @since 2023-04-18 16:30:21
 */
@Service("parentService")
public class ParentServiceImpl extends ServiceImpl<ParentDao, Parent> implements ParentService {

}

