<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>제품 목록 ${totalProductCnt}개의 서비스</title>
<link rel="stylesheet" href="${path}/resources/css/common/main.css">
<script src="${path}/resources/js/customer/productlist.js"></script>
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<!-- header 끝 -->

		<!-- contents 시작 -->
<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<h3>제품 목록 ${totalProductCnt}개의 서비스</h3>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
			<c:forEach var="dto" items="${dtoList}" varStatus="loop">
				<c:if test="${loop.count % 5 == 1}">
				<div class="row">
				<div class="col-md-1"></div>
				</c:if>
				<div class="col-md-2">
					<div class="card border-secondary"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="${imagePath}/${dto.image}"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">${dto.name}</h6>
							</div>
							<p class="card-text">
								<span class="price">${dto.price}원 <!-- <small>&nbsp;4.8점</small> --></span>
							</p>
							<div id="buy_button">
							<c:if test="${dto.wished == 'wished' }">
								<div><input type="button" value="♥" id="WishBtn${dto.product_id}" style="outline: none; border: none; background:white; color: red;" onclick="onclickWishBtn(${dto.product_id}, '${path}', '${_csrf.token}');"></div>
							</c:if>
							<c:if test="${dto.wished != 'wished' }">
								<div><input type="button" value="♡" id="WishBtn${dto.product_id}" style="outline: none; border: none; background:white; color: red;" onclick="onclickWishBtn(${dto.product_id}, '${path}', '${_csrf.token}');"></div>
							</c:if>
								<a href="productdetail.cu?product_id=${dto.product_id}" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<c:if test="${loop.count % 5 == 0 || loop.last}">
				<div class="col-md-1"></div>
				</div>
			
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10"><p></p></div>
						<div class="col-md-1"></div>
					</div>
				</c:if>
				</c:forEach>
				
			
			<br> <br>
			<div>
				<center>
					<!-- 페이징 처리 -->
					<!-- 이전 버튼 활성화 여부 -->
					<c:if test="${paging.startPage > 10}">
						<a href="${path}/productsearch.cu?pageNum=${paging.prev}&target=${target}">[이전]</a>
					</c:if>
					<!-- 페이지 번호 처리 -->
					<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
						<a href="${path}/productsearch.cu?pageNum=${num}&target=${target}">${num}</a>
					</c:forEach>
					<!-- 다음 버튼 활성화 여부 -->
					<c:if test="${paging.endPage < paging.pageCount}">
						<a href="${path}/productsearch.cu?pageNum=${paging.next}&target=${target}">[다음]</a>
					</c:if>
				</center>
			</div>
		</div>
		<!-- contents 끝 -->

		<!-- footer 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>