/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver.Database_manager;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import static com.mongodb.client.model.Updates.set;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmiserver.Admin;
import rmiserver.Driver;
import rmiserver.Feedback;
import rmiserver.Order;
import rmiserver.Product;
import rmiserver.Shopper;
import rmiserver.Store;
import rmiserver.User;
import rmiserver.Vendor;
public final class DB_manager {
    
    
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();
    private static MongoClient mongoClient;
    private MongoClient client;
    private MongoDatabase database;
    private static ArrayList<Vendor> Vendor_S = new ArrayList<>();
    private static ArrayList<User> User_S = new ArrayList<>();
    ;
    private static ArrayList<Store> Store_S = new ArrayList<>();
    ;
    private static ArrayList<Shopper> Shopper_S = new ArrayList<>();
    ;
    private static ArrayList<Product> Product_S = new ArrayList<>();
    ;
    private static ArrayList<Order> Order_S = new ArrayList<>();
    ;
    private static ArrayList<Feedback> Feedback_S = new ArrayList<>();
    ;
    private static ArrayList<Driver> Driver_S = new ArrayList<>();
    ;
    private static ArrayList<Admin> Admin_S = new ArrayList<>();
    ;
   
    
    private static MongoCollection<Document> IDCounter;
    private static MongoCollection<Document> Vendor;
    private static MongoCollection<Document> User;
    private static MongoCollection<Document> Store;
    private static MongoCollection<Document> Shopper;
    private static MongoCollection<Document> Product;
    private static MongoCollection<Document> Order;
    private static MongoCollection<Document> Feedback;
    private static MongoCollection<Document> Driver;
    private static MongoCollection<Document> Bank;
    private static MongoCollection<Document> Admin;
    public DB_manager() {
      Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        String connectionString = "mongodb+srv://Admin:ydv4FZVwlrw5fAOF@ams.ff92t.mongodb.net/<dbname>?retryWrites=true&w=majority";
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
//        try {
//            mongoClient = new MongoClient(new MongoClientURI(connectionString));
//            IDCounter = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("IDCounter");
//            Vendor = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Vendor");
//            User = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("User");
//            Store = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Store");
//            Shopper = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Shopper");
//            Product = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Product");
//            Order = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Order");
//            Feedback = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Feedback");
//            Driver = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Driver");
//            Bank = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Bank");
            //Admin = DB_manager.getMongoClient().getDatabase("MVStore").getCollection("Admin");
//            
//            MongoIterable<String> mc = mongoClient.listDatabaseNames();
//            
//        } catch (Exception ex) {
//            System.out.println("Exception occured, Database connection Error");
//        }
        
        client = new MongoClient();
        database = client.getDatabase("MVStore"); // Database name
        Admin = database.getCollection("Admin");
        Vendor= database.getCollection("Vendor");
        User=database.getCollection("User");
        Store=database.getCollection("Store");
        Shopper =database.getCollection("Shopper");
        Product =database.getCollection("Product");
        Order = database.getCollection("Order");
        Feedback = database.getCollection("Feedback");
        Driver = database.getCollection("Driver");
        Bank = database.getCollection("Bank");
        
    }
    
    
    
    public void insertAdmin(Admin a) {
        Admin.insertOne(Document.parse(gson.toJson(a)));
        System.out.println("Admin inserted.");
    }
     
    public void updateAdmin(Admin a) {
        Document doc = Document.parse(gson.toJson(a));
        Admin.replaceOne(Filters.eq("email", a.getEmail()), doc);
        System.out.println("Admin updated.");
    }
     
    public void deleteAdmin(String name) {
        Admin.deleteOne(Filters.eq("name", name));
        System.out.println("Admin deleted.");
    }
    public void insertVendor(Vendor v) {
        Vendor.insertOne(Document.parse(gson.toJson(v)));
        System.out.println("Vendor inserted.");
    }
    
    public void updateVendor(Vendor v) {
        Document doc = Document.parse(gson.toJson(v));
        Vendor.replaceOne(Filters.eq("email", v.getEmail()), doc);
        System.out.println("Vendor updated.");
    }
    
    public void deleteVendor(int ID) {
        Vendor.deleteOne(Filters.eq("ID", ID));
        System.out.println("Vendor deleted.");
    }
    
    public Vendor viewVendor(String name) {
        Document doc = collection.find(Filters.eq("name", name)).first();
        Vendor result = gson.fromJson(doc.toJson(), Vendor.class);
        return result;
    }
    
    
     public void insertDriver(Driver v) {
        Driver.insertOne(Document.parse(gson.toJson(v)));
        System.out.println("Driver inserted.");
    }
     
     public void updateDriver(Driver v) {
        Document doc = Document.parse(gson.toJson(v));
        Driver.replaceOne(Filters.eq("email", v.getEmail()), doc);
        System.out.println("Driver updated.");
    }
     
     public void deleteDriver(int ID) {
        Driver.deleteOne(Filters.eq("ID", ID));
        System.out.println("Driver deleted.");
    }
     
    public void insertProduct(Product t) {
        Product.insertOne(Document.parse(gson.toJson(t)));
        System.out.println("Product inserted.");
    }
    
    public void updateProduct(Product t) {
        Document doc = Document.parse(gson.toJson(t));
        Product.replaceOne(Filters.eq("price", t.getPrice()), doc);
        Product.replaceOne(Filters.eq("quantity", t.getQuantity()), doc);
        System.out.println("Product quantity and price are updated.");
    }
    
    public void cancelProduct(String name) {
        Product.deleteOne(Filters.eq("name", name));
        System.out.println("Product canceled.");
    }
    
    public void cancelOrder(int ID) {
        Order.deleteOne(Filters.eq("ID", ID));
        System.out.println("Order canceled.");
    }
    
    
    public Vendor viewApplication(String app) {
        Document doc = collection.find(Filters.eq("application", app)).first();
        Vendor result = gson.fromJson(doc.toJson(), Vendor.class);
        return result;
    }
    
    public void addOrder(Order o) {
        Order.insertOne(Document.parse(gson.toJson(o)));
        System.out.println("Order inserted.");
    }
     public Order viewOrder(int ID){
         Document doc = collection.find(Filters.eq("ID", ID)).first();
        Order result = gson.fromJson(doc.toJson(), Order.class);
        return result;
     
     }
     
     public Product viewProductByName(String name){
         Document doc = collection.find(Filters.eq("name", name)).first();
        Product result = gson.fromJson(doc.toJson(), Product.class);
        return result;
     
     }
     
          public Product viewProductByType(String type){
         Document doc = collection.find(Filters.eq("type", type)).first();
        Product result = gson.fromJson(doc.toJson(), Product.class);
        return result;
     
     }
          
     
    public void deleteOrder(int ID) {
        Order.deleteOne(Filters.eq("ID", ID));
        System.out.println("Order deleted.");
    } 
    
    public Feedback viewFeedback(int ID) {
        Document doc = collection.find(Filters.eq("application", ID)).first();
        Feedback result = gson.fromJson(doc.toJson(), Feedback.class);
        return result;
    }
    
  
    
    public ArrayList<Feedback> viewRating(int rating) {
        ArrayList<Feedback> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("rating", rating)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            result.add(gson.fromJson(jsonResult, Feedback.class));
        }
        return result;
    }
   
    
    public void insertFeedback(Feedback f) {
        Feedback.insertOne(Document.parse(gson.toJson(f)));
        System.out.println("Feedback inserted.");
    }
    
     public void addStore(Store s) {
        Store.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Store inserted.");
    }
      public void updateOrder(Order o) {
        Document doc = Document.parse(gson.toJson(o));
        Order.replaceOne(Filters.eq("quantity", o.getQuantity()), doc);
        System.out.println("Order quantity updated.");
    }
     
       public static ArrayList<Feedback> readFeedbacks() throws RemoteException {
        ArrayList<Document> docs = Feedback.find().into(new ArrayList<>());
        for (Document i : docs) {
            Feedback f = new Feedback();
            f.setFeedbackID(i.getInteger("feedbackID"));
            f.setDescription(i.getString("description"));
            f.setRating(i.getInteger("rating"));
            
            Feedback_S.add(f);
        }
        return Feedback_S;
    }
    
    private static void UpdateFeedbacks() throws RemoteException {
        for (Feedback F : Feedback_S) {
            Feedback.findOneAndUpdate(new Document("feedbackID", F.getFeedbackID()), set("description", F.getDescription()));
            Feedback.findOneAndUpdate(new Document("feedbackID", F.getFeedbackID()), set("rating", F.getRating()));
        }
    }
    
    
    
     
    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public void setCollection(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    public static void setMongoClient(MongoClient mongoClient) {
        DB_manager.mongoClient = mongoClient;
    }

    public static MongoCollection<Document> getIDCounter() {
        return IDCounter;
    }

    public static void setIDCounter(MongoCollection<Document> IDCounter) {
        DB_manager.IDCounter = IDCounter;
    }

    public static MongoCollection<Document> getVendor() {
        return Vendor;
    }

    public static void setVendor(MongoCollection<Document> Vendor) {
        DB_manager.Vendor = Vendor;
    }

    public static MongoCollection<Document> getUser() {
        return User;
    }

    public static void setUser(MongoCollection<Document> User) {
        DB_manager.User = User;
    }

    public static MongoCollection<Document> getStore() {
        return Store;
    }

    public static void setStore(MongoCollection<Document> Store) {
        DB_manager.Store = Store;
    }

    public static MongoCollection<Document> getShopper() {
        return Shopper;
    }

    public static void setShopper(MongoCollection<Document> Shopper) {
        DB_manager.Shopper = Shopper;
    }

    public static MongoCollection<Document> getProduct() {
        return Product;
    }

    public static void setProduct(MongoCollection<Document> Product) {
        DB_manager.Product = Product;
    }

    public static MongoCollection<Document> getOrder() {
        return Order;
    }

    public static void setOrder(MongoCollection<Document> Order) {
        DB_manager.Order = Order;
    }

    public static MongoCollection<Document> getFeedback() {
        return Feedback;
    }

    public static void setFeedback(MongoCollection<Document> Feedback) {
        DB_manager.Feedback = Feedback;
    }

    public static MongoCollection<Document> getDriver() {
        return Driver;
    }

    public static void setDriver(MongoCollection<Document> Driver) {
        DB_manager.Driver = Driver;
    }

    public static MongoCollection<Document> getBank() {
        return Bank;
    }

    public static void setBank(MongoCollection<Document> Bank) {
        DB_manager.Bank = Bank;
    }

    public static MongoCollection<Document> getAdmin() {
        return Admin;
    }

    public static void setAdmin(MongoCollection<Document> Admin) {
        DB_manager.Admin = Admin;
    }

    public MongoClient getClient() {
        return client;
    }

    public void setClient(MongoClient client) {
        this.client = client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }

    public static ArrayList<Vendor> getVendor_S() {
        return Vendor_S;
    }

    public static void setVendor_S(ArrayList<Vendor> Vendor_S) {
        DB_manager.Vendor_S = Vendor_S;
    }

    public static ArrayList<User> getUser_S() {
        return User_S;
    }

    public static void setUser_S(ArrayList<User> User_S) {
        DB_manager.User_S = User_S;
    }

    public static ArrayList<Store> getStore_S() {
        return Store_S;
    }

    public static void setStore_S(ArrayList<Store> Store_S) {
        DB_manager.Store_S = Store_S;
    }

    public static ArrayList<Shopper> getShopper_S() {
        return Shopper_S;
    }

    public static void setShopper_S(ArrayList<Shopper> Shopper_S) {
        DB_manager.Shopper_S = Shopper_S;
    }

    public static ArrayList<Product> getProduct_S() {
        return Product_S;
    }

    public static void setProduct_S(ArrayList<Product> Product_S) {
        DB_manager.Product_S = Product_S;
    }

    public static ArrayList<Order> getOrder_S() {
        return Order_S;
    }

    public static void setOrder_S(ArrayList<Order> Order_S) {
        DB_manager.Order_S = Order_S;
    }

    public static ArrayList<Feedback> getFeedback_S() {
        return Feedback_S;
    }

    public static void setFeedback_S(ArrayList<Feedback> Feedback_S) {
        DB_manager.Feedback_S = Feedback_S;
    }

    public static ArrayList<Driver> getDriver_S() {
        return Driver_S;
    }

    public static void setDriver_S(ArrayList<Driver> Driver_S) {
        DB_manager.Driver_S = Driver_S;
    }

    public static ArrayList<Admin> getAdmin_S() {
        return Admin_S;
    }

    public static void setAdmin_S(ArrayList<Admin> Admin_S) {
        DB_manager.Admin_S = Admin_S;
    }


    
    

    
    

   
    
}
