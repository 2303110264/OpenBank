package kopo.aisw.hc.product.dao;

import kopo.aisw.hc.product.vo.ProductVO;
import java.util.List;

public interface ProductDAO {
	
    public void insertProduct(ProductVO product) throws Exception;
    public ProductVO selectProduct(int productNum) throws Exception;
    public List<ProductVO> selectAllProducts() throws Exception;
    public void updateProduct(ProductVO product) throws Exception;
    public void deleteProduct(int productNum) throws Exception;
    
}