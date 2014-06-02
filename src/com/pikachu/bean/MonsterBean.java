package com.pikachu.bean;

public class MonsterBean {
	
	public int m_id;
	public int m_number;
	public String m_name;
	public int m_mark;
	public double m_longitude;
	public double m_latitude;
	public double m_altitude;
	public int m_iscapatured;
	public int m_ownerid;
	
	public MonsterBean(){
		
	}
	
	public MonsterBean(int m_id, int m_number, String m_name, int m_mark,
			double m_longitude, double m_latitude, double m_altitude,
			int m_iscapatured, int m_ownerid) {
		super();
		this.m_id = m_id;
		this.m_number = m_number;
		this.m_name = m_name;
		this.m_mark = m_mark;
		this.m_longitude = m_longitude;
		this.m_latitude = m_latitude;
		this.m_altitude = m_altitude;
		this.m_iscapatured = m_iscapatured;
		this.m_ownerid = m_ownerid;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getM_number() {
		return m_number;
	}
	public void setM_number(int m_number) {
		this.m_number = m_number;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_mark() {
		return m_mark;
	}
	public void setM_mark(int m_mark) {
		this.m_mark = m_mark;
	}
	public double getM_longitude() {
		return m_longitude;
	}
	public void setM_longitude(double m_longitude) {
		this.m_longitude = m_longitude;
	}
	public double getM_latitude() {
		return m_latitude;
	}
	public void setM_latitude(double m_latitude) {
		this.m_latitude = m_latitude;
	}
	public double getM_altitude() {
		return m_altitude;
	}
	public void setM_altitude(double m_altitude) {
		this.m_altitude = m_altitude;
	}
	public int getM_iscapatured() {
		return m_iscapatured;
	}
	public void setM_iscapatured(int m_iscapatured) {
		this.m_iscapatured = m_iscapatured;
	}
	public int getM_ownerid() {
		return m_ownerid;
	}
	public void setM_ownerid(int m_ownerid) {
		this.m_ownerid = m_ownerid;
	}
	
	@Override
	public String toString() {
		return "MonsterBean [m_id=" + m_id + ", m_number=" + m_number
				+ ", m_name=" + m_name + ", m_mark=" + m_mark
				+ ", m_longitude=" + m_longitude + ", m_latitude=" + m_latitude
				+ ", m_altitude=" + m_altitude + ", m_iscapatured="
				+ m_iscapatured + ", m_ownerid=" + m_ownerid + "]";
	}
	
	
	
}
