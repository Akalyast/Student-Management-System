package com.example.student_management_system.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Dean {
	 @Id
	 @Column(name = "deanid")
	 @JsonProperty("deanid")
	 private String deanId;
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
	 public void setDeanId(String deanId) {
		 this.deanId=deanId;
	 }
	 public String getDeanId() {
		 return deanId;
	 }
}
