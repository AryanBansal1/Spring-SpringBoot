package db.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class MyrepoImp  {
    @Autowired
    Myrepo repo ;
    
    public void add_emp(Employee employee){
        repo.save(employee);
    }

    public List<Employee> read_emp(){
        List<Employee> emp = repo.findAll();
        return emp;
    }
    public void delete_emp(Long id){
        Employee emp = repo.findById(id).get();
        repo.delete(emp);
    }
    public void update_emp(Long id , Employee emp){
        Employee existingEmployee = repo.findById(id).get();
        existingEmployee.setEmail(emp.getEmail());
        existingEmployee.setName(emp.getName());
        existingEmployee.setPhone(emp.getPhone());
        repo.save(existingEmployee);
    }
}
