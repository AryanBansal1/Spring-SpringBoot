package project_db.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project_db.demo.Model.Users;

@Repository
public interface Myrepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
    
}
