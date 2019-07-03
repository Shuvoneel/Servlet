/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;

/**
 *
 * @author hp
 */
public class Item {
    private Product p;
    private int quantit;

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQuantit() {
        return quantit;
    }

    public void setQuantit(int quantit) {
        this.quantit = quantit;
    }
    
}
