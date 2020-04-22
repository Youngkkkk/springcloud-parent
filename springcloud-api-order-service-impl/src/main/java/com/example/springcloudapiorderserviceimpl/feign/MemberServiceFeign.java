package com.example.springcloudapiorderserviceimpl.feign;

import com.example.springcloudapiorderserviceimpl.fallback.MemberServiceFallback;
import com.ykm.springcloudapimemberservice.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author ykm
 * @Date 2019/12/30 16:53
 */
@FeignClient(value = "app-member", fallback = MemberServiceFallback.class)
public interface MemberServiceFeign extends IMemberService {
}
