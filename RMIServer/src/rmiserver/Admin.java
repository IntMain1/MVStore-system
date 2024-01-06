/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmiserver.Database_manager.DB_manager;


public class Admin implements Serializable {
    int adminID;
    String name;
    String privilage;
    String email;
    private static Admin admin;
    DB_manager db =new DB_manager();

    public Admin(int adminID, String name, String privilage, String email, Admin admin) {
        this.adminID = adminID;
        this.name = name;
        this.privilage = privilage;
        this.email = email;
        this.admin = admin;
    }

    public Admin() throws RemoteException{
        UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    public Admin(int adminID, String name, String privilage, String email) {
        this.adminID = adminID;
        this.name = name;
        this.privilage = privilage;
        this.email = email;
    }

    
    
    
    

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivilage() {
        return privilage;
    }

    public void setPrivilage(String privilage) {
        this.privilage = privilage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    public static Admin getInstance() throws RemoteException {
        if (admin == null) {
            //synchronized block to remove overhead 
            synchronized (Admin.class) {
                if (admin == null) {
                    // if instance is null, initialize 
                    admin = new Admin();
                }
            }
        }
        return admin;
    }
    
     public void manageDriver(Driver d){
         
        db.insertDriver(d); //adds new driver
        db.deleteDriver(1); 
        db.updateDriver(d);
     }
     
     public void manageVendor(Vendor v){
     
         db.insertVendor(v);
         db.deleteVendor(12);
         db.updateVendor(v);
     }
     
     public void manageProduct(Product t){
         db.insertProduct(t); 
         db.updateProduct(t);
         db.cancelProduct(name);
     }
     
     public void setCommission(int commission, Vendor v){
         v.setCommission(commission);
     }
     
    public boolean enableWithdraw(Vendor v){
        if(v.isWithdraw()){
        return true;}
        else { return false;}
    
    }
    
    public boolean approveVendorApplication(Vendor v){
    
    db.viewApplication(v.getApplication());
    if(v.applicationStatus){
        return true;
    }
    else { return false;}
    
    }
    
    
    


    
    
    
}
