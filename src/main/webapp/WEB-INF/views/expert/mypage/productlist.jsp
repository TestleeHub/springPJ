<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>제품 목록</title>
<link rel="stylesheet" href="${path}/resources/css/common/main.css">
<link rel="stylesheet" href="${path}/resources/css/expert/mypage.css">
<script src="${path}/resources/js/expert/productlist.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	$(function() {
		loadList('${path}', 1, '${_csrf.token}');
	});
	
	// Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {

      // Create the data table.
      var data = new google.visualization.DataTable();
      data.addColumn('string', '진행상태');
      data.addColumn('number', '건 수');
      data.addRows([
        ['구매완료', ${buycnt}],
        ['구매확정', ${confirmcnt}],
        ['결제취소', ${cancelcnt}],
      ]);

      // Set chart options
      var options = {'title':'전체 주문현황',
                     'width':280,
                     'height':150};

      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
      chart.draw(data, options);
      
      // 막대 그래프
      
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawcolumnChart);

      function drawcolumnChart() {
    	  var data = new google.visualization.DataTable();
        data.addColumn('string', '월');
        data.addColumn('number', '구매확정');
        data.addColumn('number', '결제취소');
        data.addColumn('number', '구매완료');
        <c:forEach var="dto" items="${chartDTOList}">
        data.addRow(['${dto.month}', ${dto.confirmCnt}, ${dto.cancelCnt}, ${dto.buyCnt}]);
        </c:forEach>

        var options = {
          chart: {
            title: '전체 결산 금액 : ${totalPrice} 원',
            subtitle: '최근 6개월 구매 현황',
          },
          vAxis : {
          	viewWindow: {
                      max:20,
                      min:0
                    }
          	}
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
      
    }
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
		<%@include file="/WEB-INF/views/expert/mypage/leftmenu.jsp"%>
		<!--left 메뉴 끝 -->

			<div class="mypage_right">
				<div class="product_state_block">
					<h3>상품목록/정산</h3>
					<div class="product_state">
						<ul>
							<li>
								<div class="state1">
									<div id="chart_div"></div>
								</div>
							</li>
							<li>
								<div class="state1">
									<div id="columnchart_material"></div>
								</div>
							</li>
						</ul>
					</div>
					<div id="right">
						<div class="table_div">
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
														<img
															src="${imagePath}/${dto.image}"
															class="img-fluid rounded-start" alt="...">
													</div>
													<div class="col-md-8">
														<div class="card-body">
															<h5 class="card-title" style="font-weight: bold;">${dto.name}</h5>
															<p class="card-text">${dto.explanation}</p>
															<p class="card-text">
																<small class="text-body-secondary">구매진행
																	${dto.buycnt}건 주문취소 ${dto.cancelcnt}건 구매 확정
																	${dto.confirmcnt}건 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 정산 금액
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
						</div>
					</div>
					
					<div id="productlistBox"></div>
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