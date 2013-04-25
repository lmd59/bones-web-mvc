package org.bones.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String nickname;
    private String email;
    private String classYear;
    private String position;
    @OneToMany(mappedBy="user")
    private Set<UserRole> roles;
    @OneToMany(mappedBy="user")
    private Set<Message> messages;
    
    public User(){
    	this.setUsername("");
    	this.setPassword("");
    	this.setFirstname("");
    	this.setLastname("");
    	this.setNickname("");
    	this.setEmail("");
    	this.setClassYear("");
    	this.setPosition("");
    }
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClassYear() {
		return classYear;
	}
	public void setClassYear(String classYear) {
		this.classYear = classYear;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Set<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
}
