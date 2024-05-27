package kopo.aisw.hc.product.service;

import kopo.aisw.hc.product.dao.ProductDAO;
import kopo.aisw.hc.product.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO pDao;

    @Override
    public void insertProduct(ProductVO product) throws Exception {
        pDao.insertProduct(product);
    }

    @Override
    public ProductVO selectProduct(int productNum) throws Exception {
        return pDao.selectProduct(productNum);
    }

    @Override
    public List<ProductVO> selectAllProducts() throws Exception {
        return pDao.selectAllProducts();
    }

    @Override
    public void updateProduct(ProductVO product) throws Exception {
        pDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productNum) throws Exception {
        pDao.deleteProduct(productNum);
    }
}
