package com.dawntechbd.controller;

import com.dawntechbd.entity.Product;
import com.dawntechbd.implementation.ProductImpl;
import com.dawntechbd.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProductController {

    private Product product;
    private List<Product> products;
    private ProductService service;

    public List<Product> getProductsList() {
        products = new ArrayList<>();
        service = new ProductImpl();
        products = service.getProducts();
        return products;
    }

    public void setProductsList(List<Product> productsList) {
        this.products = productsList;
    }

    public void save() {
        service = new ProductImpl();
        service.save(product);
    }

    public void update() {
        service = new ProductImpl();
        service.update(product);
    }

    public void delete() {
        service = new ProductImpl();
        service.delete(product);
    }

    public Product getProduct() {
        if (product == null) {
            product = new Product();
        }
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
