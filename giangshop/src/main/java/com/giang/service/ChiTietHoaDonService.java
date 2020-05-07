package com.giang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giang.dao.ChiTietHoaDonDao;
import com.giang.daoimp.ChiTietHoaDonDAOimp;
import com.giang.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonDAOimp {

	@Autowired
	ChiTietHoaDonDao chiTietHoaDonDao;
	
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.ThemChiTietHoaDon(chiTietHoaDon);
	}

}
