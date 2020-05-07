package com.giang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giang.dao.NhanVienDao;
import com.giang.daoimp.NhanVienDAOimp;
import com.giang.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienDAOimp {

	@Autowired
	NhanVienDao nhanVienDao;
	
	
	public boolean KiemTraDangNhap(String tendangnhap, String matkhau) {
		
		boolean kiemtra=nhanVienDao.KiemTraDangNhap(tendangnhap, matkhau);
		return kiemtra;
	}


	public boolean ThemNhanVien(NhanVien nhanVien) {
		boolean ktnv=nhanVienDao.ThemNhanVien(nhanVien);
		return ktnv;
	}


	public NhanVien LayTaiKhoan(String tentaikhoan) {
		NhanVien nhanvien=nhanVienDao.LayTaiKhoan(tentaikhoan);
		return nhanvien;
	}
	
}
