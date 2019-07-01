package com.dawntechbd.service;

import com.dawntechbd.common.CommonService;
import com.dawntechbd.dao.SummaryDao;
import com.dawntechbd.entity.Summary;

public class SummaryService extends CommonService<Summary> implements SummaryDao {

    @Override
    public Summary findSummaryByProductCode(String productCode) throws Exception {
        return ((Summary) getSession().createQuery("SELECT t from Summary t where productCode='" + productCode + "'").getSingleResult());
    }
}
