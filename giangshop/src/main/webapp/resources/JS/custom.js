$(document).ready(function(){
	$("#btnDangNhap").click(function(){
		var usename= $("#tendangnhap").val();
		var password= $("#matkhau").val();		
		$.ajax({
			url:"/giangshop/api/KiemTraDangNhap",
			type:"GET",
			data:{
				tendangnhap:usename,
				matkhau:password
			},
			success: function(value){
				if(value=="thanhcong"){
					duongDanHienTai= window.location.href;
					duongDan= duongDanHienTai.replace("dangnhap/","");
					window.location= duongDan;
				}else if(value=="saimk"){
					$("#ketqua").text("Sai mật khẩu!");
				}else if(value=="thatbai"){
					$("#ketqua").text("Tài khoản không tồn tại!");
				}
			}
		})
	});
	$("#btnDangKy").click(function(){
		var tendangnhap= $("#tendangnhapdk").val();
		var matkhau= $("#matkhaudk").val();	
		var matkhaull=$("#matkhaudkll").val();
		if(matkhau==matkhaull){
			$.ajax({
				url:"/giangshop/api/KiemTraDangKy",
				type:"POST",
				data:{
					tendangnhap:tendangnhap,
					matkhau:matkhau
				},
				success: function(value){
					if(value=="thanhcong"){
						$("#ketquadk").text("Đăng ký thành công!");
					}else if(value=="thatbai"){
						$("#ketquadk").text("Đăng ký thất bại!");
					}else if(value=="saiemail"){
						$("#ketquadk").text("Email không hợp lệ!");
					}else if(value=="tontai"){
						$("#ketquadk").text("Email đã tồn tại!");
					}
				}
			})
		}else{
			$("#ketquadk").text("Mật khẩu nhập lại không khớp!");
		}
		
	});
	$("#login_click").click(function(){
		$(".dangnhap_form").show();
		$(this).addClass("actived");
		$(".dangky_form").hide();
		$("#signin_click").removeClass("actived");
		
	});
	
	$("#signin_click").click(function(){
		$(".dangnhap_form").hide();
		$(this).addClass("actived");
		$(".dangky_form").show();
		$("#login_click").removeClass("actived");
	});
	$("#btnDangKy").click(function(){
		$(".dangnhap_form").hide();
		$(".dangky_form").show();
	});
	$(".btnGiohang").click(function(){
		var masp=$("#tensp").attr("data-masp");
		var mamau=$(this).closest("tr").find(".mau").attr("data-mamau");
		var masize=$(this).closest("tr").find(".size").attr("data-masize");
		var tensp=$("#tensp").text();
		var tenmau=$(this).closest("tr").find(".mau").text();
		var size=$(this).closest("tr").find(".size").text();
		var giatien=$("#giatien").attr("data-giatien");
		var machitietsanpham=$(this).attr("data-machitietsp");
		$.ajax({
			url:"/giangshop/api/ThemGioHang",
			type:"GET",
			data:{
				machitietsanpham:machitietsanpham,
				masp:masp,
				mamau:mamau,
				masize:masize,
				tensp:tensp,
				tenmau:tenmau,
				size:size,
				giatien:giatien
			},
			success: function(value){
				$("#idgiohang").html("<span>"+value+"</span>");
				$("#idgiohang").addClass("soluonggiohangcss");
			}
		})
	});
	$(".sl-giohang").change(function(){
		var soluongmoi=$(this).closest("tr").find(".sl-giohang").val();
		var soluongcu=$(this).closest("tr").find(".soluong").attr("data-soluong");
		var giatien=$(this).closest("tr").find(".giatien").attr("data-giatien");
		var masp=$(this).closest("tr").find(".tensp").attr("data-masp");
		var mamau=$(this).closest("tr").find(".mau").attr("data-mamau");
		var masize=$(this).closest("tr").find(".size").attr("data-masize");
		
		var giatienmoi=((parseInt(giatien.replace(/\./g, ""))/parseInt(soluongcu))*parseInt(soluongmoi));
		var giatienmoistr=giatienmoi.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1.');
		$(this).closest("tr").find(".giatien").html(giatienmoistr);
		
		var tongtien=0;
		$(".giatien").each(function(){
		    var giatienmoitext=$(this).text();
		    var giatienmoitx=parseInt(giatienmoitext.replace(/\./g, ""));
		    tongtien=tongtien+giatienmoitx;
		  });
		var tongtienstr=tongtien.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1.');
		$("#tongtien-span").html("Tổng tiền: "+tongtienstr+" VNĐ");
		
		//alert(masp+" "+mamau+" "+masize+" cu:"+soluongcu+" moi:"+soluongmoi+" gtcu: "+giatien+" gtmoi: "+giatienmoi);
		$.ajax({
			url:"/giangshop/api/UpdateGioHang",
			type:"GET",
			data:{
				masp:masp,
				mamau:mamau,
				masize:masize,
				giatien:giatienmoistr,
				soluong:soluongmoi,
			},
			success: function(value){
				
			}
		})
	});  
	$(".btnXoaGioHang").click(function(){
		var self=$(this);
		var masp=$(this).closest("tr").find(".tensp").attr("data-masp");
		var mamau=$(this).closest("tr").find(".mau").attr("data-mamau");
		var masize=$(this).closest("tr").find(".size").attr("data-masize");
		
		$.ajax({
			url:"/giangshop/api/XoaGioHang",
			type:"GET",
			data:{
				masp:masp,
				mamau:mamau,
				masize:masize
			},
			success:function(value){
				if(value){
					self.closest("tr").remove();
					$("#idgiohang").html("<span>"+value+"</span>");
					$("#idgiohang").addClass("soluonggiohangcss");
					var tongtien=0;
					$(".giatien").each(function(){
					    var giatienmoitext=$(this).text();
					    var giatienmoitx=parseInt(giatienmoitext.replace(/\./g, ""));
					    tongtien=tongtien+giatienmoitx;
					  });
					var tongtienstr=tongtien.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1.');
					$("#tongtien-span").html("Tổng tiền: "+tongtienstr+" VNĐ");
				}
			}
		})
	});
	$("#btnThanhToan").click(function(){
		var tennguoimua=$("#tennguoimua-text").val();
		var diachi=$("#diachi-text").val();
		var sdt=$("#sodienthoai-text").val();
		var hinhthuc=$("input[name=hinhthuc-radio]:checked").val();
		var ghichu=$("#ghichu-text").val();
		if(tennguoimua==""){
			$("#ketquagh").text("Vui lòng nhập tên khách hàng");
		}else{
			if(diachi==""){
				$("#ketquagh").text("Vui lòng nhập địa chỉ");
			}else{
				if(sdt==""){
					$("#ketquagh").text("Vui lòng nhập số điện thoại");
				}else{
					$.ajax({
						url:"/giangshop/api/ThemHoaDon",
						type:"POST",
						data:{
							tennguoimua:tennguoimua,
							diachi:diachi,
							sdt:sdt,
							hinhthuc:hinhthuc,
							ghichu:ghichu,
						},
						success:function(value){
							if(value="thanhcong"){
								$("#ketquagh").text("Đặt hàng thành công");
							}
						}
					})
				}
			}
		}
	});
	
	
});