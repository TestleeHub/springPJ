package spring.mvc.pj_lyw.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface CustomerService {
	// 고객 - 상품 목록
	public void readProductList(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 카테고리 상품 목록
	public void readCategoryProductList(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 검색 상품 목록
	public void readSearchProductList(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 구매 목록
	public void readPurchaseList(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 구매 상태 조회
	public void getPurchaseState(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 찜 목록 조회
	public void readWishList(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 상품 상세 조회
	public void readProductDetail(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 구매 확정
	public void purchaseConfirm(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 구매 취소
	public void purchaseCancel(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 찜 목록 추가
	public void wishAdd(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 찜 목록 삭제
	public void wishCancel(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 구매 액션
	public void buyAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 이전 구매여부 체크
	public void buyCheckAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 리뷰 호출
	public void readReview(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 고객 - 리뷰 등록
	public void registReview(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	
}
