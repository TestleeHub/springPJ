<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<title>main</title>
</head>
<body>
	<div class="mypage_left">
		<div class="user_info_block">
			<div class="user_img_block">
				<div class="user_img">
					<img alt="" src="https://kmong.com/img/tools/main_user_gray.png">
				</div>
			</div>
			<div class="user_name">
				<h2 align="center">${sessionID}</h2>
			</div>
			<div class="user_menu">
				<ul class="left_menubar">
					<li><h4>마이크몽</h4></li>
					<hr>
					<li>
						<ul class="product_menu">
							<li align="left"><a href="${path}/purchaselist.cu">구매관리</a></li>
							<li align="left"><a href="${path}/updatepwdChk.do">회원정보
									수정</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>