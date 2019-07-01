package com.dawntechbd.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.dawntechbd.entity.Summary;
import com.dawntechbd.service.SummaryService;

@ManagedBean
public class SummaryController {

    final static Logger logger = Logger.getLogger(SummaryController.class);

    private SummaryService summaryService;
    private Summary summary;

    private List<Summary> summaries;

    public String save() {
        try {

            summaryService = new SummaryService();
            summaryService.persist(summary);

            notificationSuccess("Persist Success!");
            summary = null;

        } catch (Exception e) {
            notificationError(e, "Persist Error!");
            logger.debug("This is debug :" + e);
            logger.error("This is error : " + e);
            logger.fatal("This is fatal : " + e);
        }
        return null;

    }

    public void notificationSuccess(String operation) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void notificationError(Exception e, String operation) {
        Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public List<Summary> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<Summary> summaries) {
        this.summaries = summaries;
    }

}
