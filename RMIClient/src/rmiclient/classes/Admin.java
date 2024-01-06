/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient.classes;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Admin implements Serializable{
      int adminID;
    String name;
    String privilage;
    String email;
    private static Admin admin;


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
    
    
    
}
