package demo.learnagain.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.learnagain.Entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> {
    
}
