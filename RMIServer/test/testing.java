
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rmiserver.Database_manager.DB_manager;
import rmiserver.Feedback;
import rmiserver.RMIServer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class testing {
    DB_manager db =new DB_manager();
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    
    public void TestingDatabaseRead() {
        ArrayList<Feedback> F = DB_manager.getFeedback_S();
        int sumofRatings = 0;
        db.viewRating(sumofRatings);
        assertEquals(32, sumofRatings);
        System.out.println(sumofRatings);

    }

//    public void TestingCreateObject() throws RemoteException {
//        int newrating =7;
//        int sumofRatings = 0;
//        Feedback F = new Feedback("not that great",newrating);
//        for (Feedback f : DB_manager.getFeedback_S()) {
//            sumofRatings += f.getRating();
//        }
//        
//        assertEquals(32 +newrating , sumofRatings);
//        System.out.println(sumofRatings);
//    }
//    
//     public void AssertObject() throws RemoteException {
//        int newrating =7;
//        Feedback F = new Feedback("not that great",newrating);
//        Feedback t = DB_manager.getFeedback_S().get( DB_manager.getFeedback_S().size()-1);
//        assertSame(F, t);
//    }


    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        RMIServer.main(args);
        TestingDatabaseRead();
        //TestingCreateObject();
        //AssertObject();
    }

}
