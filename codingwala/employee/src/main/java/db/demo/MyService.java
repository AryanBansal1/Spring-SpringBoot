package db.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyService {
    
    @Autowired
    MyrepoImp repoimp;

    public void add(Employee employee){
        repoimp.add_emp(employee);
    };
    public void delete(Long id){
        repoimp.delete_emp(id);

    };
    public void update(Long id , Employee emp){
        repoimp.update_emp(id,emp);
    };
    public List<Employee> read(){
        return repoimp.read_emp();
    };
}
