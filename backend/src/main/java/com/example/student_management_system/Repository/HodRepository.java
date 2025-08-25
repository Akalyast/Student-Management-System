package com.example.student_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_management_system.Entity.Hod;

@Repository
public interface HodRepository extends JpaRepository<Hod,String>{
	 Hod findByUsername(String username);
	 Hod findByHodIdAndPassword(String hodId, String password);
}
