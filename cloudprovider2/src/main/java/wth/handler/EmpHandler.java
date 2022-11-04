package wth.handler;

import com.wth.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EmpHandler {

    @RequestMapping("/provider/get/emp/remote")
    public Employee getEmpRemote(HttpServletRequest request){
        int serverPort = request.getServerPort();
        System.out.println("provider - emp");
        return new Employee(555,"tom333"+serverPort,123.123);
    }
}
