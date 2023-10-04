package spring.mvc.pj_lyw.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.pj_lyw.dto.ProductDTO;
import spring.mvc.pj_lyw.dto.PurchaseDTO;
import spring.mvc.pj_lyw.dto.ReviewDTO;

public interface CustomerDAO {
	// 고객 - 상품 목록
	public List<ProductDTO> productList(Map<String, Object> map);
	// 고객 - 카테고리 상품 목록
	public List<ProductDTO> productListCategory(Map<String, Object> map);
	// 고객 - 검색 상품 목록
	public List<ProductDTO> productListSerch(Map<String, Object> map);
	// 고객 - 구매 목록
	public List<PurchaseDTO> purchaseList(Map<String, Object> map);
	// 고객 - 전체 상품 목록
	public List<PurchaseDTO> totalPurchaseList(int client_id);
	// 고객 - 구매 총 갯수
	public int getPurchaseCnt(int client_id);
	// 고객 - 찜 목록
	public List<ProductDTO> wishList(Map<String, Object> map);
	// 고객 - 찜 총 갯수
	public int wishListCnt(int client_id);
	// 고객 - 구매 액션
	public int buyProduct(Map<String, Object> map);
	// 고객 - 이전 구매 여부 체크
	public int buyCheck(Map<String, Object> map);
	// 고객 - 총 상품 갯수 조회
	public int productCnt();
	// 고객 - 카테고리 상품 갯수 조회
	public int productCategoryCnt(String category);
	// 고객 - 검색 상품 갯수 조회
	public int productSerchCnt(String target);
	// 고객 - 제품 상세 페이지 조회
	public ProductDTO productDetail(int num);
	// 고객 - 리뷰 리스트
	public List<ReviewDTO> reviewList(int product_id);
	// 고객 - 세션 아이디를 통한 고객번호 조회
	public int getClientId(String SessionId);
	// 고객 - 구매 확정
	public int purchaseConfirm(int purchase_id);
	// 고객 - 구매 취소
	public int purchaseCancel(int purchase_id);
	// 고객 - 찜 목록 추가
	public int insertWishList(Map<String, Object> map);
	// 고객 - 찜 목록 삭제
	public int deleteWishList(Map<String, Object> map);
	// 고객 - 리뷰 요청
	public ReviewDTO getReview(int purchase_id);
	// 고객 - 리뷰 존재 여부
	public int existReview(int purchase_id);
	// 고객 - 리뷰 등록
	public int insertReview(ReviewDTO dto);
	// 고객 - 리뷰 업데이트
	public int updateReview(ReviewDTO dto);
}
