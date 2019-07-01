package com.dawntechbd.controller;

import java.util.List;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.dawntechbd.entity.Category;
import com.dawntechbd.entity.Purchase;
import com.dawntechbd.entity.Summary;
import com.dawntechbd.service.PurchaseService;
import com.dawntechbd.service.SummaryService;

@ManagedBean(name = "purchaseController")
@SessionScoped
public class PurchaseController {

    final static Logger logger = Logger.getLogger(PurchaseController.class);
    private SummaryService summaryService;
    private Summary summary;

    private Category category;
    private PurchaseService purchaseService;
    private Purchase purchase;

    private List<Purchase> purchases;

    public String save() {
        summaryService = new SummaryService();
        try {
            purchaseService = new PurchaseService();
            purchase.setCategory(category);
            purchase.setPurchaseDate(new Date());

            summary = new Summary();
            summary.setProductName(purchase.getProductName());
            summary.setProductCode(purchase.getProductCode());
            summary.setPurchaseQty(purchase.getQty());
            summary.setAvilableQty(purchase.getQty());

            Summary ps = (Summary) summaryService.findSummaryByProductCode(purchase.getProductCode());
            if (ps != null) {
                summary.setId(ps.getId());
                summary.setPurchaseQty(ps.getPurchaseQty() + purchase.getQty());
                summary.setAvilableQty(ps.getAvilableQty() + purchase.getQty());
                purchaseService.persist(purchase);
                summaryService.merge(summary);
                notificationSuccess("Persist Success!");
                summary = null;
                purchase = null;
            }

            //productPurchase = null;
        } catch (Exception e) {
            try {
                purchaseService.persist(purchase);
                summaryService.persist(summary);
                notificationSuccess("Persist Success!");
                summary = null;
                purchase = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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

    public Purchase getPurchase() {
        if (purchase == null) {
            purchase = new Purchase();
        }
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public List<Purchase> getPurchases() {
        try {
            purchaseService = new PurchaseService();
            purchases = purchaseService.findAll();
        } catch (Exception e) {
            notificationError(e, "Persist Error!");
            logger.debug("This is debug :" + e);
            logger.error("This is error : " + e);
            logger.fatal("This is fatal : " + e);
        }
        return purchases;
    }

    public void setProductPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Category getCategory() {
        if (category == null) {
            category = new Category();
        }
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
