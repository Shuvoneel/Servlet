package dao;

import common.CommonDao;
import entity.ProductPurchase;
import java.util.List;

public interface ProductPurchaseDao extends CommonDao<ProductPurchase> {

    public List<ProductPurchase> findAllProductPurchaseCategory(int id) throws Exception;
}
