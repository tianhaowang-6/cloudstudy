package com.wth.handler;

import com.wth.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HumanResourceHandler {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consume/get/emp")
    public Employee getEmployeeRemote(){
//        String host="http://localhost:1000";
        System.out.println("haha");
        // eureka+ribbon 可以通过微服务名代替ip+端口号
        String host="http://cloud-provider";
        System.out.println("/consume/get/emp");
        String url="/provider/get/emp/remote";
        System.out.println(host+url);
        return restTemplate.getForObject(host+url,Employee.class);
    }
    //
    @RequestMapping("/consumer/ribbon/get/employee")
    public Employee getEmployeeRemote1() {
// 远程调用方法的主机地址
// String host = "http://localhost:1000";
// 引入 Eureka 和 Ribbon 后，就可以使用微服务名称替代 IP 地址+端口号
        String host = "http://cloud-provider";
// 远程调用方法的具体 URL 地址
        String url = "/provider/get/emp/remote";
        return restTemplate.getForObject(host + url, Employee.class);
    }
}
