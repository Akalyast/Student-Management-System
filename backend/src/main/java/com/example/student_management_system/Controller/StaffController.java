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

import com.example.student_management_system.DTO.StaffLoginRequest;
import com.example.student_management_system.Entity.Staff;
import com.example.student_management_system.Service.StaffService;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins="*")
public class StaffController {
	@Autowired
    private StaffService staffService;

    @PostMapping("/login")
    public String login(@RequestBody StaffLoginRequest request) {
        Staff staff = staffService.login(
        	request.getStaffId(),
        	request.getPassword(),
        	request.getDob()
        );
        return staff !=null? "Login Successfull" :"Login credentials are invalid";
    }

    @GetMapping("/personal/{staffId}")
    public ResponseEntity<?> getPersonalInfo(@PathVariable String staffId) {
        Staff staff = staffService.getStaffInfo(staffId);
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }
        return ResponseEntity.ok(staff);
    }

    @GetMapping("/academic-info/{staffId}")
    public ResponseEntity<?> getAcademicInfo(@PathVariable String staffId) {
        String academicInfo = staffService.getAcademicInfo(staffId);
        if (academicInfo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Academic info not found");
        }
        return ResponseEntity.ok(academicInfo);
    }

    // ✅ Extra Activities (from DB)
    @GetMapping("/extra-info/{staffId}")
    public ResponseEntity<?> getExtraInfo(@PathVariable String staffId) {
        String extraInfo = staffService.getExtraInfo(staffId);
        if (extraInfo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Extra-curricular info not found");
        }
        return ResponseEntity.ok(extraInfo);
    }
    @PostMapping("/admin/staff/add")
    public ResponseEntity<String> addStaff(@RequestBody Staff staff) {
        try {
            staffService.saveStaff(staff);
            return ResponseEntity.ok("Staff added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add staff");
        }
    }
}
