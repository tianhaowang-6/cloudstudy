package com.wth.handler;

import com.wth.entity.Employee;
import com.wth.entity.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wth.service.EmployeeRemoteService;

@RestController
public class EmpFeignHandler {
    // 看似进行本地调用，实际上调用了common程序的service，然后通过feign调用了
    @Autowired
    private EmployeeRemoteService employeeRemoteService;
    @RequestMapping("/feign/consumer/get/emp/by/id")
    public Employee getEmployeeByIdRemote(@RequestParam("empId") Integer empId) {
        return employeeRemoteService.getEmployeeById(empId);
    }

    @RequestMapping("/feign/consumer/get/emp")
    public Employee getEmployeeRemote() {
        return employeeRemoteService.getEmployeeRemote();
    }


    @RequestMapping("/feign/consumer/get/emp/break")
    public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal){
        System.out.println("EmpFeignHandler ------");
        return employeeRemoteService.getEmp(signal);
    }


}
