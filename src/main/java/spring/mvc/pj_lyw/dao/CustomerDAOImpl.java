package spring.mvc.pj_lyw.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.mvc.pj_lyw.dto.ProductDTO;
import spring.mvc.pj_lyw.dto.PurchaseDTO;
import spring.mvc.pj_lyw.dto.ReviewDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> productList(Map<String, Object> map) {
		System.out.println("productList");
		return sqlSession.getMapper(CustomerDAO.class).productList(map);
	}

	@Override
	public List<ProductDTO> productListCategory(Map<String, Object> map) {
		return sqlSession.getMapper(CustomerDAO.class).productListCategory(map);
	}

	@Override
	public List<ProductDTO> productListSerch(Map<String, Object> map) {
		return sqlSession.getMapper(CustomerDAO.class).productListSerch(map);
	}

	@Override
	public List<PurchaseDTO> purchaseList(Map<String, Object> map) {
		return sqlSession.getMapper(CustomerDAO.class).purchaseList(map);
	}

	@Override
	public List<PurchaseDTO> totalPurchaseList(int client_id) {
		return sqlSession.getMapper(CustomerDAO.class).totalPurchaseList(client_id);
	}

	@Override
	public int getPurchaseCnt(int client_id) {
		return sqlSession.getMapper(CustomerDAO.class).getPurchaseCnt(client_id);
	}

	@Override
	public List<ProductDTO> wishList(Map<String, Object> map) {
		return sqlSession.getMapper(CustomerDAO.class).wishList(map);
	}

	@Override
	public int wishListCnt(int client_id) {
		return sqlSession.getMapper(CustomerDAO.class).wishListCnt(client_id);
	}

	@Override
	public int buyProduct(Map<String, Object> map) {
		return sqlSession.getMapper(CustomerDAO.class).buyProduct(map);
	}

	@Override
	public int buyCheck(Map<String, Object> map) {
		return sqlSession.getMapper(CustomerDAO.class).buyCheck(map);
	}

	@Override
	public int productCnt() {
		return sqlSession.getMapper(CustomerDAO.class).productCnt();
	}

	@Override
	public int productCategoryCnt(String category) {
		return sqlSession.getMapper(CustomerDAO.class).productCategoryCnt(category);
	}

	@Override
	public int productSerchCnt(String target) {
		return sqlSession.getMapper(CustomerDAO.class).productSerchCnt(target);
	}

	@Override
	public ProductDTO productDetail(int num) {
		return sqlSession.getMapper(CustomerDAO.class).productDetail(num);
	}

	@Override
	public List<ReviewDTO> reviewList(int product_id) {
		return sqlSession.getMapper(CustomerDAO.class).reviewList(product_id);
	}

	@Override
	public int getClientId(String SessionId) {
		int cilent_id = 0;
		try {
			cilent_id = sqlSession.getMapper(CustomerDAO.class).getClientId(SessionId);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return cilent_id;
	}

	@Override
	public int purchaseConfirm(int purchase_id) {
		return sqlSession.getMapper(CustomerDAO.class).purchaseConfirm(purchase_id);
	}

	@Override
	public int purchaseCancel(int purchase_id) {
		return sqlSession.getMapper(CustomerDAO.class).purchaseCancel(purchase_id);
	}

	@Override
	public int insertWishList(Map<String, Object> map) {
		return sqlSession.getMapper(CustomerDAO.class).insertWishList(map);
	}

	@Override
	public int deleteWishList(Map<String, Object> map) {
		return sqlSession.getMapper(CustomerDAO.class).deleteWishList(map);
	}

	@Override
	public ReviewDTO getReview(int purchase_id) {
		return sqlSession.getMapper(CustomerDAO.class).getReview(purchase_id);
	}

	@Override
	public int existReview(int purchase_id) {
		return sqlSession.getMapper(CustomerDAO.class).existReview(purchase_id);
	}

	@Override
	public int insertReview(ReviewDTO dto) {
		return sqlSession.getMapper(CustomerDAO.class).insertReview(dto);
	}

	@Override
	public int updateReview(ReviewDTO dto) {
		return sqlSession.getMapper(CustomerDAO.class).updateReview(dto);
	}
	
}
