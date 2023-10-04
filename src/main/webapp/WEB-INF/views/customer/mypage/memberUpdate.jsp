<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원정보 수정</title>
<link rel="stylesheet" href="${path}/resources/css/common/main.css">
<link rel="stylesheet" href="${path}/resources/css/expert/mypage.css">
<link rel="stylesheet" href="${path}/resources/css/customer/join.css">
<script src="${path}/resources/js/common/memberUpdate.js"></script>

</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<!-- header 끝 -->

		<!-- contents 시작 -->
<div class="mypage_block">
			<!--left 메뉴 시작 -->
			<%@include file="/WEB-INF/views/customer/mypage/leftmenu.jsp"%>
			<!--left 메뉴 끝 -->
			<div id="container">
			<div id="contents">
				<!-- 상단 중앙 1시작 -->
				<div id="section1">
					<h1 align="center">회원정보 수정</h1>
				</div>
				<!-- 상단 중앙 2시작 -->
				<div id="section2">
					<div id="section2_inner">
						<div class="join">
							<form action="${path}/memberUpdateAction.do" name="userInfoForm" method="post" onsubmit="return submit_check();">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								<fieldset>
									<legend></legend>
									<table>
										<tr>
											<th>*이메일</th>
											<td>${dto.email} <input type="hidden" name="email" value="${dto.email}"></td>
										</tr>
										<tr>
											<th>*비밀번호</th>
											<td><input type="password" class="input" name="password"
												size="20" placeholder="공백없이 20자이내로 작성" required value="${dto.password}"></td>
										</tr>
										<tr>
											<th>*비밀번호 확인</th>
											<td><input type="password" class="input" name="repassword"
												size="20" placeholder="비밀번호 확인" required></td>
										</tr>
										<tr>
											<th>*닉네임</th>
											<td><input type="text" class="input" name="nickname" size="20"
												placeholder="공백없이 20자이내로 작성" required value="${dto.nickname}"></td>
										</tr>
										<c:if test="${dto.phone != null }">
										<c:set var="hpArr" value="${fn:split(dto.phone, '-')}"/>
										<tr>
											<th>연락처</th>
											<td>
												<input type="text" class="input" name="hp1" size="3" style="width: 50px" value="${hpArr[0]}">
												-
												<input type="text" class="input" name="hp2" size="4" style="width: 70px" value="${hpArr[1]}">
												-
												<input type="text" class="input" name="hp3" size="4" style="width: 70px" value="${hpArr[2]}">
											</td>
										</tr>
										</c:if>
										<tr>
											<td colspan="2" style="border-bottom: none;"><br>
												<div align="center">
													<input class="inputButton" type="submit" value="수정">
													<input class="inputButton" type="reset" value="초기화">
													<input class="inputButton" type="button" class="button"
														value="회원 탈퇴"
														onclick="deleteconfirm('${path}');">
												</div>
											</td>
										</tr>
									</table>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
</div>
	
		<!-- contents 끝 -->

		<!-- footer 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>