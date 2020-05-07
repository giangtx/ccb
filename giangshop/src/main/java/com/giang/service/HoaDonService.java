package com.giang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giang.dao.HoaDonDao;
import com.giang.daoimp.HoaDonDAOimp;
import com.giang.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonDAOimp {
	
	@Autowired
	HoaDonDao hoaDonDao;

	public int ThemHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		return hoaDonDao.ThemHoaDon(hoaDon);
	}
}
