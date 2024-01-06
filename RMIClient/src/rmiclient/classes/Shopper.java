/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient.classes;

import java.io.Serializable;


public class Shopper extends User implements Serializable{
    
    int creditCardNum;
    String shippingAdress;

    public Shopper(int creditCardNum, String shippingAdress, int ID, String name, int age, int password, String email) {
        super(ID, name, age, password, email);
        this.creditCardNum = creditCardNum;
        this.shippingAdress = shippingAdress;
    }
    
    
}
