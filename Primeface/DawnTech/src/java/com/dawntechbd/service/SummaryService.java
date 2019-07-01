package com.dawntechbd.service;

import com.dawntechbd.entity.Summary;
import java.util.List;

public interface SummaryService {

    void save(Summary summary);

    void update(Summary summary);

    List<Summary> getSummary();
}
