<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상품 등록</title>
<link rel="stylesheet" href="${path}/resources/css/expert/mypage.css">
<link rel="stylesheet" href="${path}/resources/css/expert/ad_productadd.css">

</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<!-- header 끝 -->

		<!-- contents 시작 -->
<div class="mypage_block">
		<!--left 메뉴 시작 -->
		<%@include file="/WEB-INF/views/expert/mypage/leftmenu.jsp"%>
		<!--left 메뉴 끝 -->

			<div class="mypage_right">
			<h3>상품등록</h3>
				<div id="right">
						<div class="table_div">
							<form action="${path}/productaddAction.ex?${_csrf.parameterName}=${_csrf.token}" name="productAdd" method="post" enctype="multipart/form-data">
								<table>
									<tr>
										<th>*상품명</th>
										<td><input type="text" class="input" id="name" name="name" size="50" placeholder="상품명 작성" required></td>
									</tr>
									<tr>
										<th>상품이미지</th>
										<td><input type="file" class="input" id="image" name="image"></td>
									</tr>
									<tr>
										<th>카테고리</th>
										<td>
											<select class="input" id="category" name="category">
												<option>카테고리</option>
												<option value="디자인">디자인</option>
												<option value="IT">IT</option>
												<option value="마케팅">마케팅</option>
												<option value="번역">번역</option>
												<option value="문서">문서</option>
												<option value="창업">창업</option>
												<option value="주문제작">주문제작</option>
												<option value="세무">세무</option>
											</select>
										</td>
									</tr>
									<tr>
										<th>간편설명</th>
											<td><input type="text" class="input" id="explanation" name="explanation" size="100" placeholder="간단 설명 작성" required></td>
										</tr>
									<tr>
										<th>상세설명</th>
										<td>
											<textarea rows="5" cols="50" id="description" name="description" placeholder="상세 설명 작성"></textarea>
										</td>
									</tr>
									<tr>
										<th>판매가격</th>
										<td><input type="number" class="input" id="price" name="price" size="10" placeholder="판매 가격 작성"></td>
									</tr>
									<tr>
										<td colspan="2">
											<br>
											<div align="center">
												<input class="inputButton" type="submit" value="상품등록">
												<input class="inputButton" type="reset" value="초기화">
												<input class="inputButton" type="button" class="button" value="등록취소" onclick="window.location='${path}/productlist.ex'">
											</div>
										</td>
									</tr>
								</table>
							</form>
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