package com.example.springcloudapiorderserviceimpl.fallback;

import com.example.springcloudapiorderserviceimpl.feign.MemberServiceFeign;
import com.ykm.springcloudapimemberservice.api.entity.UserEntity;
import com.ykm.springcloudcommon.response.CommonReturnType;
import org.springframework.stereotype.Component;

/**
 * @Author ykm
 * @Date 2020/1/2 14:04
 */
@Component
public class MemberServiceFallback implements MemberServiceFeign {
    @Override
    public UserEntity getMember(String name) {
        return null;
    }

    @Override
    public CommonReturnType getUserInfo() {
        return CommonReturnType.create("Hystrix第二种写法：服务器忙，请稍后重试！");
    }
}
