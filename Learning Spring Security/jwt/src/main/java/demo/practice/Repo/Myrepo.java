package demo.practice.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.practice.Model.Users;

@Repository
public interface Myrepo extends JpaRepository<Users,Integer>{
    public Users findByUsername(String username);
}
