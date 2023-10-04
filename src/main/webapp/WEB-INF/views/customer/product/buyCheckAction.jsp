<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<!-- header 시작 -->
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<!-- header 끝 -->

	<!-- contents 시작 -->
	<!-- 체크결과 existed -->
	<c:if test="${existed}">
		<script type="text/javascript">
			alert("이미 구매한 상품입니다.");
		</script>
	</c:if>
	<c:if test="${!existed}">
		<script type="text/javascript">
			window.location="${path}/buyAction.cu?product_id=${product_id}&price=${price}";
		</script>
	</c:if>
	<!-- contents 끝 -->

	<!-- footer 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<!-- footer 끝 -->
</body>
</html>