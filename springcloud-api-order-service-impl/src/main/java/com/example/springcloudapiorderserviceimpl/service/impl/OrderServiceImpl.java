package com.example.springcloudapiorderserviceimpl.service.impl;

import com.example.springcloudapiorderserviceimpl.feign.MemberServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ykm.springcloudapimemberservice.api.entity.UserEntity;
import com.ykm.springcloudapiorderservice.api.service.IOrderService;
import com.ykm.springcloudcommon.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ykm
 * @Date 2019/12/30 16:47
 */
@RestController
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @RequestMapping("/")
    public String index(){
        return "调用订单服务中。。。";
    }

    @Override
    @RequestMapping("/orderToMember")
    public String orderToMember(String name) {
        UserEntity member = memberServiceFeign.getMember(name);
        return member==null?"没有用户信息":member.toString();
    }

    @Override
    @RequestMapping("/orderToMemberUserInfo")
    public CommonReturnType orderToMemberUserInfo() {
        System.err.println("orderToMemberUserInfo线程池信息："+Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    @RequestMapping("/orderToMemberUserInfoHystrix")
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    // (猜想) 默认1s下orderToMemberUserInfoHystrix没有返回（方法未执行完），将调用fallbackMethod指向的方法返回，但是不影响原方法的执行
    public CommonReturnType orderToMemberUserInfoHystrix() {
        System.err.println("orderToMemberUserInfoHystrix线程池信息："+Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    @RequestMapping("/orderToMemberUserInfoHystrixV2")
    public CommonReturnType orderToMemberUserInfoHystrixV2() {
        System.err.println("orderToMemberUserInfoHystrix线程池信息："+Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    public CommonReturnType orderToMemberUserInfoHystrixFallback(){
        return CommonReturnType.create("服务降级中。。。请稍后重试！");
    }

    @RequestMapping("/orderInfo")
    public CommonReturnType orderInfo(){
        System.err.println("orderInfo线程池信息："+Thread.currentThread().getName());
        return CommonReturnType.create("orderInfo成功！");
    }
}
