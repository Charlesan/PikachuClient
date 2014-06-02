package com.pikachu.bean;

public class UserBean {
	
	public int u_id;
	public String u_login_id;
	public String u_login_pwd;
	public String u_name;
	public int u_number;
	public int u_mark;
	
	public UserBean(){
		
	}
	
	public UserBean(int u_id, String u_login_id, String u_login_pwd,
			String u_name, int u_number, int u_mark) {
		super();
		this.u_id = u_id;
		this.u_login_id = u_login_id;
		this.u_login_pwd = u_login_pwd;
		this.u_name = u_name;
		this.u_number = u_number;
		this.u_mark = u_mark;
	}
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_login_id() {
		return u_login_id;
	}
	public void setU_login_id(String u_login_id) {
		this.u_login_id = u_login_id;
	}
	public String getU_login_pwd() {
		return u_login_pwd;
	}
	public void setU_login_pwd(String u_login_pwd) {
		this.u_login_pwd = u_login_pwd;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getU_number() {
		return u_number;
	}
	public void setU_number(int u_number) {
		this.u_number = u_number;
	}
	public int getU_mark() {
		return u_mark;
	}
	public void setU_mark(int u_mark) {
		this.u_mark = u_mark;
	}

	@Override
	public String toString() {
		return "UserBean [u_id=" + u_id + ", u_login_id=" + u_login_id
				+ ", u_login_pwd=" + u_login_pwd + ", u_name=" + u_name
				+ ", u_number=" + u_number + ", u_mark=" + u_mark + "]";
	}
	
	
	
}
