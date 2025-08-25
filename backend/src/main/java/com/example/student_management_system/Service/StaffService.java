package com.example.student_management_system.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student_management_system.Entity.Staff;
import com.example.student_management_system.Repository.StaffRepository;

@Service
public class StaffService {
	@Autowired
    private StaffRepository staffRepository;

    public Staff login(String staffId, String password, String dob) {
        return staffRepository.findByStaffIdAndPasswordAndDob(staffId, password, dob);
    }

    public Staff getStaffInfo(String staffId) {
        return staffRepository.findById(staffId).orElse(null);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
    public String getAcademicInfo(String staffId) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            return staff.getAcademicInfo(); // or add more info if needed
        }
        return null;
    }

    // ✅ Get extracurricular info only
    public String getExtraInfo(String staffId) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            return staff.getExtraActivities(); // or another field as needed
        }
        return null;
    }
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }
}
