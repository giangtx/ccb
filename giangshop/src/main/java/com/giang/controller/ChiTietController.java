package com.giang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.giang.entity.DanhMucSanPham;
import com.giang.entity.GioHang;
import com.giang.entity.SanPham;
import com.giang.service.DanhMucSanPhamService;
import com.giang.service.SanPhamService;


@Controller
@RequestMapping("/chitiet")
public class ChiTietController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	
	@GetMapping("/{masanpham}")
	@Transactional
	public String Default(@PathVariable int masanpham,ModelMap modelMap, HttpSession httpSession) {
		
		SanPham sanPham=sanPhamService.LaySanPhamTheoMaSanPham(masanpham);
		List<DanhMucSanPham> danhmucs=danhMucSanPhamService.LayDanhSachDanhMuc();
		
		if(httpSession.getAttribute("giohang")!=null){
			List<GioHang> giohangs=(List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("slgiohang",giohangs.size());
		}
		modelMap.addAttribute("sanphams", sanPham);
		modelMap.addAttribute("danhmucs",danhmucs);
		return "chitiet";
	}
	
	

	
}
