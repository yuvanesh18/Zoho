

package yuva.taxibookingapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaxiBookingApp {

    //create taxi for n number
    public static List<Taxi> createTaxi(int n)
    {
        List<Taxi> T = new ArrayList<Taxi>();
        for(int i=0;i<n;i++)
        {
            Taxi t = new Taxi();
            T.add(t);
        }
        return T;
    }
    
    //taxi booking
    public static void bookTaxi(int id, char pickuploc, char droploc,int pickuptime,List<Taxi> freetaxi)
    {
        int min = Integer.MAX_VALUE;
        Taxi Bookedtaxi = null;
        int distanceBetweenpickupandDrop = 0;
        int earnings = 0;
        int freetime =0;
        char nextspot = 'z';
        String tripdetails = "";
        
        for(Taxi t : freetaxi){
            if(Math.abs((t.currentspot-'@') - (pickuploc-'@')) * 15  < min)
            {
                 Bookedtaxi = t;
                 distanceBetweenpickupandDrop = Math.abs((droploc-'@') - (pickuploc-'@')) * 15 ;
                 earnings = (distanceBetweenpickupandDrop - 5) * 10 + 100 ;
                 freetime = pickuptime + (distanceBetweenpickupandDrop/15);
                 nextspot = droploc;
                 min = Math.abs((t.currentspot-'@') - (pickuploc-'@')) * 15 ;
                 tripdetails = id+" "+id+" "+pickuploc+" "+droploc+" "+pickuptime+" "+freetime+" "+earnings;
            }
        }
        
        Bookedtaxi.setdetails(true,nextspot,freetime,Bookedtaxi.totalearnings+earnings,tripdetails);
        
        System.out.println("Taxi -" + Bookedtaxi.id + " booked");
    }
    
    public static List<Taxi> getfreeTaxi(List<Taxi> taxi,int pickuptime, int pickuploc)
    {
        List<Taxi> freetaxi = new ArrayList<Taxi>();
        
        for(Taxi t : taxi)
        {
            if(t.freetime<=pickuptime && (Math.abs((t.currentspot-'0') - (pickuploc-'0')) <=  pickuptime-t.freetime )  ) {
                freetaxi.add(t);
            }
        } 
        return freetaxi;
        
    }
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter total number of taxis : ");
        int n = sc.nextInt();
        List<Taxi> taxi = createTaxi(n);
        
        boolean loop = true;
        
        while(loop)
        {
            System.out.println("1: Book taxi \n2: Print Taxi details \n3: Exit App");
            System.out.println("Enter Your choice : ");
            int choice = sc.nextInt();
            int id =1;
            switch(choice)
            {
                case 1:
                {
                    int customerId = id;
                    System.out.println("Call Taxi Booking");
                    System.out.println("Enter Pickup Location: ");
                    char pickuploc = sc.next().charAt(0);
                    System.out.println("Enter Drop Location: ");
                    char droploc = sc.next().charAt(0);
                    System.out.println("Enter Pickup time in hrs: ");
                    int pickuptime = sc.nextInt();
                    
                    List<Taxi> freeTaxi = getfreeTaxi(taxi,pickuptime,pickuploc);
                    
                    if(freeTaxi.isEmpty())
                    {
                        System.out.println("No Taxi can be alloted. Exiting.....");
                        return;
                    }
                    
                    Collections.sort(freeTaxi,(a,b)->a.totalearnings-b.totalearnings);
                    
                    bookTaxi(id,pickuploc,droploc,pickuptime,freeTaxi);
                    
                    id++;
                    break;
                }
                case 2:
                {
                    for(Taxi t : taxi)
                    {
                        t.printTaxiDetails();
                    }
                    break;
                }
                case 3:
                {
                    loop = false;
                    sc.close();
                    break;
                }
            }
           
        }
        
    }
}
