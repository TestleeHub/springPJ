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
		<form action="addNoticeAction.do" name="writeNoticeForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div>
				<input type="text" size="48" name="notice_title" placeholder="공지사항 제목">
			</div>
			<div>
				<textarea rows="10" cols="50" placeholder="공지사항 내용 (500자 이내)" name="notice_text"></textarea>
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