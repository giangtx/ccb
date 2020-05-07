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
	
	
	<div class="container-fluid" id="info_sanpham-bst">
		<div class="row" id="info_sanpham_con">
			<div class="col-md-2 col-sm-2">
				<div id="danhmuc-bst">
					<span id="header-danhmuc-bst">Danh mục</span>
					<br>
					<br>
					<div >
						<ul>		
							<c:forEach var="danhmucs" items="${danhmucs }">
								<li class="p-b-li-bst"><a class="a-dm-bst" href="/giangshop/bosuutap/${danhmucs.getMadanhmuc() }">${danhmucs.getTendanhmuc() }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				
				
			</div>
			<div class="col-md-10 col-sm-10">
				<div class="row ">
					<c:forEach items="${dssanpham }" var="Dssanpham">	
						<div class="col-md-3 col-sm-6">
							<div class="infosp-bst">
								<a href="chitiet/${Dssanpham.getMasanpham() }">
									<div class="sanpham wow zoomIn">
										<img alt ="aophong" src='<c:url value="/resources/image/sanpham/${Dssanpham.getHinhsanpham()}"/>'/><br>
										<span >${Dssanpham.getTensanpham() }</span><br>
										<span class="gia">${Dssanpham.getGiatien() } VND</span>
									</div>
								</a>
							</div>
						</div>
					</c:forEach>
				</div>
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