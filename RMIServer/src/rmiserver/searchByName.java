/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import rmiserver.Database_manager.DB_manager;


public class searchByName implements searchStrategy {

    DB_manager db =new DB_manager();
    @Override
    public void searchProduct(String name,int num) {
        db.viewProductByName(name);
    }
    
}
