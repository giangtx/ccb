package com.giang.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.giang.daoimp.DanhMucSanPhamDapImp;
import com.giang.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDao implements DanhMucSanPhamDapImp {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<DanhMucSanPham> LayDanhSachDanhMuc(){
		Session session=sessionFactory.getCurrentSession();
		List<DanhMucSanPham> danhmuc=(List<DanhMucSanPham>)session.createQuery("from danhmucsanpham").getResultList();
		return danhmuc;
	}
}
