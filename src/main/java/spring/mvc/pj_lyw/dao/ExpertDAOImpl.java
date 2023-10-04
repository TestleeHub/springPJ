package spring.mvc.pj_lyw.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.mvc.pj_lyw.dto.ChartDTO;
import spring.mvc.pj_lyw.dto.ProductDTO;

@Repository
public class ExpertDAOImpl implements ExpertDAO{
	@Inject
	SqlSession sqlSession;

	@Override
	public List<ProductDTO> productList(Map<String, Object> map) {
		return sqlSession.getMapper(ExpertDAO.class).productList(map);
	}

	@Override
	public List<ProductDTO> totalProductList(String expertId) {
		return sqlSession.getMapper(ExpertDAO.class).totalProductList(expertId);
	}

	@Override
	public int getProductCnt(String expertId) {
		return sqlSession.getMapper(ExpertDAO.class).getProductCnt(expertId);
	}

	@Override
	public int getExpertId(String expertId) {
		if(expertId == null) return 0;
		return sqlSession.getMapper(ExpertDAO.class).getExpertId(expertId);
	}

	@Override
	public int insertProduct(ProductDTO dto) {
		return sqlSession.getMapper(ExpertDAO.class).insertProduct(dto);
	}

	@Override
	public ProductDTO getProduct(int product_id) {
		return sqlSession.getMapper(ExpertDAO.class).getProduct(product_id);
	}

	@Override
	public int updateProduct(ProductDTO dto) {
		return sqlSession.getMapper(ExpertDAO.class).updateProduct(dto);
	}

	@Override
	public int deleteProduct(int product_id) {
		return sqlSession.getMapper(ExpertDAO.class).deleteProduct(product_id);
	}

	@Override
	public List<ChartDTO> chartList(int expertId) {
		return sqlSession.getMapper(ExpertDAO.class).chartList(expertId);
	}
	
}
