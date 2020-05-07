<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
<jsp:include page="header.jsp"/>
</head>
<body id="body-login">
	
	<div class="container-fluid" id="header_chitiet">
		<nav class="navbar navbar-default none_navb">
		  <div class="container-fluid magintop">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="/giangshop"><img style="margin-top: -45px;" alt="worldpay" src='<c:url value="/resources/image/worldpay.png"/>'/></a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav navbar_center">
		        <li class="active"><a href="/giangshop">TRANG CHỦ</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="#">Action</a></li>
		            <li><a href="#">Another action</a></li>
		            <li><a href="#">Something else here</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">Separated link</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">One more separated link</a></li>
		          </ul>
		        </li>
		        <li><a href="#">DỊCH VỤ</a></li>
		        <li><a href="#">LIÊN HỆ</a></li>
		      </ul>
		      
		      <ul class="nav navbar-nav navbar-right">
		      	<c:choose>
		      		<c:when test="${user!= null}">
		      			<li><a href="/giangshop/dangnhap/" style="display: inline-block;padding-right: 0px;">${user.getTendangnhap()}</a>
		      			<a href='/giangshop/api/dangxuat/' style="display: inline-block;padding-left: 0px;" id="logout">/Đăng xuất</a></li>
		      			
		      		</c:when>
		      		
		      		<c:otherwise>
		      	        <li><a href="/giangshop/dangnhap/">ĐĂNG NHẬP</a></li>
		      		</c:otherwise>
		      	</c:choose>
		        
		        
		        <li><a href="/giangshop/giohang/">
		        		<img alt="worldpay" src='<c:url value="/resources/image/shopping.png"/>'>
		        		<c:choose>
		        			<c:when test="${slgiohang>0 }">
		        				<div class="soluonggiohangcss" id="idgiohang">
				        			<span>${slgiohang}</span>
				        		</div>
		        			</c:when>
		        			<c:otherwise>
		        				<div class="" id="idgiohang">
				        			
				        		</div>
		        			</c:otherwise>
		        		</c:choose>
		        		
		        	</a>
		        </li>
		        
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		
	</div>
	
	
	<div class="container-fluid" id="info_giohang">
		<div class="row">
			<div class="col-lg-5 info-nguoimua">
				<h2>Thông tin người mua</h2>
				<div class="form-group">
				    <label >Tên người mua</label>
				    <input id="tennguoimua-text"type="text" class="form-control"   placeholder="Tên người mua">
				</div>
				<div class="form-group">
				    <label >Địa chỉ</label>
				    <input id="diachi-text" type="text" class="form-control"  placeholder="Địa chỉ">
				</div>
				<div class="form-group">
				    <label >Số điện thoại</label>
				    <input id="sodienthoai-text" type="text" class="form-control" placeholder="Số điện thoại">
				</div>
				<div class="radio">
				  	<label><input id="hinhthuc-radio" name="hinhthuc-radio" type="radio" checked="" value="Tại nhà">Nhận hàng tại địa chỉ người mua</label>
				</div>
				<div class="radio">
				  	<label><input id="hinhthuc-radio" name="hinhthuc-radio" type="radio" value="Tại cửa hàng">Nhận hàng tại cửa hàng</label>
				</div>
				<div class="form-group">
				    <label >Ghi chú</label>
				    <textarea id="ghichu-text"  class="form-control" placeholder="Ghi chú" rows="3"></textarea>
				</div>
				<div><span id="tongtien-span" data-tongtiensp="${tongtien }">Tổng tiền: ${tongtien } VNĐ</span></div><br>
				<div ><button class="btn btn-primary" id="btnThanhToan">Đặt hàng</button></div><br>
				<span id="ketquagh" style="color: red"></span>
			</div>
			<div class="col-lg-7 info-ctgiohang">
				<h3>Giỏ hàng</h3>
				<table class="table">
					<thead>
						<tr>
							<td>Tên sản phẩm</td>
							<td>Size</td>
							<td>Màu</td>
							<td>Số Lượng</td>
							<td>Giá tiền</td>
							<td></td>
						</tr>
					</thead>					
					<tbody>
						<c:forEach var="giohangs" items="${giohangs}">
							<tr class="giohang-table">
								<td class="tensp" data-masp="${giohangs.getMasp() }">${giohangs.getTensp() }</td>
								<td class="size" data-masize="${giohangs.getMasize()}">${giohangs.getTensize() }</td>
								<td class="mau" data-mamau="${giohangs.getMamau()}">${giohangs.getTenmau()}</td>
								<td class="soluong" data-soluong="${giohangs.getSoluong()}"><input class="sl-giohang" type="number" value="${giohangs.getSoluong()}" min="1" style="max-width: 80px;"></input></td>
								<td class="giatien" data-giatien="${giohangs.getGiatien()}">${giohangs.getGiatien()}</td>
								<td><button class="btn btn-danger btnXoaGioHang">Xóa</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>	
	</div>
	
	
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<p><span class="footer-chuto">THÔNG TIN</span></p>
				<span>WourldPay là một thương hiệu uy tín, luôn đảm bảo cung cấp chất lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>
			
			<div class="col-md-4">
				<p><span class="footer-chuto">LIÊN HỆ</span></p>
				<span>no where-no where-void</span>
				<span>worldpay@gmail.com</span>
				<span>0123546456</span>			
			</div>
			
			<div class="col-md-4 ">
				<p><span class="footer-chuto">GÓP Ý</span></p>
				<form action="" method="get">
					<input class="gopy" type="text" placeholder="Email"/>
					<textarea  class="gopy" rows="4" cols="50" placeholder="Nội Dung"></textarea>
					<button class="button-gopy">GỬI GÓP Ý</button>
				</form>
			</div>
		</div>
			
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>