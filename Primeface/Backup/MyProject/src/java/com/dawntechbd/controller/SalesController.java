package com.dawntechbd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.dawntechbd.entity.Category;
import com.dawntechbd.entity.Purchase;
import com.dawntechbd.entity.Sales;
import com.dawntechbd.entity.Summary;
import com.dawntechbd.service.PurchaseService;
import com.dawntechbd.service.SalesService;
import com.dawntechbd.service.SummaryService;

@SessionScoped
@ManagedBean(name = "SalesController")
public class SalesController {

    final static Logger logger = Logger.getLogger(SalesController.class);
    private SummaryService summaryService;
    private Summary summary;
    private List<Summary> summaries;

    private Category category;

    private PurchaseService purchaseService;
    private Purchase purchase;
    private List<Purchase> purchases;

    private SalesService salesService;
    private Sales sales;

    private List<Sales> saleses;

    public void loadProductListByCategory() {
        try {
            if (category.getId() != 0) {
                purchases = new ArrayList<Purchase>();
            }
            purchaseService = new PurchaseService();
            purchases = purchaseService.findAllPurchaseCategory(category.getId());

        } catch (Exception ex) {
            notificationError(ex, "Persist Error!");
            logger.debug("This is debug :" + ex);
            logger.error("This is error : " + ex);
            logger.fatal("This is fatal : " + ex);
        }
    }

    public String save() {
        try {
            if (purchase.getId() != 0) {

                salesService = new SalesService();
                sales.setPurchase(purchase);
                sales.setSalesDate(new Date());
                salesService.persist(sales);
                purchaseService = new PurchaseService();
                Purchase pp = purchaseService.findById(purchase.getId());
                summaryService = new SummaryService();
                Summary ps = (Summary) summaryService.findSummaryByProductCode(pp.getProductCode());

                summary = new Summary();
                summary.setProductName(ps.getProductName());
                summary.setProductCode(ps.getProductCode());
                summary.setPurchaseQty(ps.getPurchaseQty());
                summary.setAvilableQty(ps.getAvilableQty() - sales.getQty());
                summary.setSoldQty(ps.getSoldQty() + sales.getQty());
                summary.setId(ps.getId());
                summaryService.merge(summary);
                notificationSuccess("Persist Success!");
                sales = null;
                summary = null;
            }
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

    public Sales getSales() {
        if (sales == null) {
            sales = new Sales();
        }
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public List<Sales> getSaleses() {
        try {

            salesService = new SalesService();
            saleses = salesService.findAll();

        } catch (Exception e) {
            notificationError(e, "Persist Error!");
            logger.debug("This is debug :" + e);
            logger.error("This is error : " + e);
            logger.fatal("This is fatal : " + e);
        }
        return saleses;
    }

    public void setSaleses(List<Sales> saleses) {
        this.saleses = saleses;
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
        try {
            summaryService = new SummaryService();
            summaryService.findAll();
        } catch (Exception e) {
            logger.debug("This is debug :" + e);
            logger.error("This is error : " + e);
            logger.fatal("This is fatal : " + e);
        }
        return summaries;
    }

    public void setSummaries(List<Summary> summaries) {
        this.summaries = summaries;
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
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
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

}
