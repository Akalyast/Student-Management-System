package com.example.student_management_system.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	@Id
    private String staffId;

    private String name;
    private String password;
    private String dob;
    private String email;
    private String department;
    private String classesHandled;
    private String academicInfo;       // ✅ Newly added
    private String extraActivities;  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getClassesHandled() {
		return classesHandled;
	}
	public void setClassesHandled(String classesHandled) {
		this.classesHandled = classesHandled;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getAcademicInfo() {
		return academicInfo;
	}
	public void setAcademicInfo(String academicInfo) {
		this.academicInfo = academicInfo;
	}
	public String getExtraActivities() {
		return extraActivities;
	}
	public void setExtraActivities(String extraActivities) {
		this.extraActivities = extraActivities;
	}
}
