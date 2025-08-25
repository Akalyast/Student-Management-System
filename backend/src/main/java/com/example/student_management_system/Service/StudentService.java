package com.example.student_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student login(String registerNumber, String password, String dob) {
        return studentRepository.findByRegisterNumberAndPasswordAndDob(registerNumber, password, dob);
    }

    public Student getPersonalInfo(String registerNumber) {
        return studentRepository.findById(registerNumber).orElse(null);
    }

    public String getAcademicInfo(String registerNumber) {
        Student student = studentRepository.findById(registerNumber).orElse(null);
        return student != null ? student.getAcademicInfo() : null;
    }

    public String getExtraActivities(String registerNumber) {
        Student student = studentRepository.findById(registerNumber).orElse(null);
        return student != null ? student.getExtraActivities() : null;
    }
}
