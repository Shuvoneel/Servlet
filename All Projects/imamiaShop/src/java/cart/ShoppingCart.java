/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped
public class ShoppingCart {
    private List<Item> cart = new ArrayList<>();
    private double total;
    int cartsize;
    String item = "item";

    public List<Item> getCart() {
        if (cartsize>1) {
            item = "items";
        }
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        total = 0.0;
        for (Item item : cart) {
            total = total+(item.getQuantit()*item.getP().getProPrice());
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCartsize() {
        cartsize = cart.size();
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public String addtoCart(Product p){
        if (cart.size()>0) {
            for (Item item : cart) {
                if (item.getP().getProId().equals(p.getProId())) {
                    item.setQuantit(item.getQuantit()+1);
                    return "cart";
                }
            }
        }
        Item i = new Item();
        i.setQuantit(1);
        i.setP(p);
        cart.add(i);
        return "cart";
    }
    public void updateCart(){
    
    }
    public void removeCart(Item i){
        for (Item item : cart) {
            if (item.equals(i)) {
                cart.remove(i);
                break;
            }
        }
    }
}
