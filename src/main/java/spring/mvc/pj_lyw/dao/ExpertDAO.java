package spring.mvc.pj_lyw.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.pj_lyw.dto.ChartDTO;
import spring.mvc.pj_lyw.dto.ProductDTO;

public interface ExpertDAO {
	// 전문가 - 상품 목록 조회
	public List<ProductDTO> productList(Map<String, Object> map);
	// 전문가 - 전체 상품 목록 조회
	public List<ProductDTO> totalProductList(String expertId);
	// 전문가 - 전체 상품 갯수
	public int getProductCnt(String expertId);
	// 전문가 - 세션 아이디를 통한 전문가 번호 조회
	public int getExpertId(String expertId);
	// 전문가 - 상품 등록
	public int insertProduct(ProductDTO dto);
	// 전문가 - 상품 디테일 조회
	public ProductDTO getProduct(int product_id);
	// 전문가 - 상품 업데이트
	public int updateProduct(ProductDTO dto);
	// 전문가 - 상품 삭제
	public int deleteProduct(int product_id);
	// 전문가 - 차트 정보 조회
	public List<ChartDTO> chartList(int expertId);
	
}
