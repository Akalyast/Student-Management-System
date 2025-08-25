package com.example.student_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.student_management_system.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String>{
	Admin findByUsernameAndPassword(String username,String password);
}
