package com.wth.error;

import com.wth.entity.Employee;
import com.wth.entity.ResultEntity;
import com.wth.service.EmployeeRemoteService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {
    // cause 对象是失败原因对应的异常对象
    @Override
    public EmployeeRemoteService create(Throwable cause) {
        return new EmployeeRemoteService() {
            @RequestMapping("/provider/save/emp")
            public Employee saveEmp(@RequestBody Employee employee) {
                return null;
            }
            @RequestMapping("/provider/get/emp/by/id")
            public Employee getEmployeeById(@RequestParam("empId") Integer empId) {
                return null;
            }

            @RequestMapping("/provider/circuit/breaker/get/emp")
            public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal){
                System.out.println("getEmp");
                return new ResultEntity<>();
            }

            @RequestMapping("/provider/get/emp/remote")
            public Employee getEmployeeRemote() {
                System.out.println("MyFallBackFactory+getEmployeeRemote");
                return new Employee(444, "call provider failed,fall back here, reason is "+cause.getClass().getName()+" "+cause.getMessage(), 444.444);
            }
        };
    }
}
