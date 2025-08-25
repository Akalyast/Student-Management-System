package com.example.student_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.student_management_system.Entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,String>{
	Staff findByStaffIdAndPasswordAndDob(String staffId, String password, String dob);
}
