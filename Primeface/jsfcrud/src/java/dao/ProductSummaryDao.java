package dao;

import common.CommonDao;
import entity.ProductSummary;

public interface ProductSummaryDao extends CommonDao<ProductSummary> {

    public ProductSummary findProductSummaryByProductCode(String productCode) throws Exception;
}
