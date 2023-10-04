/**
 * 
 */
 	let loadList = function(path, pageNum, token) {
		let param = {
				pageNum : pageNum,
				_csrf: token
		};
		
		$.ajax({
			url:path + "/purchaselistBox.cu?pageNum=" + pageNum,
			type:"post",
			data:param,
			success:function(result){
				$("#purchaselistBox").html(result);
				$('body').scrollTop(0);
			},
			error:function(){
				alert("구매리스트 로딩 오류");
			}
		});
	}

	let purchaseConfirm = function(path, purchase_id) {
		if(confirm("구매확정 하시겠습니까?")){
			window.location= path + "/purchaseConfirm.cu?purchase_id="+purchase_id;
		}
	}
	let purchaseCancel = function(path, purchase_id) {
		if(confirm("구매취소 하시겠습니까?")){
			window.location= path + "/purchaseCancel.cu?purchase_id="+purchase_id;
		}
	}
	
	let reviewEdit = function(path, purchase_id) {
		let left = Math.ceil((window.screen.width - 500)/2);
		let top = Math.ceil((window.screen.height - 300)/2);
		
		let url = path + "/reviewEdit.cu?purchase_id="+purchase_id;
		window.open(url, "confirm", "menubar=no,width=500,height=300,left="+left+",top="+top);
	}