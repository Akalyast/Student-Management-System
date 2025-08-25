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
public class Admin {
	 @Id
	 private String username;

	 private String password;

	 public String getPassword() {
		return password;
	 }

	 public void setPassword(String password) {
		this.password = password;
	 }

	 public String getUsername() {
		return username;
	 }

	 public void setUsername(String username) {
		this.username = username;
	 }
}
