/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;


public class Bank implements Serializable{
    
    String name;
    String location;

    public Bank(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    public boolean confirmPayment(Shopper s, int num){
        
    if(s.getCreditCardStatus()=="valid" && num == s.getCreditCardNum()){
     return true;
    }
    else { return false;}
    
    }
}

