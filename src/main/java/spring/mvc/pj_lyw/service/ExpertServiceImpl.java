package spring.mvc.pj_lyw.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.pj_lyw.dao.ExpertDAO;
import spring.mvc.pj_lyw.dto.ChartDTO;
import spring.mvc.pj_lyw.dto.ProductDTO;
import spring.mvc.pj_lyw.page.Paging;

@Service
public class ExpertServiceImpl implements ExpertService{
	@Inject
	ExpertDAO dao;
	
	@Override
	public void readProductList(HttpServletRequest req, Model model) throws ServletException, IOException {
		String pageNum = req.getParameter("pageNum");
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int confirmcnt = 0;
		int cancelcnt = 0;
		int buycnt = 0;
		int totalPrice = 0;
		
		//페이징 처리
		Paging paging = new Paging(pageNum);
		paging.setPageSize(5);
		int total = dao.getProductCnt(SessionId);
		paging.setTotalCount(total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("expertId", SessionId);
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());
		
		List<ProductDTO> dtoList = dao.productList(map);
		
		for(ProductDTO dto : dtoList) {
			confirmcnt += dto.getConfirmcnt();
			cancelcnt += dto.getCancelcnt();
			buycnt += dto.getBuycnt();
			totalPrice += dto.getConfirmcnt()*dto.getPrice();
		}
		
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("confirmcnt", confirmcnt);
		req.setAttribute("cancelcnt", cancelcnt);
		req.setAttribute("buycnt", buycnt);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("paging", paging);
	}
	
	@Override
	public void getProductState(HttpServletRequest req, Model model) 
			throws ServletException, IOException {

		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int confirmcnt = 0;
		int cancelcnt = 0;
		int buycnt = 0;
		int totalPrice = 0;
		
		List<ProductDTO> dtoList = dao.totalProductList(SessionId);
		
		for(ProductDTO dto : dtoList) {
			confirmcnt += dto.getConfirmcnt();
			cancelcnt += dto.getCancelcnt();
			buycnt += dto.getBuycnt();
			totalPrice += dto.getConfirmcnt()*dto.getPrice();
		}
		
		int expert_id = dao.getExpertId(SessionId);
		List<ChartDTO> chartDTOList = dao.chartList(expert_id);
		
		System.out.println(chartDTOList);
		
		req.setAttribute("chartDTOList", chartDTOList);
		req.setAttribute("confirmcnt", confirmcnt);
		req.setAttribute("cancelcnt", cancelcnt);
		req.setAttribute("buycnt", buycnt);
		req.setAttribute("totalPrice", totalPrice);
	}

	public void addProduct(MultipartHttpServletRequest req, Model model) 
			throws ServletException, IOException{
		// 추가 Start:JSP ImageUploadHandler.java기능
		MultipartFile file = req.getFile("image");
		System.out.println("file = " + file);
		
		// input 경로
		String saveDir = req.getSession().getServletContext().getRealPath("resources/upload/");
		System.out.println("saveDir = " + saveDir);
		
		// 이미지 추가를 위한 샘플이미지 경로
		String realDir = "C:\\Dev01\\workspace_spring\\spring_pj_lyw\\src\\main\\webapp\\resources\\upload\\";
		System.out.println("realDir = " + realDir);
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			file.transferTo(new File(saveDir + file.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file.getOriginalFilename());
			fos = new FileOutputStream(realDir + file.getOriginalFilename());

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
		
		// 추가 End-------------------------------
		String SessionId = (String)req.getSession().getAttribute("SessionId");
		int expert_id = dao.getExpertId(SessionId);
		ProductDTO dto = new ProductDTO();
		dto.setExpert_id(expert_id);
		dto.setName(req.getParameter("name"));
		dto.setImage(file.getOriginalFilename());
		dto.setCategory(req.getParameter("category"));
		dto.setExplanation(req.getParameter("explanation"));
		dto.setDescription(req.getParameter("description"));
		dto.setPrice(Integer.parseInt(req.getParameter("price")));
		
		System.out.println("addProduct dto=" + dto);
		
		int insertCnt = dao.insertProduct(dto);
		
		req.setAttribute("insertCnt", insertCnt);
	}

	@Override
	public void readProduct(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int product_id = Integer.parseInt(req.getParameter("product_id"));
		
		ProductDTO dto = dao.getProduct(product_id);
		
		req.setAttribute("dto", dto);
	}

	@Override
	public void updateProduct(MultipartHttpServletRequest req, Model model) 
			throws ServletException, IOException {
		
		// 추가 Start:JSP ImageUploadHandler.java기능
		MultipartFile file = req.getFile("image");
		System.out.println("file = " + file);
		if(file != null) {
			// input 경로
			String saveDir = req.getSession().getServletContext().getRealPath("resources/upload/");
			System.out.println("saveDir = " + saveDir);
			
			// 이미지 추가를 위한 샘플이미지 경로
			String realDir = "C:\\Dev01\\workspace_spring\\spring_pj_01\\src\\main\\webapp\\resources\\upload\\";
			System.out.println("realDir = " + realDir);
			
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				file.transferTo(new File(saveDir + file.getOriginalFilename()));
				fis = new FileInputStream(saveDir + file.getOriginalFilename());
				fos = new FileOutputStream(realDir + file.getOriginalFilename());

				int data = 0;
				while ((data = fis.read()) != -1) {
					fos.write(data);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			}
		}
		
		ProductDTO dto = new ProductDTO();
		dto.setProduct_id(Integer.parseInt(req.getParameter("product_id")));
		dto.setName(req.getParameter("name"));
		if(file == null) {
			dto.setImage(req.getParameter("hiddenimage"));
			System.out.println("hiddenimage = " + req.getParameter("hiddenimage"));
		}
		else {
			dto.setImage(file.getOriginalFilename());
			System.out.println("fileName = " + file.getOriginalFilename());
		}
		dto.setCategory(req.getParameter("category"));
		dto.setExplanation(req.getParameter("explanation"));
		dto.setDescription(req.getParameter("description"));
		dto.setPrice(Integer.parseInt(req.getParameter("price")));
		
		System.out.println("update dto=" + dto);
		
		int updateCnt = dao.updateProduct(dto);
		
		req.setAttribute("updateCnt", updateCnt);
	}

	@Override
	public void deleteProduct(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		int product_id = Integer.parseInt(req.getParameter("product_id"));
		
		int deleteCnt = dao.deleteProduct(product_id);
		
		req.setAttribute("deleteCnt", deleteCnt);
	}
}
