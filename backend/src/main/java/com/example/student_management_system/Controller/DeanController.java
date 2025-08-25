package com.example.student_management_system.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management_system.DTO.DeanLoginRequest;
import com.example.student_management_system.Entity.Dean;
import com.example.student_management_system.Entity.Hod;
import com.example.student_management_system.Entity.Staff;
import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Service.DeanService;

@RestController
@RequestMapping("/dean")
@CrossOrigin(origins="*")
public class DeanController {
	@Autowired
    private DeanService deanService;

	@PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody DeanLoginRequest request) {
        Dean dean = deanService.login(request.getDeanId(), request.getPassword());
        Map<String, String> response = new HashMap<>();

        if (dean != null) {
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Login credentials are invalid");
            return ResponseEntity.status(401).body(response);  // 401 Unauthorized
        }
    }

    @GetMapping("/hods")
    public List<Hod> getAllHods() {
        return deanService.getAllHods();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return deanService.getAllStudents();
    }

    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        return deanService.getAllStaff();
    }
}
