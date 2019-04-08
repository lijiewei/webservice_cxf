package com.ljw.webservice_cxf;

import com.ljw.webservice_cxf.service.ICalculateService;
import com.ljw.webservice_cxf.service.impl.CalculateServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.xml.ws.Endpoint;

/**
 * @Description: 发布服务
 * @Author: Administrator
 * @CreateDate: 2019/4/9 0:11
 */
public class Publish {

    public static void main(String[] args) {
        testByCXF();
    }

    //cxf方式发布
    public static void testByCXF() {
//        1.创建JaxWsServerFactoryBean的对象，用于发布服务
        JaxWsServerFactoryBean jaxWsServiceFactoryBean = new JaxWsServerFactoryBean();
//        2.设置服务发布地址
        jaxWsServiceFactoryBean.setAddress("http://192.168.0.108:9277/web_service/calculate");
//        3.设置服务发布的接口
        jaxWsServiceFactoryBean.setServiceClass(ICalculateService.class);
//        4.设置服务的发布对象
        jaxWsServiceFactoryBean.setServiceBean(new CalculateServiceImpl());
//        5.使用create方法发布服务
        jaxWsServiceFactoryBean.create();

        System.out.println("计算器服务发布成功");
    }


    //jdk方式发布
    public static void testByJDK() {
        //服务发布地址,ip为本机，端口自己定义,访问wsdl需要加?wsdl
        String address = "http://192.168.0.108:9277/web_service/calculate";
        //服务的实现类
        Object implementor = new CalculateServiceImpl();
        //发布服务
        Endpoint.publish(address, implementor);

        System.out.println("计算器服务发布成功");
    }
}
