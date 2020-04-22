package com.ykm.springcloudapiorderservice.api.service;

import com.ykm.springcloudcommon.response.CommonReturnType;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ykm
 * @Date 2019/12/30 16:45
 */
public interface IOrderService {

    //@RequestMapping("/orderToMember")
    String orderToMember(String name);

    CommonReturnType orderToMemberUserInfo();
}
