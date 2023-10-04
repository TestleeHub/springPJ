<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>구매 관리</title>
<link rel="stylesheet" href="${path}/resources/css/common/main.css">
<link rel="stylesheet" href="${path}/resources/css/expert/mypage.css">
<script src="${path}/resources/js/customer/purchaselist.js"></script>
<script type="text/javascript">
	$(function() {
		loadList('${path}', 1, '${_csrf.token}');
	});
</script>
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
			<div class="mypage_right" id="mainfocus">
				<div class="product_state_block">
					<h3>구매 관리</h3>
					<div class="product_state">
						<ul>
							<li>
								<div class="state1">
									<div class="state2"><i class="fa-regular fa-square-caret-down"></i></div>
									<div class="state3">구매 진행중(완료)</div>
								</div>
								<div class="state4">${buyCnt}건</div>
							</li>
							<li>
								<div class="state1">
									<div class="state2"><i class="fa-solid fa-plane-arrival"></i></div>
									<div class="state3">작업물 도착</div>
								</div>
								<div class="state4">0건</div>
							</li>
							<li>
								<div class="state1">
									<div class="state2"><i class="fa-regular fa-rectangle-xmark"></i></div>
									<div class="state3">취소, 문제 해결</div>
								</div>
								<div class="state4">${cancelCnt}건</div>
							</li>
							<li>
								<div class="state5">
									<div class="state1">
										<div class="state3">구매 확정</div>
										<div class="state3">${confirmCnt}건</div>
									</div>
									<div class="state1">
										<div class="state3">작성 가능한 평가</div>
										<div class="state3">0건</div>
									</div>
									<div class="state1">
										<div class="state3">주문 취소</div>
										<div class="state3">${cancelCnt}건</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
					
					<div id="purchaselistBox">
					</div>
					
					
					<div class="alert_block">
						<div class="alert_1">
						<h2>꼭 확인해 주세요!</h2>
						<ul>
							<li> 주문 금액에 대한 세금계산서는 거래 주체인 전문가가 직접 발행하며, 세금계산서 발행 가능한 사업자 전문가의 서비스 구매 시에만 신청하실 수 있습니다.</li>
							<li> 수수료에 대한 세금계산서는 크몽이 발행합니다.</li>
							<li> 이벤트 쿠폰 사용 금액은 할인된 금액이기 때문에 세금계산서에 포함되지 않습니다.</li>
							<li> 거래명세서는 결제가 완료되었음을 증명하는 용도로만 활용 가능하며 세무상의 지출증빙 효력이 없습니다.</li>
							<li> 현금영수증은 개인의 소득공제용으로만 사용 가능하며, 결제 당시 지출 증빙용으로 선택하셨더라도 매입세액공제를 받으실 수 없습니다.</li>
						</ul>
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