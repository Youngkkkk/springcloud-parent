package com.ykm.springcloudcommon.error;

/**
 * @Author ykm
 * @Date 2019/10/17 16:13
 */
public interface CommonError {
    int getErrCode();

    String getErrMsg();

    CommonError setErrMsg(String errMsg);
}
