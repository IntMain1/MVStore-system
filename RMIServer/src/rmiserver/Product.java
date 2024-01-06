/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;


public class Product implements Serializable{
    
      String name;
      int price;
      Vendor vendor;
      int quantity;
      String type;

    public Product(String name, int price, Vendor vendor, int quantity, String type) {
        this.name = name;
        this.price = price;
        this.vendor = vendor;
        this.quantity = quantity;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
      

   
      
      

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
      
      
}
