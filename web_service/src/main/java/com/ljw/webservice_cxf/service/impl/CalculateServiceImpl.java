package com.ljw.webservice_cxf.service.impl;

import com.ljw.webservice_cxf.service.ICalculateService;

import javax.jws.WebService;

/**
 * @Description: 计算器服务实现类
 * @Author: Administrator
 * @CreateDate: 2019/4/9 0:08
 */
@WebService(endpointInterface = "com.ljw.webservice_cxf.service.ICalculateService")
public class CalculateServiceImpl implements ICalculateService {

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
