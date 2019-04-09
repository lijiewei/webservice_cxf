import com.ljw.webservice_cxf.interceptor.interceptor.LincenseInterceptor;
import com.ljw.webservice_cxf.service.ICalculateService;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2019/4/9 21:16
 */
public class CallTest {
    
    @Test
    public void jdkTest() {
//        ICalculateService calculateService = new CalculateService().getICalculateServicePort();
//        System.out.println(calculateService.add(1,3));
    }
    
    @Test
    public void CxfTest() {//只保留ICalculateService类，其他类可以删除
//        1.创建JaxWsProxyFactoryBean的对象，用于接收服务
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
//        2.设置服务的发布地址，表示去哪里过去服务
        jaxWsProxyFactoryBean.setAddress("http://192.168.0.108:9277/web_service/calculate");
//        3.设置服务的发布接口，使用本地的代理接口
        jaxWsProxyFactoryBean.setServiceClass(ICalculateService.class);

        //===================拦截器======================
        //官方提供日志拦截器
        jaxWsProxyFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        //自定义的许可拦截器
        jaxWsProxyFactoryBean.getOutInterceptors().add(new LincenseInterceptor("zhangsan" ,"123"));
        //===================拦截器======================

//        4.通过create方法返回接口代理实例
        ICalculateService calculateService = (ICalculateService) jaxWsProxyFactoryBean.create();
//        5.调用远程方法
        System.out.println(calculateService.add(2, 4));
    }
}
