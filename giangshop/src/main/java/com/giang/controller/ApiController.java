package com.giang.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.giang.entity.ChiTietHoaDon;
import com.giang.entity.ChiTietHoaDonID;
import com.giang.entity.ChucVu;
import com.giang.entity.GioHang;
import com.giang.entity.HoaDon;
import com.giang.entity.NhanVien;
import com.giang.service.ChiTietHoaDonService;
import com.giang.service.HoaDonService;
import com.giang.service.NhanVienService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"user","giohang"})
public class ApiController {
	
	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	
	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	public String KiemTraDangNhap(@RequestParam String tendangnhap, HttpSession httpSession ,@RequestParam String matkhau,ModelMap modelMap) {
		
		//boolean kiemtra=nhanVienService.KiemTraDangNhap(tendangnhap, matkhau);
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		NhanVien nhanVien=nhanVienService.LayTaiKhoan(tendangnhap);		
		if (nhanVien!=null) {
			if(bCryptPasswordEncoder.matches(matkhau, nhanVien.getMatkhau())){
				modelMap.addAttribute("user",nhanVien);
				return "thanhcong";
			}else
				return "saimk";
		}else{
			return "thatbai";
		}
		
	}
	@GetMapping("/dangxuat")
	public String DangXuat(SessionStatus status){
		status.setComplete();
		return "redirect:/";
	}

	@PostMapping("KiemTraDangKy")
	@ResponseBody
	public String DangKy(@RequestParam String tendangnhap,@RequestParam String matkhau){
		boolean ktMail=validateEmail(tendangnhap);
		NhanVien nhanvien=nhanVienService.LayTaiKhoan(tendangnhap);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(matkhau);
		if(nhanvien==null){
			if(ktMail) {
				NhanVien nhanVien= new NhanVien();
				nhanVien.setTendangnhap(tendangnhap);
				nhanVien.setEmail(tendangnhap);
				nhanVien.setMatkhau(hashedPassword);
				ChucVu chucvu=new ChucVu();
				chucvu.setMachuvu(3);
				nhanVien.setChucvu(chucvu);
				boolean ktThem=nhanVienService.ThemNhanVien(nhanVien);
				if(ktThem){
					return "thanhcong";
				}else{
					return "thatbai";
				}
				
			}else {
				return "saiemail";
			}
		}else{ 
			return "tontai";	
		}
		
	}

	@GetMapping("ThemGioHang")
	@ResponseBody
	public String ThemGioHang(@RequestParam int machitietsanpham,@RequestParam int masp,@RequestParam int mamau, @RequestParam int masize, @RequestParam String tensp, @RequestParam String tenmau, @RequestParam String size, @RequestParam String giatien,ModelMap modelMap,HttpSession httpSession){
		if(httpSession.getAttribute("giohang")==null){
			List<GioHang> listgiohang=new ArrayList<GioHang>();
			GioHang giohang= new GioHang(machitietsanpham,masp, masize, mamau, tensp, tenmau, size, giatien, 1);
			listgiohang.add(giohang);
			httpSession.setAttribute("giohang", listgiohang);
			List<GioHang> giohangs=(List<GioHang>)httpSession.getAttribute("giohang");
			return ""+giohangs.size();		
		}else{
			List<GioHang> listgiohang=(List<GioHang>)httpSession.getAttribute("giohang");
			int vitri=-1;
			for(int i=0;i<listgiohang.size();i++){
				if(listgiohang.get(i).getMasp()==masp && listgiohang.get(i).getMamau()==mamau&&listgiohang.get(i).getMasize()==masize){
				   vitri=i;
				}
			}
			if(vitri ==-1){
				GioHang giohang=new GioHang(machitietsanpham,masp, masize, mamau, tensp, tenmau, size, giatien, 1);
				listgiohang.add(giohang);
				
			}else{
				int soluongmoi=listgiohang.get(vitri).getSoluong()+1;
				int giatienmoi=Integer.parseInt(giatien.replace(".", ""));
				int tongtien=giatienmoi*soluongmoi;
				String tongtienstr=String.format("%,d", tongtien);
				listgiohang.get(vitri).setSoluong(soluongmoi);
				listgiohang.get(vitri).setGiatien(tongtienstr);	
			}
			return ""+listgiohang.size();
		}
	}
	@GetMapping("UpdateGioHang")
	@ResponseBody
	public String UpdateGioHang(@RequestParam int masp,@RequestParam int mamau, @RequestParam int masize, @RequestParam String giatien,@RequestParam int soluong,ModelMap modelMap,HttpSession httpSession){
		if(httpSession.getAttribute("giohang")!=null){
			List<GioHang> listgiohang=(List<GioHang>)httpSession.getAttribute("giohang");
			int vitri=-1;
			for(int i=0;i<listgiohang.size();i++){
				if(listgiohang.get(i).getMasp()==masp && listgiohang.get(i).getMamau()==mamau&&listgiohang.get(i).getMasize()==masize){
				   vitri=i;
				}
			}
			if(vitri !=-1){
				listgiohang.get(vitri).setSoluong(soluong);
				listgiohang.get(vitri).setGiatien(giatien);	
			}
		}
		return "";
	}
	@GetMapping("XoaGioHang")
	@ResponseBody
	public String XoaGioHang(@RequestParam int masp, @RequestParam int mamau, @RequestParam int masize,HttpSession httpSession){
		if(httpSession.getAttribute("giohang")!=null){
			List<GioHang> listgiohang=(List<GioHang>) httpSession.getAttribute("giohang");
			int vitri=-1;
			for(int i=0;i<listgiohang.size();i++){
				if(listgiohang.get(i).getMasp()== masp &&listgiohang.get(i).getMamau()==mamau&&listgiohang.get(i).getMasize()==masize){
					vitri=i;
				}
			}
			if(vitri!=-1){
				listgiohang.remove(vitri);
			}
			return ""+listgiohang.size();
		}
		return "";
	}
	@PostMapping("ThemHoaDon")
	@ResponseBody
	public String ThemHoaDon(@RequestParam String tennguoimua, @RequestParam String diachi, @RequestParam String sdt,@RequestParam String hinhthuc,@RequestParam String ghichu, HttpSession httpSession){
		if(httpSession.getAttribute("giohang")!=null){
			HoaDon hoaDon=new HoaDon();
			hoaDon.setTenkhachhang(tennguoimua);
			hoaDon.setDiachigiaohang(diachi);
			hoaDon.setSdt(sdt);
			hoaDon.setHinhthucgiaohang(hinhthuc);
			hoaDon.setGhichu(ghichu);
			hoaDon.setTinhtrang(false);
			int id=hoaDonService.ThemHoaDon(hoaDon);
			
			List<GioHang> listgiohang=(List<GioHang>) httpSession.getAttribute("giohang");
			for (GioHang gioHang : listgiohang) {
				ChiTietHoaDonID chiTietHoaDonID=new ChiTietHoaDonID();
				chiTietHoaDonID.setMachitietsanpham(gioHang.getMachitiet());
				chiTietHoaDonID.setMahoadon(id);
				
				ChiTietHoaDon chiTietHoaDon=new ChiTietHoaDon();
				chiTietHoaDon.setChitiethoadonid(chiTietHoaDonID);
				chiTietHoaDon.setGiatien(gioHang.getGiatien());
				chiTietHoaDon.setSoluong(gioHang.getSoluong());
				chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
			}
			return "thanhcong";
		}else
			return "";
	}
	
	private static final Pattern EMAIL_REGEX =
			Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",Pattern.CASE_INSENSITIVE);
	public boolean validateEmail(String email) {
		Matcher matcher = EMAIL_REGEX.matcher(email);
		return matcher.matches();
	}
	
	
}
