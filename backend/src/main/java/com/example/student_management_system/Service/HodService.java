package com.example.student_management_system.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management_system.Entity.Hod;
import com.example.student_management_system.Entity.Staff;
import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Repository.HodRepository;
import com.example.student_management_system.Repository.StaffRepository;
import com.example.student_management_system.Repository.StudentRepository;

@Service
public class HodService {
	@Autowired
    private HodRepository hodRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StaffRepository staffRepository;

    public Hod login(String hodId, String password) {
        return hodRepository.findByHodIdAndPassword(hodId, password);
    }


    public List<Student> getStudentsByHodUsername(String username) {
        Hod hod = hodRepository.findByUsername(username);
        if (hod != null) {
            return studentRepository.findByDepartment(hod.getDepartment());
        }
        return new ArrayList<>();
    }


    public List<Staff> getStaffByDepartment(String department) {
        return staffRepository.findAll().stream()
                .filter(s -> department.equalsIgnoreCase(s.getDepartment()))
                .toList();
    }
}
