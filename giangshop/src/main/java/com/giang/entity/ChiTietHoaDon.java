package com.giang.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity(name="chitiethoadon")
public class ChiTietHoaDon {
	
	@EmbeddedId
	ChiTietHoaDonID chitiethoadonid;
	
	int soluong;
	String giatien;
	public ChiTietHoaDonID getChitiethoadonid() {
		return chitiethoadonid;
	}
	public void setChitiethoadonid(ChiTietHoaDonID chitiethoadonid) {
		this.chitiethoadonid = chitiethoadonid;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	
}
