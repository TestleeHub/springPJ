<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<link rel="stylesheet" href="${path}/resources/css/customer/join.css">
<script src="${path}/resources/js/common/join.js"></script>
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<!-- header 끝 -->

		<!-- contents 시작 -->
<div id="container">
			<div id="contents">
				<!-- 상단 중앙 1시작 -->
				<div id="section1">
					<h1 align="center">회원가입</h1>
				</div>
				<!-- 상단 중앙 2시작 -->
				<div id="section2">
					<div id="section2_inner">
						<div class="join">
							<form action="${path}/joinAction.do" name="userInfoForm" method="post" onsubmit="return submit_check();">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								<fieldset>
									<legend></legend>
									<table>
										<tr>
											<td colspan="2">
												<label for="option1"><input type="radio" name="authority" id="expert" value="expert">전문가 회원가입</label>
												<label for="option1"><input type="radio" name="authority" id="client" value="client" checked>고객 회원가입</label>
											</td>
										</tr>
										<tr>
											<th>*이메일</th>
											<td>
												<input type="text" class="input" name="email1" maxlength="20" style="width: 100px"
													placeholder="이메일 작성" required>
												@
												<input type="text" class="input" name="email2" maxlength="20" style="width: 100px"
													placeholder="이메일 작성" required>
												<select class="input" name="email3" style="width: 100px" onchange="selectEmailChk();">
													<option value="0">직접입력</option>
													<option value="naver.com">네이버</option>
													<option value="gmail.com">구글</option>
													<option value="daum.net">다음</option>
													<option value="nate.com">네이트</option>
												</select>
											</td>
										</tr>
										<tr>
											<th>*비밀번호</th>
											<td><input type="password" class="input" name="password"
												size="20" placeholder="공백없이 20자이내로 작성" required></td>
										</tr>
										<tr>
											<th>*비밀번호 확인</th>
											<td><input type="password" class="input" name="repassword"
												size="20" placeholder="비밀번호 확인" required></td>
										</tr>
										<tr>
											<th>*닉네임</th>
											<td><input type="text" class="input" name="nickname" size="20"
												placeholder="공백없이 20자이내로 작성" required></td>
										</tr>
										<tr>
											<th>*연락처</th>
											<td>
												<input type="text" class="input" name="hp1" size="3" style="width: 50px" required>
												-
												<input type="text" class="input" name="hp2" size="4" style="width: 70px" required>
												-
												<input type="text" class="input" name="hp3" size="4" style="width: 70px" required>
											</td>
										</tr>
										<tr>
											<td colspan="2" style="border-bottom: none;"><br>
												<div align="center">
													<input class="inputButton" type="submit" value="회원가입">
													<input class="inputButton" type="reset" value="초기화">
													<input class="inputButton" type="button" class="button"
														value="가입취소"
														onclick="window.location='${path}/login.do'">
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
		<!-- contents 끝 -->

		<!-- footer 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>