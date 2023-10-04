/**
 * 
 */
let noticeDetail = function(notice_id) {
	let title = document.getElementById('title_'+notice_id);
	let target = document.getElementById('notice_'+notice_id);
	
	if(target.style.display == 'none'){
		target.style.display = 'block';
		title.style.fontWeight = 'bold';
	}else {
		target.style.display = 'none'
		title.style.fontWeight = 'normal';
	}
}

let noticeEdit = function(path){
	let left = Math.ceil((window.screen.width - 500)/2);
	let top = Math.ceil((window.screen.height - 300)/2);
		
	let url = path + "/addNotice.do";
	window.open(url, "confirm", "menubar=no,width=500,height=330,left="+left+",top="+top);
}

let noticeDetailEdit = function(path, notice_id){
	let left = Math.ceil((window.screen.width - 500)/2);
	let top = Math.ceil((window.screen.height - 300)/2);
		
	let url = path + "/noticeDetail.do?notice_id="+notice_id;
	window.open(url, "confirm", "menubar=no,width=500,height=330,left="+left+",top="+top);
}