import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static ConcurrentLinkedQueue<Customer> queue = new ConcurrentLinkedQueue<>();
    public static ArrayList<Customer>hopper = new ArrayList<>();
    public static boolean runnings = true;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long runTimeMS = 10000;
        ArrayList<Customer> Customers = new ArrayList<>();
        CustomerFactory customerFactory = new CustomerFactory(500, 1000, 30, Customers);
        customerFactory.start();
        ArrayList <Cashier> cashiers = new ArrayList<>();
        cashiers.add(new Cashier());
        cashiers.add(new Cashier());
        cashiers.add(new Cashier());
        while((startTime+runTimeMS)>System.currentTimeMillis()){
        }
        runnings =false;
        while (!queue.isEmpty()){

        }
        long afterShift = System.currentTimeMillis()+12000;
        while (afterShift>System.currentTimeMillis()){

        }
        System.out.println(avgCustWaitTime());
    }
    public static long avgCustWaitTime(){
        long total=0;
        long number=0;
        for(int i = 0;i<hopper.size()-1;i++){
            number++;
            total += hopper.get(i).getTimeInQueue();
        }
        if (number == 0){
            return 0;
        }
        return total/number;
    }
}