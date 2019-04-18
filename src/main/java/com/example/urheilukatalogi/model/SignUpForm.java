package com.example.urheilukatalogi.model;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

	public class SignUpForm {
	    @NotEmpty
	    @Size(min=5, max=30)
	    private String username = ""; //limiting username to be between 5 to 30

	    @NotEmpty
	    @Size(min=7, max=30)
	    private String password = ""; //limiting password to be between 7 to 30

	    @NotEmpty
	    @Size(min=7, max=30)
	    private String passwordCheck = ""; //checking password

	    @NotEmpty
	    private String role = "USER";

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getPasswordCheck() {
	        return passwordCheck;
	    }

	    public void setPasswordCheck(String passwordCheck) {
	        this.passwordCheck = passwordCheck;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
	    
	    
	}
