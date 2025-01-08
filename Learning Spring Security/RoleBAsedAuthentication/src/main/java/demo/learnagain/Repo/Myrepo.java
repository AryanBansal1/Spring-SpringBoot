package demo.learnagain.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.learnagain.Entity.MyRegistration;


@Repository
public interface Myrepo extends JpaRepository<MyRegistration,Long> {
    public MyRegistration findByUsername(String username);
}
