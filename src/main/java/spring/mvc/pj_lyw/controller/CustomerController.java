package spring.mvc.pj_lyw.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.pj_lyw.service.CustomerService;

@Controller
public class CustomerController {
	@Inject
	CustomerService service;
	
	@RequestMapping(value = "productlist.cu")
	public String productlist(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readProductList(req, model);
		return"customer/product/productlist";
	}
	
	@RequestMapping(value = "productlistCategory.cu")
	public String productlistCategory(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readCategoryProductList(req, model);
		return"customer/product/productlistCategory";
	}
	@RequestMapping(value = "productsearch.cu")
	public String productsearch(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readSearchProductList(req, model);
		return"customer/product/productlistSearch";
	}
	@RequestMapping(value = "productdetail.cu")
	public String productdetail(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readProductDetail(req, model);
		return"customer/product/productdetail";
	}
	@RequestMapping(value = "mypage.cu")
	public String mypage(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.getPurchaseState(req, model);
		return"customer/mypage/purchaselist";
	}
	@RequestMapping(value = "purchaselist.cu")
	public String purchaselist(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.getPurchaseState(req, model);
		return"customer/mypage/purchaselist";
	}
	@RequestMapping(value = "purchaselistBox.cu")
	public String purchaselistBox(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readPurchaseList(req, model);
		return"customer/mypage/purchaselistBox";
	}
	@RequestMapping(value = "purchaseConfirm.cu")
	public String purchaseConfirm(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.purchaseConfirm(req, model);
		return"customer/mypage/purchaseConfirmAction";
	}
	@RequestMapping(value = "purchaseCancel.cu")
	public String purchaseCancel(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.purchaseCancel(req, model);
		return"customer/mypage/purchaseCancelAction";
	}
	@RequestMapping(value = "wishlist.cu")
	public String wishlist(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readWishList(req, model);
		return"customer/wish/wishlist";
	}
	@ResponseBody
	@RequestMapping(value = "wishAdd.cu")
	public void wishAdd(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.wishAdd(req, model);
		return ;
	}
	@ResponseBody
	@RequestMapping(value = "wishCancel.cu")
	public void wishCancel(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.wishCancel(req, model);
		return;
	}
	@RequestMapping(value = "buyCheckAction.cu")
	public String buyCheckAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.buyCheckAction(req, model);
		return"customer/product/buyCheckAction";
	}
	@RequestMapping(value = "buyAction.cu")
	public String buyAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.buyAction(req, model);
		return"customer/product/buyAction";
	}
	@RequestMapping(value = "reviewEdit.cu")
	public String reviewEdit(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.readReview(req, model);
		return"customer/mypage/reviewEdit";
	}
	@RequestMapping(value = "registReview.cu")
	public String registReview(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		service.registReview(req, model);
		return"customer/mypage/registReview";
	}
}
