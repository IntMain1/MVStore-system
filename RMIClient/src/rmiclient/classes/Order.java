/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient.classes;

import java.io.Serializable;


public class Order implements Serializable{
    
    Product product;
    int quantity;
    Shopper shopper;
    Driver driver;
    Vendor vendor;

    public Order(Product product, int quantity, Shopper shopper, Driver driver, Vendor vendor) {
        this.product = product;
        this.quantity = quantity;
        this.shopper = shopper;
        this.driver = driver;
        this.vendor = vendor;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    
    
}
