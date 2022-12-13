import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static ConcurrentLinkedQueue<Customer> queue = new ConcurrentLinkedQueue<>();
    public static ArrayList<Customer>hopper = new ArrayList<>();
    public static boolean runnings = true;
    public static long runTimeMS = 3000;
    public static int numMade =0;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ArrayList<Customer> Customers = new ArrayList<>();
        CustomerFactory customerFactory = new CustomerFactory(500, 1000, 50, Customers);
        customerFactory.start();
        ArrayList <Cashier> cashiers = new ArrayList<>();
        cashiers.add(new Cashier());
        while((startTime+runTimeMS)>System.currentTimeMillis()){
        }
        runnings =false;
        while (numMade>hopper.size()){
            System.out.println(numMade);
            System.out.println(hopper.size());
        }
        System.out.println(avgCustWaitTime());
    }
    public static int avgCustWaitTime(){
        long total=0;
        long number=0;
        for(int i = 0;i<hopper.size()-1;i++){
            number+=1;
            total += hopper.get(i).getTimeInQueue();
            System.out.println(hopper.get(i).getTimeInQueue());
        }
        if (number == 0){
            return 0;
        }
        return (int)total/(int)number;
    }
}