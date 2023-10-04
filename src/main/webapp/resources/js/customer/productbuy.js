/**
 * 
 */
let onclickBuyBtn = function(product_id, price, contextPath, token) {
	let param = {
			product_id : product_id,
			price : price,
			_csrf: token
	}
	$.ajax({
		url:contextPath+"/buyCheckAction.cu",
		type:"post",
		data:param,
		success:function(result){
			$("#resultChk").html(result);
		},
		error:function(){
			alert("구매 실패!");
		}
	});
}