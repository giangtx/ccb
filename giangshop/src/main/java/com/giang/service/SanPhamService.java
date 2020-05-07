package com.giang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giang.dao.SanPhamDAO;
import com.giang.daoimp.SanPhamDAOimp;
import com.giang.entity.SanPham;

@Service
public class SanPhamService implements SanPhamDAOimp{

	@Autowired
	SanPhamDAO sanPhamDAO;
	
	public List<SanPham> LayDanhSachSanPham(int sanphamdau) {
		List<SanPham> sanPham=sanPhamDAO.LayDanhSachSanPham(sanphamdau);
		return sanPham;
	}
	
	public List<SanPham> LayDanhSachSanPhamFull(){
		List<SanPham> sanphams=sanPhamDAO.LayDanhSachSanPhamFull();
		return sanphams;
	}
	
	public SanPham LaySanPhamTheoMaSanPham(int masanpham) {
		SanPham sanpham=sanPhamDAO.LaySanPhamTheoMaSanPham(masanpham);
		return sanpham;
	}

}
