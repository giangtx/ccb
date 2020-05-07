package com.giang.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.giang.daoimp.NhanVienDAOimp;
import com.giang.entity.NhanVien;


@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class NhanVienDao implements NhanVienDAOimp {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean KiemTraDangNhap(String tendangnhap,String matkhau) {
		Session session=sessionFactory.getCurrentSession();

		try {
			NhanVien nhanvien=(NhanVien) session.createQuery("from nhanvien where tendangnhap='"+tendangnhap+ "' and matkhau='"+matkhau+"'").getSingleResult();
			if(nhanvien!=null) {
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	public boolean ThemNhanVien(NhanVien nhanVien) {
		Session session=sessionFactory.getCurrentSession();
		int manhanvien= (Integer)session.save(nhanVien);
		if(manhanvien>1) {
			return true;
		}else {
			return false;
		}
		
	}
	@Transactional
	public NhanVien LayTaiKhoan(String tentaikhoan){
		Session session=sessionFactory.getCurrentSession();
		
		try {
			NhanVien nhanvien=(NhanVien)session.createQuery("from nhanvien where tendangnhap='"+tentaikhoan+"'").getSingleResult();
			if (nhanvien!=null) {
				return nhanvien;
			}else
				return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
