<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상세페이지-${productDTO.name}</title>
<link rel="stylesheet" href="${path}/resources/css/common/main.css">
<link rel="stylesheet" href="${path}/resources/css/customer/productdetail.css">
<script src="${path}/resources/js/customer/productbuy.js"></script>

</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<!-- header 끝 -->

		<!-- contents 시작 -->
		<div class="detail_block">
			<div class="detail_left">
				<div class="detail_img">
					<img alt=""
						src="${imagePath}/${productDTO.image}"
						width="600px" height="450px">
				</div>
				<div class="detail_score">
					<div class="score_child">
						★★★★★${reviewGradeAvg}점 <small>(${reviewCnt}개의 평가)</small>
					</div>
				</div>
				<div class="detail_info">
					<div class="detail_info_selector">
						<div class="detail_info_selector_child">
							서비스 설명</small>
						</div>
					</div>
					<div class="detail_info_contents">
						${productDTO.description}
					
					</div>
				</div>
				<div class="review_main_block">
					<div class="review_tatal_block">
						<div class="review_total_title">서비스 평가</div>
						<div class="review_total_score_block">
							<div class="review_tatal_score">${reviewGradeAvg}점</div>
							<div class="review_tatal_count">${reviewCnt}개의 평가</div>
						</div>
						<div class="review_notice"> <small>실제 구매자들이 남긴 평가 입니다.</small></div>
					</div>
					<div class="review_detail_block">
						<div class="review_detail_title">서비스 후기 ${reviewCnt}개</div>
						
						<c:forEach var="reviewDTO" items="${reviewList}">
							<div class="review_detail_content">
								<div class="review_user_block">
									<div class="review_user_img"><img alt="" src="${path}/resources/images/userimg.PNG" width="20px"></div>
									<div class="review_user_info_block">
										<div class="review_user_id">${reviewDTO.nickname}</div>
										<div class="review_user_score_block">
											<div class="review_user_score">${reviewDTO.grade}점</div>
											<div class="review_user_score_time">${reviewDTO.reg_date}</div>
										</div>
									</div>
								</div>
								<div class="review_conent_block">${reviewDTO.review_text}</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="detail_right">
				<div class="detail_subject"><h5>${productDTO.name}</h5></div>
				<div class="detail_pd_info">
					<div class="detail_price">${productDTO.price}원<br><small>무이자 할부 혜택</small></div>
					<div class="detail_pd_contents">${productDTO.explanation}</div>
					<div class="detail_buy_btn">
						<input type="button" class="detail_buy_inputButton" value="구매하기" onclick="onclickBuyBtn(${productDTO.product_id}, ${productDTO.price}, '${path}', '${_csrf.token}');">
					</div>
				</div>
				<div class="seller_info"></div>
			</div>
		</div>
		<div id="resultChk">
		</div>
		<!-- contents 끝 -->

		<!-- footer 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>