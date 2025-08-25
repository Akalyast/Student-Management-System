package com.example.student_management_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management_system.DTO.AdminLoginRequest;
import com.example.student_management_system.Entity.Admin;
import com.example.student_management_system.Entity.Dean;
import com.example.student_management_system.Entity.Hod;
import com.example.student_management_system.Entity.Staff;
import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class AdminController {
	@Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestBody AdminLoginRequest request) {
    	Admin admin=adminService.login(
    			request.getUsername(),
    			request.getPassword()
    			);
    	return admin!=null? "Login successful" : "Login credential is invalid";
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return adminService.addStudent(student);
    }

    @PutMapping("/student/update/{registerNumber}")
    public Student updateStudent(@PathVariable String registerNumber, @RequestBody Student student) {
        return adminService.updateStudent(registerNumber, student);
    }

    @DeleteMapping("/student/delete/{registerNumber}")
    public String deleteStudent(@PathVariable String registerNumber) {
        return adminService.deleteStudent(registerNumber);
    }

    @GetMapping("/student/all")
    public List<Student> getAllStudents() {
        return adminService.getAllStudents();
    }
    @GetMapping("/student/{registerNumber}")
    public Student getStudentByRegisterNumber(@PathVariable String registerNumber) {
        return adminService.getStudentByRegisterNumber(registerNumber);
    }
    @PostMapping("/staff/add")
    public Staff addStaff(@RequestBody Staff staff) {
        return adminService.addStaff(staff);
    }
    @GetMapping("/getStaff/{staffId}")
    public ResponseEntity<Staff> getStaffById(@PathVariable String staffId) {
        Staff staff = adminService.getStaffById(staffId);
        return ResponseEntity.ok(staff);
    }

    @PutMapping("/updateStaff/{staffId}")
    public ResponseEntity<Staff> updateStaff(@PathVariable String staffId, @RequestBody Staff updatedStaff) {
        Staff staff = adminService.updateStaff(staffId, updatedStaff);
        return ResponseEntity.ok(staff);
    }
    @DeleteMapping("/deleteStaff/{staffId}")
    public ResponseEntity<String> deleteStaff(@PathVariable String staffId) {
        boolean deleted = adminService.deleteStaff(staffId);
        if (deleted) {
            return ResponseEntity.ok("Staff deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }
    }
    @GetMapping("/viewAllStaff")
    public ResponseEntity<List<Staff>> viewAllStaff() {
        List<Staff> staffList = adminService.getAllStaff();
        return ResponseEntity.ok(staffList);
    }
    
    @GetMapping("/gethod/{hodId}")
    public ResponseEntity<Hod> getHodById(@PathVariable String hodId) {
        Hod hod = adminService.getHodById(hodId);
        return ResponseEntity.ok(hod);
    }
    @DeleteMapping("/deleteHod/{hodId}")
    public ResponseEntity<String> deleteHod(@PathVariable String hodId) {
        boolean deleted = adminService.deleteHod(hodId);
        if (deleted) {
            return ResponseEntity.ok("HOD deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HOD not found");
        }
    }
    @GetMapping("/viewAllHod")
    public ResponseEntity<List<Hod>> viewAllHod() {
        List<Hod> hodList = adminService.getAllHod();
        return ResponseEntity.ok(hodList);
    }
    @PutMapping("/updatehod/{hodid}")
    public ResponseEntity<Hod> updatehod(@PathVariable String hodid, @RequestBody Hod hod) {
        Hod updated = adminService.updatehod(hodid, hod);
        return ResponseEntity.ok(updated);
    }
    @PostMapping("/hod/add")
    public Hod addHod(@RequestBody Hod hod) {
        return adminService.addHod(hod);
    }
    
    @GetMapping("/getdean/{deanId}")
    public ResponseEntity<Dean> getDeanById(@PathVariable String deanId) {
        Dean dean = adminService.getDeanById(deanId);
        return ResponseEntity.ok(dean);
    }

    @PutMapping("/updatedean/{deanid}")
    public ResponseEntity<Dean> updatedean(@PathVariable String deanid, @RequestBody Dean dean) {
        Dean updated = adminService.updatedean(deanid, dean);
        return ResponseEntity.ok(updated);
    }
    @PostMapping("/dean/add")
    public Dean addDean(@RequestBody Dean dean) {
        return adminService.addDean(dean);
    }
    @DeleteMapping("/deleteDean/{deanId}")
    public ResponseEntity<String> deleteDean(@PathVariable String deanId) {
        boolean deleted = adminService.deleteDean(deanId);
        if (deleted) {
            return ResponseEntity.ok("Dean deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dean not found");
        }
    }
    @GetMapping("/viewAllDean")
    public ResponseEntity<List<Dean>> viewAllDean() {
        List<Dean> deanList = adminService.getAllDean();
        return ResponseEntity.ok(deanList);
    }
}
