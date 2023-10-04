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
<link rel="stylesheet" href="${path}/resources/css/customer/login.css">
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
					<h1 align="center">로그인</h1>
				</div>
				<!-- UserLoginFailureHandler 에서 msg 넘김 -->
   				<c:if test="${errorMsg != null}">
      				<script type="text/javascript">
         				alert("${errorMsg}");
      				</script>
   				</c:if>
				<!-- 상단 중앙 2시작 -->
				<div id="section2">
					<div id="section2_inner">
						<div class="login">
							<form name="loginform" method="post" action="loginAction.do">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								<fieldset>
									<legend></legend>
									<table>
										<tr>
											<th>*아이디</th>
											<td><input type="text" class="input" name="id" size="50"
												placeholder="공백없이 50자이내로 작성" autofocus required></td>
										</tr>
										<tr>
											<th>*비밀번호</th>
											<td><input type="password" class="input" name="password"
												size="20" placeholder="공백없이 20자이내로 작성" required></td>
										</tr>
										<tr>
											<td colspan="2" style="border-bottom: none;"><br>
												<div align="center">
													<input class="inputButton" type="submit" value="로그인">
													<input class="inputButton" type="reset" value="초기화">
													<input class="inputButton" type="button" class="button"
														value="회원가입" onclick="window.location='../join/join.html'">
												</div></td>
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