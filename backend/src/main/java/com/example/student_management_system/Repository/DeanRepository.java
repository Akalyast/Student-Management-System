package com.example.student_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_management_system.Entity.Dean;

@Repository
public interface DeanRepository extends JpaRepository<Dean, String> {
	Dean findByDeanIdAndPassword(String deanId, String password);

}
