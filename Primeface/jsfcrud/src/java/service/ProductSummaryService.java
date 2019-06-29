package service;

import common.CommonService;
import dao.ProductSummaryDao;
import entity.ProductSummary;

public class ProductSummaryService extends CommonService<ProductSummary> implements ProductSummaryDao {

    @Override
    public ProductSummary findProductSummaryByProductCode(String productCode) throws Exception {
        return ((ProductSummary) getSession().createQuery("SELECT t from ProductSummary t where productCode='" + productCode + "'").getSingleResult());
    }
}
