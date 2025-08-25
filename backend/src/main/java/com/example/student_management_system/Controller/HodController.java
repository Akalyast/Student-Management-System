package com.example.student_management_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management_system.DTO.HodLoginRequest;
import com.example.student_management_system.Entity.Hod;
import com.example.student_management_system.Entity.Staff;
import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Service.HodService;

@RestController
@RequestMapping("/hod")
@CrossOrigin(origins="*")
public class HodController {
	@Autowired
    private HodService hodService;

	@PostMapping("/login")
	public String login(@RequestBody HodLoginRequest request) {
	    System.out.println("🔵 Received login: hodId = " + request.getHodId() + ", password = " + request.getPassword());

	    Hod hod = hodService.login(request.getHodId(), request.getPassword());

	    if (hod != null) {
	        return "Login Successfully";
	    } else {
	        return "Login credentials are invalid";
	    }
	}



    @GetMapping("/students")
    public List<Student> getStudents(@RequestParam String username) {
        return hodService.getStudentsByHodUsername(username);
    }
    @GetMapping("/staff")
    public List<Staff> getStaff(@RequestParam String department) {
        return hodService.getStaffByDepartment(department);
    }
}
