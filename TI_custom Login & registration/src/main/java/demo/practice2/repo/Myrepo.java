package demo.practice2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.practice2.model.Users;

public interface Myrepo extends JpaRepository<Users, Integer> {
    
    public Users findByUsername(String username);
}
