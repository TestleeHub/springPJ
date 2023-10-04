package spring.mvc.pj_lyw.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ExpertService {
	// 전문가 - 상품 목록 조회
	public void readProductList(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 전문가 - 상품 상태 조회
	public void getProductState(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 전문가 - 상품 등록
	public void addProduct(MultipartHttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 전문가 - 상품 디테일 조회
	public void readProduct(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 전문가 - 상품 업데이트
	public void updateProduct(MultipartHttpServletRequest req, Model model) 
			throws ServletException, IOException;
	// 전문가 - 상품 삭제
	public void deleteProduct(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
}
