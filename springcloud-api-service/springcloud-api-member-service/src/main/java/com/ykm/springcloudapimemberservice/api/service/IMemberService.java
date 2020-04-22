package com.ykm.springcloudapimemberservice.api.service;

import com.ykm.springcloudapimemberservice.api.entity.UserEntity;
import com.ykm.springcloudcommon.response.CommonReturnType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ykm
 * @Date 2019/12/30 16:17
 */
public interface IMemberService {

    @RequestMapping("/getMember")
    UserEntity getMember(@RequestParam("name") String name);

    @RequestMapping("/getUserInfo")
    CommonReturnType getUserInfo();
}
