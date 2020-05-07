package com.giang.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.giang.daoimp.SanPhamDAOimp;
import com.giang.entity.SanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamDAOimp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> LayDanhSachSanPham(int sanphamdau) {
		Session session=sessionFactory.getCurrentSession();
		List<SanPham> sanPham=(List<SanPham>)session.createQuery("from sanpham").setFirstResult(sanphamdau).setMaxResults(12).getResultList();
		return sanPham;
	}
	@Transactional
	public List<SanPham> LayDanhSachSanPhamFull(){
		Session session=sessionFactory.getCurrentSession();
		List<SanPham> sanphams=session.createQuery("from sanpham").getResultList();
		return sanphams;
	}
	@Transactional
	public SanPham LaySanPhamTheoMaSanPham(int masanpham) {
		Session session=sessionFactory.getCurrentSession();
		SanPham sanpham=(SanPham) session.createQuery("from sanpham where masanpham="+masanpham).getSingleResult();
		return sanpham;
	}

}
