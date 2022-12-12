import java.util.ArrayList;

public class CustomerFactory extends Thread {
    private long timeLow;
    private long timeHigh;
    private long chance;
    private long nextAttempt;
    ArrayList<Customer> customers;
    int randnum;
    public CustomerFactory(long timeLow, long timeHigh, int chance, ArrayList<Customer> customers){
        this.timeLow=timeLow;
        this.timeHigh=timeHigh;
        this.chance=chance;
        this.customers=customers;
        nextAttempt=System.currentTimeMillis()+(long)(timeLow+Math.random()*(timeHigh-timeLow));
    }
    public void run() {
        while (true) {
            if (nextAttempt<System.currentTimeMillis()){
                randnum=(int)(1+Math.random()*99);
                if(randnum>chance){
                    System.out.println("make customer");
                    Customer c = new Customer();
                    customers.add(c);
                    c.start();
                }
                else {
                    System.out.println("did not make customer");
                }
                nextAttempt=System.currentTimeMillis()+(long)(timeLow+Math.random()*(timeHigh-timeLow));
            }
        }
    }
}
