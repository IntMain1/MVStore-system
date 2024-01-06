/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Order implements Serializable,OrderI{
    
    int ID;
    Product product;
    int quantity;
    Shopper shopper;
    Driver driver;
    Vendor vendor;
    Date date;
    String status;
    private ArrayList<SObserver> observers;

    public Order(int ID, Product product, int quantity, Shopper shopper, Driver driver, Vendor vendor, Date date, String status) {
        this.ID = ID;
        this.product = product;
        this.quantity = quantity;
        this.shopper = shopper;
        this.driver = driver;
        this.vendor = vendor;
        this.date = date;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
    
    @Override
      public void removeNotificationObserver(SObserver PO) {
        observers.remove(PO);
    }

    @Override
    public void addNotificationObserver(SObserver PO) {
        observers.add(PO);
    }

    @Override
    public void NotifyAll(String news){
        observers.notifyAll();
        for (int i = 0; i < observers.size(); i++) {
            try {
                observers.get(i).Notify(news);
            } catch (RemoteException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
