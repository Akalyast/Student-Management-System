package com.example.student_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management_system.Entity.Dean;
import com.example.student_management_system.Entity.Hod;
import com.example.student_management_system.Entity.Staff;
import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Repository.DeanRepository;
import com.example.student_management_system.Repository.HodRepository;
import com.example.student_management_system.Repository.StaffRepository;
import com.example.student_management_system.Repository.StudentRepository;

@Service
public class DeanService {
	@Autowired
    private DeanRepository deanRepository;

    @Autowired
    private HodRepository hodRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StaffRepository staffRepository;

    public Dean login(String deanId, String password) {
        return deanRepository.findByDeanIdAndPassword(deanId, password);
    }

    public List<Hod> getAllHods() {
        return hodRepository.findAll();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
}
