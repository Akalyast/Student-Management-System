package com.example.student_management_system.DTO;

public class DeanLoginRequest {
	private String deanId;
    private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeanId() {
		return deanId;
	}
	public void setDeanId(String deanId) {
		this.deanId = deanId;
	}
}
