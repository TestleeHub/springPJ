<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<title>main</title>
</head>
<body>
	<c:forEach var="dto" items="${dtoList}" varStatus="status">
		<div class="row" style="-bs-gutter-x: 0;">
			<div class="col-md-1"
				style="text-align: right; line-height: 150px; font-size: 20px;">
				${paging.startRow + status.index}&nbsp;&nbsp;</div>
			<div class="col-md-11">
				<div class="card mb-3" style="max-width: 800px;">
					<a href="${path}/productupdate.ex?product_id=${dto.product_id}">
						<div class="row" style="-bs-gutter-x: 0;">
							<div class="col-md-3">
								<img src="${imagePath}/${dto.image}"
									class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title" style="font-weight: bold;">${dto.name}</h5>
									<p class="card-text">${dto.explanation}</p>
									<p class="card-text">
										<small class="text-body-secondary">구매진행 ${dto.buycnt}건
											주문취소 ${dto.cancelcnt}건 구매 확정 ${dto.confirmcnt}건
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 정산 금액
											${dto.confirmcnt*dto.price}원</small>
									</p>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</c:forEach>

	<br>
	<br>
	<div>
		<center style="width: 800px;">
			<!-- 페이징 처리 -->
			<!-- 이전 버튼 활성화 여부 -->
			<c:if test="${paging.startPage > 10}">
				<span><button onclick="loadList('${path}', ${paging.prev}, '${_csrf.token}')"
						style="border: none; background: none;">[이전]</button></span>
			</c:if>
			<!-- 페이지 번호 처리 -->
			<c:forEach var="num" begin="${paging.startPage}"
				end="${paging.endPage}">
				<span><button onclick="loadList('${path}', ${num}, '${_csrf.token}')"
						style="border: none; background: none;">${num}</button></span>
			</c:forEach>
			<!-- 다음 버튼 활성화 여부 -->
			<c:if test="${paging.endPage < paging.pageCount}">
				<span><button onclick="loadList('${path}', ${paging.next}, '${_csrf.token}')"
						style="border: none; background: none;">[다음]</button></span>
			</c:if>
		</center>
	</div>

	<!-- contents 끝 -->
</html>