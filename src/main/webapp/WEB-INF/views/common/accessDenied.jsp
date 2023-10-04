<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>main</title>
<link rel="stylesheet" href="${path}/resources/css/common/main.css">

</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<!-- header 끝 -->

		<!-- contents 시작 -->
		<div id="container">
			<div id="contents" style="text-align: center">
				<h1>허용 되지 않은 접근!</h1>
				<br>

				<!-- UserDeniedHandler에서  errMsg 전달 -->
				<p style="font-size: 18px">${errMsg}</p>
				<br>

				<c:if test="${sessionID !=null}">
					<button value="로그아웃" class="inputButton"
						style="width: 200px; font-size: 24px; text-align: center;"
						onclick="window.location='${path}/logout.do'">로그아웃</button>
				</c:if>
				<c:if test="${sessionID == null}">
					<button value="로그인창" class="inputButton"
						style="width: 200px; font-size: 24px; text-align: center;"
						onclick="window.location='${path}/login.do'">로그인창 이동</button>
				</c:if>
			</div>
		</div>
		<!-- contents 끝 -->

		<!-- footer 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>