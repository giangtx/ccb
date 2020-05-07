<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
<jsp:include page="header.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-tleft"class="header-login">
					<span id="text-logo">Welcome</span><br/>
					<span id="hint-text-logo">Vào thì vào không vào thì cút!</span>
				</div>
				<div id="header-bleft">
					<p><img alt="idea" src='<c:url value="/resources/image/idea.png"/>'/><span>Luôn cập nhật xu hướng mới nhất</span></p>
					<p><img alt="idea" src='<c:url value="/resources/image/idea.png"/>'/><span>Đéo có giảm giá cho khách vip</span></p>
					<p><img alt="idea" src='<c:url value="/resources/image/idea.png"/>'/><span>Tư vấn nhiệt tình để tạo phong cách cho bạn</span></p>
				</div>
			</div>
			
			<div id="container-login-right">
				<div id="header-top-right"class="header-login">
					<span class="actived" id="login_click">Đăng nhập</span>/
					<span id="signin_click">Đăng ký</span>
				</div>		
				
				<div id="container-center-login-right" class="dangnhap_form">
					<input id="tendangnhap" name="tendangnhap" class="material-textinput input-icon-email" placeholder="Email" type="text" /><br>
					<input id="matkhau" name="matkhau" class="material-textinput input-icon-password" placeholder="Mật khẩu" type="password"/><br>
					<input id="btnDangNhap" class="material-button" type="submit" value="Đăng nhập"/><br>
					<span id="ketqua" style="color: red">${ketqua }</span>
				</div>
				<div id="container-center-login-right" class="dangky_form" style="display: none">
					<input id="tendangnhapdk" name="tendangnhap" class="material-textinput input-icon-email" placeholder="Email" type="text" /><br>
					<input id="matkhaudk" name="matkhau" class="material-textinput input-icon-password" placeholder="Mật khẩu" type="password"/><br>
					<input id="matkhaudkll" name="nhaplaimatkhau" class="material-textinput input-icon-password" placeholder="Nhập lại mật khẩu" type="password"/><br>
					<input id="btnDangKy" class="material-button" type="submit" value="Đăng ký"/><br>
					<span id="ketquadk" style="color: red">${ketqua}</span>			
				</div>
				
				<div id="icon-gf">
					<img alt="idea" src='<c:url value="/resources/image/facebook.png"/>'/>
					<img alt="idea" src='<c:url value="/resources/image/google.png"/>'/>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>