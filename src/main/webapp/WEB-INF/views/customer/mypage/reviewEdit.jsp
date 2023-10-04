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
</head>
<body>
	<div style="width: 400px;">
		<form action="registReview.cu" name="writeReviewForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="hidden" name="purchase_id" value="${dto.purchase_id}">
			<div>
				상품 만족도 
				<select name="grade">
					<option id="Grade0" value="0" <c:if test="${dto.grade == 0 }">selected</c:if>>선택</option>
					<option id="Grade1" value="1" <c:if test="${dto.grade == 1 }">selected</c:if>>1</option>
					<option id="Grade2" value="2" <c:if test="${dto.grade == 2 }">selected</c:if>>2</option>
					<option id="Grade3" value="3" <c:if test="${dto.grade == 3 }">selected</c:if>>3</option>
					<option id="Grade4" value="4" <c:if test="${dto.grade == 4 }">selected</c:if>>4</option>
					<option id="Grade5" value="5" <c:if test="${dto.grade == 5 }">selected</c:if>>5</option>
				</select>
			</div>
			<div>
				<textarea rows="10" cols="50" placeholder="상품 후기(500자 이내)" name="review_text">${dto.review_text}</textarea>
			</div>
			<div>
				<center>
					<input type="submit" value="전송">
					<input type="reset" value="초기화">
					<input type="button" value="취소">
				</center>
			</div>
		</form>
	</div>
</body>
</html>