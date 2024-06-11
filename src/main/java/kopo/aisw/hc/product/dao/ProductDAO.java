package kopo.aisw.hc.product.dao;

import kopo.aisw.hc.product.vo.ProductVO;
import java.util.List;
import java.util.Map;

public interface ProductDAO {
    public void insertProduct(ProductVO product) throws Exception;
    public ProductVO selectProduct(int productNum) throws Exception;
    public List<ProductVO> selectAllProducts() throws Exception;
    public void updateProduct(ProductVO product) throws Exception;
    public void deleteProduct(int productNum) throws Exception;
    public List<Map<String, Object>> getProductStatistics() throws Exception;
    public List<Map<String, Object>> getUserTrends() throws Exception;
}
