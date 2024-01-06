/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rmiserver.Database_manager.DB_manager;


public class Shopper extends User implements Serializable,SObserver{
    
    int creditCardNum;
    String creditCardStatus;
    String shippingAdress;
    Order order;
    Vendor v;
    int balance;
    Bank b;
    private searchStrategy str;
     DB_manager db =new DB_manager();
     private ArrayList<Product> products;

    public Shopper(int creditCardNum, String creditCardStatus, String shippingAdress, Order order, Vendor v, int balance, ArrayList<Product> products, int ID, String name, int age, int password, String email) {
        super(ID, name, age, password, email);
        this.creditCardNum = creditCardNum;
        this.creditCardStatus = creditCardStatus;
        this.shippingAdress = shippingAdress;
        this.order = order;
        this.v = v;
        this.balance = balance;
        this.products = products;
    }

    public Vendor getV() {
        return v;
    }

    public void setV(Vendor v) {
        this.v = v;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public DB_manager getDb() {
        return db;
    }

    public void setDb(DB_manager db) {
        this.db = db;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    

    public int getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(int creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getCreditCardStatus() {
        return creditCardStatus;
    }

    public void setCreditCardStatus(String creditCardStatus) {
        this.creditCardStatus = creditCardStatus;
    }

    public String getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   
    public void searchProduct(String text,int num){
        
        if(num == 1) str = new searchByName();
        else str = new searchByType();
        
    }
    
    
     
    
    public void searchVendor(String name){
    
        if(name==v.getName()){
            db.viewVendor(name);
        }
        else{
        System.out.println("Vensor doesn't exist.");
        }
    
    }
    
    public void viewVendor(String name){
        db.viewVendor(name);
    }
    
    public void writeFeedback(Feedback f){
        db.insertFeedback(f);
    }
    
    
    public void buyProduct(int ID,Product p){
        
        if(balance>p.getPrice()){
            b.confirmPayment(this, ID);
            products.add(p);
            System.out.print("Product has been purchased ");
        }
        
        
    }
    
    public void orderProduct(Order o){
    
        db.addOrder(o);
    }
    
    public void trackOrder(int ID){
    
        db.viewOrder(ID);
    
    }
    
    public void cancelOrder(int ID){
        db.cancelOrder(ID); 
    }
    
     public void giveFeedback(Feedback f){
         db.insertFeedback(f);
     }
     
     @Override
    public void Notify(String news) throws RemoteException {
        System.out.print("You have one update !!  " + news);
    }
    
}
