package com.giang.entity;

public class GioHang {
	int machitiet;
	int masp;
	int masize;
	int mamau;
	String tensp;
	String tenmau;
	String tensize;
	String giatien;
	int soluong;
	public GioHang(int machitiet,int masp, int masize, int mamau, String tensp, String tenmau, String tensize, String giatien,
			int soluong) {
		super();
		this.machitiet=machitiet;
		this.masp = masp;
		this.masize = masize;
		this.mamau = mamau;
		this.tensp = tensp;
		this.tenmau = tenmau;
		this.tensize = tensize;
		this.giatien = giatien;
		this.soluong = soluong;
	}
	public int getMachitiet() {
		return machitiet;
	}
	public void setMachitiet(int machitiet) {
		this.machitiet = machitiet;
	}
	public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public int getMasize() {
		return masize;
	}
	public void setMasize(int masize) {
		this.masize = masize;
	}
	public int getMamau() {
		return mamau;
	}
	public void setMamau(int mamau) {
		this.mamau = mamau;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getTenmau() {
		return tenmau;
	}
	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
	public String getTensize() {
		return tensize;
	}
	public void setTensize(String tensize) {
		this.tensize = tensize;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}
