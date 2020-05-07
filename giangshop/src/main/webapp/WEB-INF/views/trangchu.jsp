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
<body>
	
	<div class="container-fluid" id="header">
		<nav class="navbar navbar-default none_navb" style="margin-top: 12px;">
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
		          <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bộ sưu tập <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="/giangshop/bosuutap/">Xem tất cả</a></li>
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
		      	        <li><a href="dangnhap/">ĐĂNG NHẬP</a></li>
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
		        </a></li>
		        
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		<div class="event_header container wow tada">
			<span style="font-size: 18px">Ngày 13/3/2019 - 29/9/2019</span><br>
			<span style="font-size: 70px">Giảm giá 200%</span><br>
			<button>Tham gia ngay</button>
		
		</div>
	</div>
	
	<div class="container" id="info">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 wow bounceInLeft" data-wow-duration="500">
				<img class="icon" alt="huychuong" src='<c:url value="/resources/image/huychuong.png"/>'/><br>
				<span class="tieuchuan">CHẤT LƯỢNG</span><br>
				<span>Chúng tôi cam kết mang đến cho bạn chất lượng sản phẩm đạt chuẩn nhất</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow bounceInUp" data-wow-duration="500" data-wow-delay="500">
				<img class="icon" alt="tien" src='<c:url value="/resources/image/tien.png"/>'/><br>
				<span class="tieuchuan">TIẾT KIỆM CHI PHÍ</span><br>
				<span>Cam kết giá rẻ nhất cả nước giúp các bạn tiết kiệm hơn 90% cho từng sản phẩm</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow bounceInRight" data-wow-duration="500" data-wow-delay="500">
				<img class="icon" alt="Giaodich" src='<c:url value="/resources/image/giaodich.png"/>'/><br>
				<span class="tieuchuan">GIAO HÀNG</span><br>
				<span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đến cho khách hàng nhanh nhất</span>
			</div>
		</div>
	</div>
	
	<div id="title_sanpham" class="container">
		<div class="sp_hot wow zoomIn">
			<span>SẢN PHẨM HOT</span>
		</div>
		<div class="row ">
			<c:forEach items="${dssanpham }" var="Dssanpham">	
				<div class="col-md-3 col-sm-6">
					<a href="chitiet/${Dssanpham.getMasanpham() }">
						<div class="sanpham wow zoomIn">
							<img alt ="aophong" src='<c:url value="/resources/image/sanpham/${Dssanpham.getHinhsanpham()}"/>'/><br>
							<span >${Dssanpham.getTensanpham() }</span><br>
							<span class="gia">${Dssanpham.getGiatien() } VND</span>
						</div>
					</a>
					
				</div>
			</c:forEach>
		</div>
	</div>
	
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-md-4 wow jackInTheBox">
				<p><span class="footer-chuto">THÔNG TIN</span></p>
				<span>WourldPay là một thương hiệu uy tín, luôn đảm bảo cung cấp chất lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>
			
			<div class="col-md-4 wow jackInTheBox">
				<p><span class="footer-chuto">LIÊN HỆ</span></p>
				<span>no where-no where-void</span>
				<span>worldpay@gmail.com</span>
				<span>0123546456</span>			
			</div>
			
			<div class="col-md-4 wow jackInTheBox">
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