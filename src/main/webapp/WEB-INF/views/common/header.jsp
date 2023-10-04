<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>main</title>
<link rel="stylesheet" href="${path}/resources/css/common/header.css">

</head>
<body>
	<nav class="navbar">
			<div></div>
			<div></div>
			<ul class="navbar_title">
				<li><a href="${path}/main.do"><i class="fa-solid fa-signature"></i></a></li>
			</ul>
			<ul class="navbar_menu">
				<li>
					<form class="d-flex" role="search" action="productsearch.cu">
						<input class="form-control me-2 bs-body-bg" type="search"
							placeholder="Search" aria-label="Search" size="50px" name="target">
						<button class="btn btn-outline-secondar" type="submit">Search</button>
					</form>
				</li>
				<li></li>
				<li></li>
				<li><a href="${path}/notice.do">공지사항</a></li>
				<li><a href="${path}/productlist.cu">제품소개</a></li>
				<c:if test="${sessionID == null}">
					<li><a href="${path}/join.do">회원가입</a></li>
					<li><a href="${path}/login.do">로그인</a></li>
				</c:if>
				<c:if test="${sessionID != null}">
					<c:if test="${SessionAuthority == 'ROLE_CLIENT'}">
						<li><a href="${path}/wishlist.cu">찜목록</a></li>
						<li><a href="${path}/mypage.cu"><i
							class="fa-solid fa-user"></i></a></li>
						<li><a href="${path}/mypage.cu"><small>${sessionID}</small></a></li>
					</c:if>
					<c:if test="${SessionAuthority == 'ROLE_EXPERT'}">
						<li><a href="${path}/mypage.ex"><i
							class="fa-solid fa-user"></i></a></li>
						<li><a href="${path}/mypage.ex"><small>${sessionID}</small></a></li>
					</c:if>
					<c:if test="${SessionAuthority == 'ROLE_ADMIN'}">
						<li><a href="#"><small style="color: red; !important">${sessionID}</small></a></li>
					</c:if>
					<li><a href="${path}/logout.do">로그아웃</a></li>
				</c:if>
			</ul>
			<a href="#" class="navbar-toggleBtn"> <i class="fa-solid fa-bars"></i>
			</a>
			<div></div>
			<div></div>
		</nav>
		<nav class="navbar2">
			<ul class="navbar_menu2">
				<li><a href="${path}/productlistCategory.cu?category=디자인">디자인</a></li>
				<li><a href="${path}/productlistCategory.cu?category=IT">IT</a></li>
				<li><a href="${path}/productlistCategory.cu?category=영상">영상</a></li>
				<li><a href="${path}/productlistCategory.cu?category=마케팅">마케팅</a></li>
				<li><a href="${path}/productlistCategory.cu?category=번역">번역</a></li>
				<li><a href="${path}/productlistCategory.cu?category=문서">문서</a></li>
				<li><a href="${path}/productlistCategory.cu?category=창업">창업</a></li>
				<li><a href="${path}/productlistCategory.cu?category=주문제작">주문제작</a></li>
				<li><a href="${path}/productlistCategory.cu?category=세무">세무</a></li>
			</ul>
		</nav>
</body>
</html>