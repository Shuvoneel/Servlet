package com.dawntechbd.controller;

import com.dawntechbd.entity.Summary;
import com.dawntechbd.implementation.SummaryImpl;
import com.dawntechbd.service.SummaryService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SummaryController {

    private Summary summary;
    private List<Summary> summaries;
    private SummaryService service;

    public List<Summary> getSummaries() {
        summaries = new ArrayList<>();
        service = new SummaryImpl();
        summaries = service.getSummary();
        return summaries;
    }

    public void setSummaries(List<Summary> summaries) {
        this.summaries = summaries;
    }

    public void save() {
        service = new SummaryImpl();
        service.save(summary);
    }

    public Summary getSummary() {
        if (summary == null) {
            summary = new Summary();
        }
        return summary;
    }

    public void setSummary(Summary summary) {

        this.summary = summary;
    }

}
