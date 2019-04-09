package com.ljw.webservice_cxf.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @Description: 计算器服务接口
 * @Author: Administrator
 * @CreateDate: 2019/4/9 0:06
 */
@WebService(serviceName = "CalculateService")
public interface ICalculateService {

    @WebResult(name="result")
    int add(@WebParam(name="num1") int num1, @WebParam(name="num2")int num2);
}
