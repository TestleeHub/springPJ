<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>공지사항</title>
<link rel="stylesheet" href="${path}/resources/css/common/main.css">
<link rel="stylesheet" href="${path}/resources/css/common/notice.css">
<script src="${path}/resources/js/common/notice.js"></script>
</head>
<body>
	<div class="wrap">
	
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<!-- header 끝 -->

		<!-- contents 시작 -->
		<div class="content_block">
			<div></div>
			<div class="notice_block">
				<h3>공지사항</h3>
				<ul>
					<c:forEach var="dto" items="${dtoList}">
					<li id="title_${dto.notice_id}" onclick="noticeDetail(${dto.notice_id});"><a href="#notice"><small>#${dto.notice_id}</small>&nbsp &nbsp ${dto.notice_title}</a></li>
					<li id="notice_${dto.notice_id}" style="display: none;">
						<div>${dto.notice_text}</div>
						<c:if test="${SessionAuthority == 'ROLE_ADMIN'}">
							<div align="right">
								<input type="button" value="수정 및 삭제" onclick="noticeDetailEdit('${path}',${dto.notice_id});">
							</div>
						</c:if>
					</li>
					</c:forEach>
				</ul>
				<c:if test="${SessionAuthority == 'ROLE_ADMIN'}">
					<div align="right">
						<input class="inputButton" type="button" value="글쓰기" onclick="noticeEdit('${path}');">
					</div>
				</c:if>
				<center>
				<!-- 페이징 처리 -->
				<!-- 이전 버튼 활성화 여부 -->
				<c:if test="${paging.startPage > 10}">
					<span><button onclick="window.location='${path}/notice.do?pageNum=${paging.prev}'" style="border: none; background: none;">[이전]</button></span>
				</c:if>
				<!-- 페이지 번호 처리 -->
				<c:forEach var="num" begin="${paging.startPage}"
					end="${paging.endPage}">
					<span><button onclick="window.location='${path}/notice.do?pageNum=${num}'" style="border: none; background: none;">${num}</button></span>
				</c:forEach>
				<!-- 다음 버튼 활성화 여부 -->
				<c:if test="${paging.endPage < paging.pageCount}">
					<span><button onclick="window.location='${path}/notice.do?pageNum=${paging.next}'" style="border: none; background: none;">[다음]</button></span>
				</c:if>
				</center>
			</div>
			<div></div>
		</div>
		<!-- contents 끝 -->

		<!-- footer 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>