package practice.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practice.demo.Model.Users;;

@Repository
public interface Myrepo extends JpaRepository<Users,Integer> {
    
    Users findByUsername(String username);
}
