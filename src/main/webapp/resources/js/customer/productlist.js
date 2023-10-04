/**
 * 
 */
let onclickWishBtn = function(product_id, contextPath, token) {
	if(document.getElementById("WishBtn"+product_id).value == '♥'){
		wishCancel(product_id, contextPath, token);
	}else{
		wishAdd(product_id, contextPath, token);
	}
}

let wishCancel = function(product_id, contextPath, token) {
	let param = {
			product_id : product_id,
			_csrf: token
	}
	$.ajax({
		url:contextPath+"/wishCancel.cu",
		type:"post",
		data:param,
		success:function(result){
			document.getElementById("WishBtn"+product_id).value = '♡';
		},
		error:function(){
			alert("찜해제 실패!");
		}
	});
}

let wishAdd = function(product_id, contextPath, token) {
	let param = {
			product_id : product_id,
			_csrf: token
	}
	$.ajax({
		url:contextPath+"/wishAdd.cu",
		type:"post",
		data:param,
		success:function(result){
			document.getElementById("WishBtn"+product_id).value = '♥';
		},
		error:function(){
			alert("찜등록 실패!");
		}
	});
}
