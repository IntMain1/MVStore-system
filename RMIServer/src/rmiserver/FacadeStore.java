/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.RemoteException;


public class FacadeStore implements FacadeInterface{
    Store s;
    
    @Override
    public void SetStoreData(int ID,  String name, String location, String type)throws RemoteException {
        s.setID(ID);
        s.setLocation(location);
        s.setName(name);
        s.setType(type);
      
    }

    @Override
    public String GetStoreData() throws RemoteException{
        String StoreData=s.getLocation()+s.getName()+s.getType()+s.getID();
        return StoreData;
    }
    
}
