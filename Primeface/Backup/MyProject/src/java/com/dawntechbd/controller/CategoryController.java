package com.dawntechbd.controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.dawntechbd.entity.Category;
import com.dawntechbd.service.CategoryService;

@ManagedBean
public class CategoryController {

    final static Logger logger = Logger.getLogger(CategoryController.class);

    private CategoryService categoryService;
    private Category category;

    private List<Category> categories;

    public String save() {
        try {

            categoryService = new CategoryService();
            categoryService.persist(category);

            notificationSuccess("Persist Success!");
            category = null;

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

    public Category getCategory() {
        if (category == null) {
            category = new Category();
        }
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategories() {
        try {

            categoryService = new CategoryService();
            categories = categoryService.findAll();

        } catch (Exception e) {
            notificationError(e, "Persist Error!");
            logger.debug("This is debug :" + e);
            logger.error("This is error : " + e);
            logger.fatal("This is fatal : " + e);
        }
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
