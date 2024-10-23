package db.demo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Myrepo extends JpaRepository<Employee,Long>  {
    
    
}
