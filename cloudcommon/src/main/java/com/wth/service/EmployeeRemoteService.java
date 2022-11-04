package com.wth.service;

import com.wth.entity.Employee;
import com.wth.entity.ResultEntity;
import com.wth.error.MyFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 在@FeignClient 注解中增加 fallbackFactory 属性
// 指定 consumer 调用 provider 时如果失败所采取的备用方案
// fallbackFactory 指定 FallbackFactory 类型的类，保证备用方案返回相同类型的数据
//@FeignClient("cloud-provider")
@FeignClient(value="cloud-provider", fallbackFactory= MyFallBackFactory.class)
public interface EmployeeRemoteService {
    @RequestMapping("/provider/get/employee/by/id")
    public Employee getEmployeeById(@RequestParam("empId") Integer empId);
    @RequestMapping("/provider/get/emp/remote")
    public Employee getEmployeeRemote();
    @RequestMapping("/provider/circuit/breaker/get/emp")
    public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal);
}
