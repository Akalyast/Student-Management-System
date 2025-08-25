package com.example.student_management_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.student_management_system.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,String>{
	Student findByRegisterNumberAndPasswordAndDob(String registerNumber, String password, String dob);
	Student findByRegisterNumber(String registerNumber);
	 List<Student> findByDepartment(String department);
}
