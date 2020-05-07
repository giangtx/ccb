package com.giang.daoimp;

import com.giang.entity.NhanVien;

public interface NhanVienDAOimp {
	boolean KiemTraDangNhap(String tendangnhap,String matkhau);
	boolean ThemNhanVien(NhanVien nhanVien);
	NhanVien LayTaiKhoan(String tentaikhoan);
}
