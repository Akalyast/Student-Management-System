package com.example.student_management_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management_system.DTO.StudentLoginRequest;
import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins="*")
public class StudentController {
	@Autowired
    private StudentService studentService;

	@PostMapping("/login")
	public String login(@RequestBody StudentLoginRequest request) {
	    Student student = studentService.login(
	        request.getRegisterNumber(),
	        request.getPassword(),
	        request.getDob()
	    );
	    return student != null ? "Login Successful" : "Login Credentials are Invalid";
	}

	@GetMapping("/personal/{registerNumber}")
	public ResponseEntity<?> getPersonalInfo(@PathVariable String registerNumber) {
	    Student student = studentService.getPersonalInfo(registerNumber);
	    if (student == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
	    }
	    return ResponseEntity.ok(student);
	}

	@GetMapping("/academic-info/{registerNumber}")
	public ResponseEntity<?> getAcademicInfo(@PathVariable String registerNumber) {
	    String academicInfo = studentService.getAcademicInfo(registerNumber);
	    if (academicInfo == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Academic info not found");
	    }
	    return ResponseEntity.ok(academicInfo);
	}

	@GetMapping("/extra-info/{registerNumber}")
	public ResponseEntity<?> getExtraInfo(@PathVariable String registerNumber) {
	    String extraInfo = studentService.getExtraActivities(registerNumber);
	    if (extraInfo == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Extra-curricular info not found");
	    }
	    return ResponseEntity.ok(extraInfo);
	}
}
