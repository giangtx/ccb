package com.giang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giang.entity.GioHang;
import com.giang.entity.SanPham;
import com.giang.service.SanPhamService;



@Controller
@RequestMapping("/")
public class TrangChuController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping
	@Transactional
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		
		if(httpSession.getAttribute("giohang")!=null){
			List<GioHang> giohangs=(List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("slgiohang",giohangs.size());
		}
		List<SanPham> sanPham=sanPhamService.LayDanhSachSanPham(0);
		modelMap.addAttribute("dssanpham",sanPham);
		
		return "trangchu";
	}
	

	
	
	
	
}
