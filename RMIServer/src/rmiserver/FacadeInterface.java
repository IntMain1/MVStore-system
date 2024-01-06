/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.RemoteException;


public interface FacadeInterface {
     public void SetStoreData(int ID,  String name, String location, String type)throws RemoteException;
     public String GetStoreData() throws RemoteException;
}
