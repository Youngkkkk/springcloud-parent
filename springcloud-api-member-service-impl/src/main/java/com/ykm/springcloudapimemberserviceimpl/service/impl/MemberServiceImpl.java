package com.ykm.springcloudapimemberserviceimpl.service.impl;

import com.ykm.springcloudapimemberservice.api.entity.UserEntity;
import com.ykm.springcloudapimemberservice.api.service.IMemberService;
import com.ykm.springcloudcommon.response.CommonReturnType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ykm
 * @Date 2019/12/30 16:29
 */
@RestController
public class MemberServiceImpl implements IMemberService {

    @RequestMapping("/")
    public String index(){
        return "调用会员服务中。。。";
    }

    @Override
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(23);
        return userEntity;
    }

    @Override
    @RequestMapping("/getUserInfo")
    public CommonReturnType getUserInfo() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("member服务还是执行完了");
        return CommonReturnType.create(null);
    }
}
