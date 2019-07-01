package com.dawntechbd.service;

import com.dawntechbd.entity.Product;
import java.util.List;

public interface ProductService {

    void save(Product product);

    void update(Product product);

    void delete(Product product);

    List<Product> getProducts();
}
