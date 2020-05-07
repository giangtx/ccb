package com.giang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giang.entity.DanhMucSanPham;
import com.giang.entity.SanPham;
import com.giang.service.DanhMucSanPhamService;
import com.giang.service.SanPhamService;

@Controller
@RequestMapping("bosuutap/")
public class BoSuuTapController {
	
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap){
		List<DanhMucSanPham> danhmuc=danhMucSanPhamService.LayDanhSachDanhMuc();
		List<SanPham> sanphams=sanPhamService.LayDanhSachSanPhamFull();
		modelMap.addAttribute("danhmucs",danhmuc);
		modelMap.addAttribute("dssanpham",sanphams);
		return "bosuutap";
	}
}
