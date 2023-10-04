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
		<c:forEach var="dto" items="${dtoList}">
			<div class="purchase_list_block">
				<div class="purchase_list">
					<div class="purchase_list1">
						<div class="purchase_list1_1">${dto.state}</div>
						<div class="purchase_list1_2">주문일시 : ${dto.purchase_date}</div>
					</div>
					<div class="purchase_list2">
						<div class="purchase_list2_1">
							<img alt="" src="${imagePath}/${dto.image}" width="80px"
								height="80px">
						</div>
						<div class="purchase_list2_2">
							<div class="purchase_list2_2_1">
								<div class="purchase_list2_2_1_1">#${dto.purchase_id}(주문번호)</div>
								<div class="purchase_list2_2_1_2">${dto.productName}</div>
							</div>
							<div class="purchase_list2_2_2">${dto.price}원</div>
							<div class="purchase_list2_2_3">
								<div class="purchase_list2_2_3_1">${dto.expertName}</div>
								<div class="purchase_list2_2_3_2">${dto.expertPhone}</div>
							</div>
						</div>
					</div>
					<div class="purchase_list3">
						<c:if test="${dto.state == '구매확정'}">
							<div class="purchase_list3_1">
								구매 확정 되었습니다.<br> A/S 및 환불 관련 사항은 전문가에게 문의해 주세요.
							</div>
							<div class="purchase_list3_2">
								<input type="button" class="btn_down" value="상품이동" style="height: 30px;" onclick="window.location='${path}/productdetail.cu?product_id=${dto.product_id}'">
								<input type="button" class="btn_down" value="리뷰등록" style="height: 30px;" onclick="reviewEdit('${path}',${dto.purchase_id});"> 
							</div>
						</c:if>
						<c:if test="${dto.state == '구매완료'}">
							<div class="purchase_list3_1">
								구매완료 되었습니다. 다운로드를 하려면 구매 확정해 주세요.<br> A/S 및 환불 관련 사항은 전문가에게
								문의해 주세요.
							</div>
							<div class="purchase_list3_2">
								<input type="button" class="btn_down" value="구매확정" style="height: 30px;" onclick="purchaseConfirm('${path}',${dto.purchase_id});"> 
								<input type="button" class="btn_down" value="결제취소" style="height: 30px;" onclick="purchaseCancel('${path}',${dto.purchase_id});">
							</div>
						</c:if>
						<c:if test="${dto.state == '결제취소'}">
							<div class="purchase_list3_1">
								결제가 취소되었습니다.<br> 재구매를 하려면 상품으로 이동해 주세요.
							</div>
							<div class="purchase_list3_2">
								<input type="button" class="btn_down" value="상품이동" onclick="window.location='${path}/productdetail.cu?product_id=${dto.product_id}'">
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</c:forEach>

		<br> <br>
		<div>
			<center style="width: 800px;">
				<!-- 페이징 처리 -->
				<!-- 이전 버튼 활성화 여부 -->
				<c:if test="${paging.startPage > 10}">
					<span><button onclick="loadList('${path}', ${paging.prev}, '${_csrf.token}')" style="border: none; background: none;">[이전]</button></span>
				</c:if>
				<!-- 페이지 번호 처리 -->
				<c:forEach var="num" begin="${paging.startPage}"
					end="${paging.endPage}">
					<span><button onclick="loadList('${path}', ${num}, '${_csrf.token}')" style="border: none; background: none;">${num}</button></span>
				</c:forEach>
				<!-- 다음 버튼 활성화 여부 -->
				<c:if test="${paging.endPage < paging.pageCount}">
					<span><button onclick="loadList('${path}', ${paging.next}, '${_csrf.token}')" style="border: none; background: none;">[다음]</button></span>
				</c:if>
			</center>
		</div>

		<!-- contents 끝 -->
</body>
</html>