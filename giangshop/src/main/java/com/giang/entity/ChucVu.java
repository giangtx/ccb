package com.giang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="chucvu")
public class ChucVu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int machucvu;
	String tenchucvu;
	
	public int getMachucvu() {
		return machucvu;
	}
	public void setMachuvu(int machucvu) {
		this.machucvu = machucvu;
	}
	public String getTenchucvu() {
		return tenchucvu;
	}
	public void setTenchucvu(String tenchucvu) {
		this.tenchucvu = tenchucvu;
	}
	
}
