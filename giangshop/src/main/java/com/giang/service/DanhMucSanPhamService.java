package com.giang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giang.dao.DanhMucSanPhamDao;
import com.giang.entity.DanhMucSanPham;
@Service
public class DanhMucSanPhamService {
	
	@Autowired
	DanhMucSanPhamDao danhMucSanPhamDao;
	
	public List<DanhMucSanPham> LayDanhSachDanhMuc(){
		List<DanhMucSanPham> danhmuc=danhMucSanPhamDao.LayDanhSachDanhMuc();
		return danhmuc;
	}
}
