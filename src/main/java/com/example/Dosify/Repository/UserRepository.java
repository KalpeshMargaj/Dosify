package com.example.Dosify.Repository;

import com.example.Dosify.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmailId(String emailId);

    @Query(value = "select * from user where is_dose1_taken = 1 and is_dose2_taken = 0",nativeQuery = true)
    List<User> findUserReadyForDose2();
}
