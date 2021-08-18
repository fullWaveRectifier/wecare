package com.infosys.userms.dto;

public class LoginDTO {
	private String id;
	private String password;
	
	LoginDTO(){
		super();
	}
	LoginDTO(String username, String password){
		this.id = username;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
