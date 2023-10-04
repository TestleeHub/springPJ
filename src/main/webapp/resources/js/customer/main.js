 /* 자바스크립트 이벤트 추가 : 햄버거 아이콘을 클릭하면 아래쪽으로 메뉴가 나오도록 main.js에 추가 */
const toggleBtn = document.querySelector('.navbar-toggleBtn');//햄버거 버튼을 검색
const menu = document.querySelector('.navbar_menu');
const icons = document.querySelector('.navbar_icons');

toggleBtn.addEventListener('click', ()=>{
	menu.classList.toggle('active');
	icons.classList.toggle('active');
});