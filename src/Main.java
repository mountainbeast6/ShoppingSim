import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static ConcurrentLinkedQueue<Customer> queue = new ConcurrentLinkedQueue<>();
    public static ArrayList<Customer>done = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<Customer> Customers = new ArrayList<>();
        CustomerFactory customerFactory = new CustomerFactory(4000, 6000, 50, Customers);
        Cashier c = new Cashier();
        Cashier b = new Cashier();
        customerFactory.start();
        c.start();
        b.start();
        while(true){
            long nextAttempt = System.currentTimeMillis()+3;
//            if (nextAttempt<System.currentTimeMillis()){
//                if(queue.peek()!=null){
//                    System.out.println("it workin bois");
//                }
//                else{
//                    System.out.println("it not workin bois");
//                }
//            }
        }
    }
}