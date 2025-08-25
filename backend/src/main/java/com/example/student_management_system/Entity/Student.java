package com.example.student_management_system.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@Column(name = "register_number")
    private String registerNumber;

    private String name;
    private String password;
    private String dob;
    private String department;
    private String academicInfo;
    private String extraActivities;
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
