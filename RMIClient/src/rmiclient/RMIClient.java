/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMIClient {

    
    public static void main(String[] args) throws RemoteException {
        
        Registry r = LocateRegistry.getRegistry(1099);
    }
    
}
