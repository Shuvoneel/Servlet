package com.dawntechbd.dao;

import com.dawntechbd.common.CommonDao;
import com.dawntechbd.entity.Summary;

public interface SummaryDao extends CommonDao<Summary> {

    public Summary findSummaryByProductCode(String productCode) throws Exception;
}
