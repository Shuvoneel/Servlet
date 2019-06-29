package service;

import common.CommonService;
import dao.ProductPurchaseDao;
import entity.ProductPurchase;
import java.util.List;

public class ProductPurchaseService extends CommonService<ProductPurchase> implements ProductPurchaseDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ProductPurchase> findAllProductPurchaseCategory(int id) throws Exception {
        return ((List<ProductPurchase>) getSession().createQuery("SELECT t from ProductPurchase t where productCategory.id='" + id + "'").getResultList());
    }
}
