package com.giang.controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.giang.entity.NhanVien;
import com.giang.service.NhanVienService;


@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
	
	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping
	public String Default() {
		return "dangnhap";
	}
	
}
