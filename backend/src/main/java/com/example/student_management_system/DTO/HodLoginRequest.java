package com.example.student_management_system.DTO;

public class HodLoginRequest {
	private String hodId;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHodId() {
		return hodId;
	}
	public void setHodid(String hodId) {
		this.hodId = hodId;
	}
	
}
