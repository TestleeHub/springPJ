<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>main</title>
<link rel="stylesheet" href="${path}/resources/css/common/main.css">
<script type="text/javascript">
</script>
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp" %>
		<!-- header 끝 -->
		<c:if test="${msg != null}">
			<script type="text/javascript">
				alert("${msg}");
			</script>
		</c:if>

		<!-- contents 시작 -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<h3>이런 상품 어때요?</h3>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<div class="border-secondary"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/vaJm21682411147.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">저작권 관련 법률 상담</h6>
							</div>
							<p class="card-text">
								<span class="price">50,000원 <small>&nbsp;4.8점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/eSSkt1682490477.png"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">지식재산권 법률상담을 해드립니다</h6>
							</div>
							<p class="card-text">
								<span class="price">110,000원 <small>&nbsp;5.0점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/Nxz3D1689137084.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">인스타 명문대생이 관리해 드립니다.</h6>
							</div>
							<p class="card-text">
								<span class="price">600,000원 <small>&nbsp;4.9점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/k04oK1596429214.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">누적수익 2억5천만 마케터의 오토수익방법</h6>
							</div>
							<p class="card-text">
								<span class="price">2,750,000원 <small>&nbsp;4.9점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/Nfaar1691116012.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">홈페이지 CMS, ERP,CRM 제작합니다.</h6>
							</div>
							<p class="card-text">
								<span class="price">10,000,000원 <small>&nbsp;5.0점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<br> <br>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<h3>최근 본 상품과 비슷해요.</h3>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/vaJm21682411147.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">저작권 관련 법률 상담</h6>
							</div>
							<p class="card-text">
								<span class="price">50,000원 <small>&nbsp;4.8점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/eSSkt1682490477.png"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">지식재산권 법률상담을 해드립니다</h6>
							</div>
							<p class="card-text">
								<span class="price">110,000원 <small>&nbsp;5.0점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/Nxz3D1689137084.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">인스타 명문대생이 관리해 드립니다.</h6>
							</div>
							<p class="card-text">
								<span class="price">600,000원 <small>&nbsp;4.9점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/k04oK1596429214.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">누적수익 2억5천만 마케터의 오토수익방법</h6>
							</div>
							<p class="card-text">
								<span class="price">2,750,000원 <small>&nbsp;4.9점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/Nfaar1691116012.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">홈페이지 CMS, ERP,CRM 제작합니다.</h6>
							</div>
							<p class="card-text">
								<span class="price">10,000,000원 <small>&nbsp;5.0점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<br> <br>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<h3>현재 가장 인기 있어요</h3>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/vaJm21682411147.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">저작권 관련 법률 상담</h6>
							</div>
							<p class="card-text">
								<span class="price">50,000원 <small>&nbsp;4.8점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/eSSkt1682490477.png"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">지식재산권 법률상담을 해드립니다</h6>
							</div>
							<p class="card-text">
								<span class="price">110,000원 <small>&nbsp;5.0점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/Nxz3D1689137084.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">인스타 명문대생이 관리해 드립니다.</h6>
							</div>
							<p class="card-text">
								<span class="price">600,000원 <small>&nbsp;4.9점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/k04oK1596429214.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">누적수익 2억5천만 마케터의 오토수익방법</h6>
							</div>
							<p class="card-text">
								<span class="price">2,750,000원 <small>&nbsp;4.9점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/Nfaar1691116012.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">홈페이지 CMS, ERP,CRM 제작합니다.</h6>
							</div>
							<p class="card-text">
								<span class="price">10,000,000원 <small>&nbsp;5.0점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<br> <br>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<h3>내가 찜한 상품</h3>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/vaJm21682411147.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">저작권 관련 법률 상담</h6>
							</div>
							<p class="card-text">
								<span class="price">50,000원 <small>&nbsp;4.8점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/eSSkt1682490477.png"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">지식재산권 법률상담을 해드립니다</h6>
							</div>
							<p class="card-text">
								<span class="price">110,000원 <small>&nbsp;5.0점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/Nxz3D1689137084.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">인스타 명문대생이 관리해 드립니다.</h6>
							</div>
							<p class="card-text">
								<span class="price">600,000원 <small>&nbsp;4.9점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/k04oK1596429214.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">누적수익 2억5천만 마케터의 오토수익방법</h6>
							</div>
							<p class="card-text">
								<span class="price">2,750,000원 <small>&nbsp;4.9점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="card"
						style="width: 12rem; height: 300px; padding: 10px; margin: 0 auto;">
						<img
							src="https://d2v80xjmx68n4w.cloudfront.net/gigs/Nfaar1691116012.jpg"
							width="150px" height="150px" class="card-img-top" alt="...">
						<div class="card-body" style="padding: 3px;">
							<div style="height: 40px;">
								<h6 class="card-title">홈페이지 CMS, ERP,CRM 제작합니다.</h6>
							</div>
							<p class="card-text">
								<span class="price">10,000,000원 <small>&nbsp;5.0점</small></span>
							</p>
							<div id="buy_button">
								<a href="#" class="btn btn-warning">구매하기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<br> <br>
		</div>
	<!-- contents 끝 -->

	<!-- footer 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- footer 끝 -->
	</div>
</body>
</html>