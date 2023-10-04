<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원정보수정-비밀번호 입력</title>
<link rel="stylesheet" href="${path}/resources/css/customer/login.css">
<script type="text/javascript">
</script>
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
					<h3 align="center">회원 정보 수정을 위해 비밀번호를 입력해 주세요.</h3>
				</div>
				<!-- 상단 중앙 2시작 -->
				<div id="section2">
					<div id="section2_inner">
						<div class="login">
							<form name="loginform" method="post" action="updatepwdChkAction.do">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								<fieldset>
									<legend></legend>
									<table>
										<tr>
											<th>*비밀번호</th>
											<td><input type="password" class="input" name="password"
												size="20" placeholder="공백없이 20자이내로 작성" required></td>
										</tr>
										<tr>
											<td colspan="2" style="border-bottom: none;"><br>
												<div align="center">
													<input class="inputButton" type="submit" value="입력">
													<input class="inputButton" type="reset" value="초기화">
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