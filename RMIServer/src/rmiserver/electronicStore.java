/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;



public class electronicStore extends Store implements Serializable{
    
    public electronicStore(int ID, String name, String location, String type) {
        super(ID, name, location, type);
    }
    
    @Override
    public void open() {

        System.out.println("Store is Opened");

    }

    @Override
    public void close() {
        System.out.println("Store is closed");
    }
    
}
