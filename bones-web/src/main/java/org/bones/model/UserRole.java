package org.bones.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRole {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int roleID;
	@ManyToOne
    @JoinColumn(name="USERID")
	private User user;
	private String authority;
	
	public static String ROLE_USER="ROLE_USER";
	public static String ROLE_ADMIN="ROLE_ADMIN";
	public static String ROLE_SYS_ADMIN="ROLE_SYS_ADMIN";
	
	public UserRole(){
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
