package spring.mvc.pj_lyw.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.pj_lyw.service.ExpertService;

@Controller
public class ExpertController {
	@Inject
	ExpertService service;
	
	@RequestMapping(value = "mypage.ex")
	public String mypage(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.getProductState(req, model);
		return"expert/mypage/productlist";
	}
	@RequestMapping(value = "productlist.ex")
	public String productlist(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.getProductState(req, model);
		return"expert/mypage/productlist";
	}
	@RequestMapping(value = "productlistBox")
	public String productlistBox(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readProductList(req, model);
		return"expert/mypage/productlistBox";
	}
	@RequestMapping(value = "productadd.ex")
	public String productadd(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		return"expert/mypage/productadd";
	}
	//사진 추가
	@RequestMapping(value = "productaddAction.ex")
	public String productaddAction(MultipartHttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.addProduct(req, model);
		return"expert/mypage/productaddAction";
	}
	@RequestMapping(value = "productupdate.ex")
	public String productupdate(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readProduct(req, model);
		return"expert/mypage/productupdate";
	}
	//사진 추가
	@RequestMapping(value = "productupdateAction.ex")
	public String productupdateAction(MultipartHttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.updateProduct(req, model);
		return"expert/mypage/productupdateAction";
	}
	@RequestMapping(value = "productdeleteAction.ex")
	public String productdeleteAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.deleteProduct(req, model);
		return"expert/mypage/productdeleteAction";
	}
}
