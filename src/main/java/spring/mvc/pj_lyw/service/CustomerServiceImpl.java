package spring.mvc.pj_lyw.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.pj_lyw.dao.CustomerDAO;
import spring.mvc.pj_lyw.dto.ProductDTO;
import spring.mvc.pj_lyw.dto.PurchaseDTO;
import spring.mvc.pj_lyw.dto.ReviewDTO;
import spring.mvc.pj_lyw.page.Paging;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Inject
	CustomerDAO dao;
	
	@Override
	public void registReview(HttpServletRequest req, Model model) throws ServletException, IOException {
		int registCnt = 0;
		int purchase_id = Integer.parseInt(req.getParameter("purchase_id"));
		ReviewDTO dto = new ReviewDTO();
		dto.setPurchase_id(purchase_id);
		dto.setGrade(Integer.parseInt(req.getParameter("grade")));
		dto.setReview_text(req.getParameter("review_text"));
		
		if(dao.existReview(purchase_id) > 0) {
			registCnt = dao.updateReview(dto);
		}else {
			registCnt = dao.insertReview(dto);
		}
		
		req.setAttribute("registCnt", registCnt);
	}

	@Override
	public void readReview(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int purchase_id = Integer.parseInt(req.getParameter("purchase_id"));
		
		ReviewDTO dto = (dao.getReview(purchase_id) != null) ? dao.getReview(purchase_id) : new ReviewDTO();
		dto.setPurchase_id(purchase_id);
		System.out.println("dto = " + dto);
		
		req.setAttribute("dto", dto);
	}

	@Override
	public void readCategoryProductList(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		String pageNum = req.getParameter("pageNum");
		String category = req.getParameter("category");
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		
		Paging paging = new Paging(pageNum);
		paging.setPageSize(25);
		int total = dao.productCategoryCnt(category);
		paging.setTotalCount(total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		map.put("client_id", client_id);
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());
		
		List<ProductDTO> dtoList = dao.productListCategory(map);
		
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("paging", paging);
		req.setAttribute("category", category);
		req.setAttribute("totalProductCnt", total);
	}

	@Override
	public void readSearchProductList(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		String pageNum = req.getParameter("pageNum");
		String target = req.getParameter("target");
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		
		Paging paging = new Paging(pageNum);
		paging.setPageSize(25);
		int total = dao.productSerchCnt(target);
		paging.setTotalCount(total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("client_id", client_id);
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());
		
		List<ProductDTO> dtoList = dao.productListSerch(map);
		
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("paging", paging);
		req.setAttribute("target", target);
		req.setAttribute("totalProductCnt", total);
	}

	@Override
	public void readProductList(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		
		String pageNum = req.getParameter("pageNum");
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);;
		
		Paging paging = new Paging(pageNum);
		paging.setPageSize(25);
		int total = dao.productCnt();
		paging.setTotalCount(total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", client_id);
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());
		
		List<ProductDTO> dtoList = dao.productList(map);
		
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("paging", paging);
		req.setAttribute("totalProductCnt", total);
	}

	@Override
	public void readPurchaseList(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		String pageNum = req.getParameter("pageNum");
		Paging paging = new Paging(pageNum);
		paging.setPageSize(5);
		int total = dao.getPurchaseCnt(client_id);
		
		paging.setTotalCount(total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", client_id);
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());
		
		List<PurchaseDTO> dtoList = dao.purchaseList(map);
		
		int buyCnt = 0;
		int confirmCnt = 0;
		int cancelCnt = 0;
		
		for (PurchaseDTO dto : dtoList) {
			if(dto.getState().equals("구매확정")) confirmCnt++;
			else if(dto.getState().equals("구매완료")) buyCnt++;
			else if(dto.getState().equals("결제취소")) cancelCnt++;
		}
		
		req.setAttribute("buyCnt", buyCnt);
		req.setAttribute("confirmCnt", confirmCnt);
		req.setAttribute("cancelCnt", cancelCnt);
		req.setAttribute("paging", paging);
		req.setAttribute("dtoList", dtoList);
	}

	@Override
	public void getPurchaseState(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		
		List<PurchaseDTO> dtoList = dao.totalPurchaseList(client_id);
		
		int buyCnt = 0;
		int confirmCnt = 0;
		int cancelCnt = 0;
		
		for (PurchaseDTO dto : dtoList) {
			if(dto.getState().equals("구매확정")) confirmCnt++;
			else if(dto.getState().equals("구매완료")) buyCnt++;
			else if(dto.getState().equals("결제취소")) cancelCnt++;
		}
		
		req.setAttribute("buyCnt", buyCnt);
		req.setAttribute("confirmCnt", confirmCnt);
		req.setAttribute("cancelCnt", cancelCnt);
	}

	@Override
	public void readWishList(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		
		String pageNum = req.getParameter("pageNum");
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		
		Paging paging = new Paging(pageNum);
		paging.setPageSize(25);
		int total = dao.wishListCnt(client_id);
		paging.setTotalCount(total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", client_id);
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());
		
		List<ProductDTO> dtoList = dao.wishList(map);
		
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("paging", paging);
		req.setAttribute("totalProductCnt", total);
	}

	@Override
	public void buyAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int product_id = Integer.parseInt(req.getParameter("product_id"));
		int price = Integer.parseInt(req.getParameter("price"));
		
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", client_id);
		map.put("product_id", product_id);
		map.put("price", price);
		
		int insertCnt = dao.buyProduct(map);
		
		req.setAttribute("insertCnt", insertCnt);
	}

	@Override
	public void readProductDetail(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		int product_id = Integer.parseInt(req.getParameter("product_id"));
		
		ProductDTO productDTO = dao.productDetail(product_id);
		List<ReviewDTO> reviewList = dao.reviewList(product_id);
		
		req.setAttribute("productDTO", productDTO);
		req.setAttribute("reviewList", reviewList);
		req.setAttribute("reviewCnt", reviewList.size());
		if (reviewList.size()>0) {
			req.setAttribute("reviewGradeAvg", reviewList.get(0).getAvg_grade());
		}else {
			req.setAttribute("reviewGradeAvg", 0);
		}
	}

	@Override
	public void purchaseConfirm(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int purchase_id = Integer.parseInt(req.getParameter("purchase_id"));
		
		int updateCnt = dao.purchaseConfirm(purchase_id);
		
		req.setAttribute("updateCnt", updateCnt);
	}

	@Override
	public void purchaseCancel(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int purchase_id = Integer.parseInt(req.getParameter("purchase_id"));
		
		int updateCnt = dao.purchaseCancel(purchase_id);
		
		req.setAttribute("updateCnt", updateCnt);
	}

	@Override
	public void wishAdd(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int product_id = Integer.parseInt(req.getParameter("product_id"));
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", client_id);
		map.put("product_id", product_id);
		System.out.println(map);
		int insertCnt = dao.insertWishList(map);
		
		req.setAttribute("insertCnt", insertCnt);
		
	}

	@Override
	public void wishCancel(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int product_id = Integer.parseInt(req.getParameter("product_id"));
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", client_id);
		map.put("product_id", product_id);
		
		int deleteCnt = dao.deleteWishList(map);
		
		req.setAttribute("deleteCnt", deleteCnt);
	}

	@Override
	public void buyCheckAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int product_id = Integer.parseInt(req.getParameter("product_id"));
		int price = Integer.parseInt(req.getParameter("price"));
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int client_id = dao.getClientId(SessionId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", client_id);
		map.put("product_id", product_id);
		
		boolean existed = false;
		int selectCnt = dao.buyCheck(map);
		if(selectCnt != 0) existed = true;
		
		req.setAttribute("existed", existed);
		req.setAttribute("product_id", product_id);
		req.setAttribute("price", price);
	}
	
}
