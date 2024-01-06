/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;
import rmiserver.Database_manager.DB_manager;


public class Feedback implements Serializable,ROFeedback{
    
    int feedbackID;
    String description;
     DB_manager db =new DB_manager();
     int rating;

    public Feedback(int feedbackID, String description, int rating) {
        this.feedbackID = feedbackID;
        this.description = description;
        this.rating = rating;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    

    public Feedback(String description, int rating) {
        this.description = description;
        this.rating = rating;
    }

    public Feedback() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public DB_manager getDb() {
        return db;
    }

    public void setDb(DB_manager db) {
        this.db = db;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public void getFeedbackInfo(int ID){
        
        db.viewFeedback(ID);
    
    }
    
    
    
    
}
