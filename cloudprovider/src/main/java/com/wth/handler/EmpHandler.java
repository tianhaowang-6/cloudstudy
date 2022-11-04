package com.wth.handler;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wth.entity.Employee;
import com.wth.entity.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EmpHandler {
    @RequestMapping("/provider/get/employee/by/id")
    public Employee getEmployeeById(@RequestParam("empId") Integer empId) {
        return new Employee(empId, "tom999-", 999.99);
    }

    @RequestMapping("/provider/get/emp/remote")
    public Employee getEmpRemote(HttpServletRequest request){
        int serverPort = request.getServerPort();
        System.out.println("provider - emp");
        return new Employee(555,"tom333"+serverPort,123.123);
    }


    @HystrixCommand(fallbackMethod = "getEmpBackup")
    @RequestMapping("/provider/circuit/breaker/get/emp")
    public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal) {
        System.out.println("getEmp!!!!!!!!!!");
        System.out.println("signal="+signal+"bang".equals(signal));
        if("bang".equals(signal)) {
            throw new RuntimeException();
        }
        return ResultEntity.successWithData(new Employee(666, "sam666", 666.66));
    }

    public ResultEntity<Employee> getEmpBackup(@RequestParam("signal") String signal) {
        return ResultEntity.failed("circuit break workded,with signal="+signal);
    }
}
