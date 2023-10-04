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
		<c:if test="${!ChkResult}">
			<script type="text/javascript">
				setTimeout(() => {
					alert("암호를 확인해 주세요");
					window.location="${path}/updatepwdChk.do";
				}, 300);
			</script>
		</c:if>
		<c:if test="${ChkResult}">
			<script type="text/javascript">
				setTimeout(() => {
					window.location="${path}/memberUpdate.do";
				}, 300);
			</script>
		</c:if>
		<!-- contents 끝 -->

		<!-- footer 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>