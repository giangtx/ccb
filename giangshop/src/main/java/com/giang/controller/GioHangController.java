package com.giang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giang.entity.GioHang;

@Controller
@RequestMapping("giohang/")
public class GioHangController {
	
	@GetMapping
	public String Default(HttpSession httpSession, ModelMap modelMap){
		
		if(httpSession.getAttribute("giohang")!=null){
			List<GioHang> giohangs=(List<GioHang>) httpSession.getAttribute("giohang");
			int tongtien=0;
			for (GioHang gioHang : giohangs) {
				int giatien=Integer.parseInt(gioHang.getGiatien().replace(".", ""));
				tongtien=tongtien+giatien;
				
			}
			String tongtienstr=String.format("%,d", tongtien);
			modelMap.addAttribute("tongtien",tongtienstr);
			modelMap.addAttribute("slgiohang",giohangs.size());
			modelMap.addAttribute("giohangs",giohangs);
		}
		return "giohang";
	}
}
