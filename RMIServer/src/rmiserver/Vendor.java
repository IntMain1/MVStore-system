/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;
import rmiserver.Database_manager.DB_manager;


public class Vendor extends User implements Serializable{
    
    Store store;
    int commission;
    boolean withdraw;
    String application;
    boolean applicationStatus;
    String promocode;
    DB_manager db =new DB_manager();

    public Vendor(Store store, int commission, boolean withdraw, String application, boolean applicationStatus, String promocode, int ID, String name, int age, int password, String email) {
        super(ID, name, age, password, email);
        this.store = store;
        this.commission = commission;
        this.withdraw = withdraw;
        this.application = application;
        this.applicationStatus = applicationStatus;
        this.promocode = promocode;
    }

    public boolean isApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(boolean applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public DB_manager getDb() {
        return db;
    }

    public void setDb(DB_manager db) {
        this.db = db;
    }

    

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    

    public boolean isWithdraw() {
        return withdraw;
    }

    public void setWithdraw(boolean withdraw) {
        this.withdraw = withdraw;
    }

    
    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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
    
    public void createStore(int ID,String name,String location,String type){
        
        Store s = new Store(1, "H&M", "", "clothes") {
            @Override
            public void open() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void close() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        db.addStore(s);
    }
    public void manageProducts(Product p){
        db.insertProduct(p);
        db.updateProduct(p);
        db.cancelProduct(name);
    
    }
    
    public void trackOrder(int ID){
         db.viewOrder(ID);
    
    }
    public void prepareOrder(Order o){
        db.addOrder(o);
    
    }
    
    public void createPromoCode(){
    
    System.out.print("Promocode is  " +promocode );
    
    }
    
    public void manageOrder(Order o){
    
    db.addOrder(o);
    db.updateOrder(o);
    db.deleteOrder(ID);
    }
    
    public void ViewFeedback(Feedback f){
    
        db.viewFeedback(f.getFeedbackID());
    
    }
    
    

    
}
