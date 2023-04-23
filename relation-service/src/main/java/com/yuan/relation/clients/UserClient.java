package com.yuan.relation.clients;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

@FeignClient(value = "userservice")
public interface UserClient {
    @GetMapping("/parent/{id}")
    R findByParentId(@PathVariable("id") Serializable id);

    @GetMapping("/student/{id}")
    R findByStudentId(@PathVariable("id") Serializable id);
}
