
package yuva.taxibookingapp;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
   
    static int TaxiCount = 0; //Taxi count
    int id;
    boolean booked;
    char currentspot;
    int freetime;
    int totalearnings;
    List<String> TripsHistory;
    
    
   public  Taxi()
   {
       booked = false;
       currentspot = 'A';
       freetime = 6;
       totalearnings = 0;
       TripsHistory = new ArrayList<String>();
       TaxiCount= TaxiCount + 1;
       id = TaxiCount;
   }
    
   public void printTaxiDetails()
   {
       System.out.println("Taxi - "+ this.id + " Total Earnings : "+this.totalearnings);
       for(String s : TripsHistory)
       {
           System.out.println("BookingId    CustomerID     From    To     Pickuptime    DropTime   Earnings");
           System.out.println(s);
       }
   }

    public void setdetails(boolean b, char nextspot, int freetime, int earnings, String tripdetails) {
        this.booked = b;
        this.currentspot = nextspot;
        this.freetime = freetime;
        this.totalearnings=earnings;
        TripsHistory.add(tripdetails);
    }
}
