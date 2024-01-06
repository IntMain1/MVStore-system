/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;


public interface OrderI {
   public void addNotificationObserver(SObserver PO);

   public void removeNotificationObserver(SObserver PO);
   public void NotifyAll(String news);
}
