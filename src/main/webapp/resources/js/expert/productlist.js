/**
 * 
 */
let loadList = function(path, pageNum, token) {
	let param = {
			pageNum : pageNum,
			_csrf: token
	};
	
	$.ajax({
		url:path + "/productlistBox.ex?pageNum=" + pageNum,
		type:"post",
		data:param,
		success:function(result){
			$("#productlistBox").html(result);
			$('body').scrollTop(0);
		},
		error:function(){
			alert("제품리스트 로딩 오류");
		}
	});
}