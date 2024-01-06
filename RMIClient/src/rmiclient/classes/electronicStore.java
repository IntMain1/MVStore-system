/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient.classes;

import java.io.Serializable;



public class electronicStore extends Store implements Serializable{
    
    public electronicStore(int ID, String name, String location, String type) {
        super(ID, name, location, type);
    }
    
}
