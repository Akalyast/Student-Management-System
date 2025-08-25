package com.example.student_management_system.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.student_management_system.Entity.Admin;
import com.example.student_management_system.Entity.Dean;
import com.example.student_management_system.Entity.Hod;
import com.example.student_management_system.Entity.Staff;
import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Repository.AdminRepository;
import com.example.student_management_system.Repository.DeanRepository;
import com.example.student_management_system.Repository.HodRepository;
import com.example.student_management_system.Repository.StaffRepository;
import com.example.student_management_system.Repository.StudentRepository;

@Service
public class AdminService {
	@Autowired
    private AdminRepository adminRepository;

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private HodRepository hodRepository;
    
    @Autowired
    private DeanRepository deanRepository;

    public Admin login(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(String registerNumber, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(registerNumber).orElse(null);

        if (existingStudent == null) {
            // Throw 404 so frontend will show proper error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with register number: " + registerNumber);
        }

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setDepartment(updatedStudent.getDepartment());
        existingStudent.setDob(updatedStudent.getDob());
        existingStudent.setAcademicInfo(updatedStudent.getAcademicInfo());
        existingStudent.setExtraActivities(updatedStudent.getExtraActivities());
        existingStudent.setPassword(updatedStudent.getPassword());

        return studentRepository.save(existingStudent);
    }

    public String deleteStudent(String registerNumber) {
        if (studentRepository.existsById(registerNumber)) {
            studentRepository.deleteById(registerNumber);
            return "Student deleted successfully";
        }
        return "Student not found";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentByRegisterNumber(String registerNumber) {
        return studentRepository.findById(registerNumber).orElse(null);
    }
    public Staff addStaff(Staff staff) {
    	return staffRepository.save(staff);
    }
    public Staff getStaffById(String staffId) {
        return staffRepository.findById(staffId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Staff not found"));
    }

    public Staff updateStaff(String staffId, Staff updatedStaff) {
        Staff existingStaff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Staff not found"));

        existingStaff.setName(updatedStaff.getName());
        existingStaff.setDob(updatedStaff.getDob());
        existingStaff.setEmail(updatedStaff.getEmail());
        existingStaff.setDepartment(updatedStaff.getDepartment());
        existingStaff.setClassesHandled(updatedStaff.getClassesHandled());
        existingStaff.setAcademicInfo(updatedStaff.getAcademicInfo());
        existingStaff.setExtraActivities(updatedStaff.getExtraActivities());
        existingStaff.setPassword(updatedStaff.getPassword()); // Optional if password is editable

        return staffRepository.save(existingStaff);
    }

    public boolean deleteStaff(String staffId) {
        if (staffRepository.existsById(staffId)) {
            staffRepository.deleteById(staffId);
            return true;
        }
        return false;
    }
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
    public Hod getHodById(String hodId) {
        return hodRepository.findById(hodId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hod not found"));
    }
    public Hod updatehod(String hodId, Hod updatedhod) {
        Hod existinghod = hodRepository.findById(hodId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hod not found"));

        existinghod.setUsername(updatedhod.getUsername());
        existinghod.setDepartment(updatedhod.getDepartment());
        existinghod.setPassword(updatedhod.getPassword()); // Optional if password is editable

        return hodRepository.save(existinghod);
    }
    public Hod addHod(Hod hod) {
    	return hodRepository.save(hod);
    }
    public boolean deleteHod(String hodId) {
        Optional<Hod> optionalHod = hodRepository.findById(hodId);
        if (optionalHod.isPresent()) {
            hodRepository.delete(optionalHod.get());
            return true;
        } else {
            return false;
        }
    }
    public List<Hod> getAllHod() {
        return hodRepository.findAll();
    }

    
    public Dean getDeanById(String deanId) {
        return deanRepository.findById(deanId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dean not found"));
    }
    public Dean updatedean(String deanId, Dean updateddean) {
        Dean existingdean = deanRepository.findById(deanId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hod not found"));

        existingdean.setUsername(updateddean.getUsername());
        existingdean.setPassword(updateddean.getPassword()); // Optional if password is editable

        return deanRepository.save(existingdean);
    }
    public Dean addDean(Dean dean) {
    	return deanRepository.save(dean);
    }
    public boolean deleteDean(String deanId) {
        Optional<Dean> optionalDean = deanRepository.findById(deanId);
        if (optionalDean.isPresent()) {
            deanRepository.delete(optionalDean.get());
            return true;
        } else {
            return false;
        }
    }
    public List<Dean> getAllDean() {
        return deanRepository.findAll();
    }
}
