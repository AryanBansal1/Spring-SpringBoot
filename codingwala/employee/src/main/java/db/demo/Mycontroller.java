package db.demo;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
    @Autowired
    MyService service;

    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        return service.read();
    }
    @PostMapping("employees")
    public  void addEmployee(@RequestBody Employee employee){
        service.add(employee);
    }
    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        service.delete(id);
    }
    @PutMapping("employees/{id}")
    public void updateEmployee(@PathVariable Long id , @RequestBody Employee emp){
        service.update(id,emp);
    }
}
