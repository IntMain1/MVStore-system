/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiserver.Database_manager.DB_manager;


public class RMIServer {


    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry r = LocateRegistry.createRegistry(1099);
        DB_manager db=new DB_manager();
        
        Admin a=new Admin(1,"Ahmed"," ","Ahmed@yahoo.com");
        db.insertAdmin(a);
        db.updateAdmin(a);
        db.deleteAdmin("Mohammed");
      System.out.println("The server is ready");
    }
    
}
