package demo.codingwala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Mycontroller {
    @PostMapping("process")
    @ResponseBody
    public String add(@RequestParam int num1 ,@RequestParam int num2){
        System.out.println(num1+ num2);
        return String.valueOf(num1+num2);
    }
}
