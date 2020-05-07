package com.giang.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.giang.daoimp.ChiTietHoaDonDAOimp;
import com.giang.entity.ChiTietHoaDon;
import com.giang.entity.ChiTietHoaDonID;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDao implements ChiTietHoaDonDAOimp{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session=sessionFactory.getCurrentSession();
		ChiTietHoaDonID id=(ChiTietHoaDonID) session.save(chiTietHoaDon);
		if(id!=null){
			return true;
		}else
			return false;
	}
	

}
