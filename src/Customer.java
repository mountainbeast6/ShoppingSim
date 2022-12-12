import java.io.*;
import java.util.ArrayList;

public class Customer extends Thread{
    private static int nextID=0;
    private int id;
    private long shopTime; //how long in ms customer shops for
    private long checkoutTime; //how long in ms customer takes to check out
    private long enterTime; //time in ms customer entered
    private long enterQueueTime; //when they enter the Queue
    private long leaveQueueTime; //time in ms customer shops for
    private long timeInQueue;
    private long minShopTime=3000;

    public long getTimeInQueue() {
        return timeInQueue;
    }

    private long maxShopTime=20000;
    private long minCheckoutTime=1500;
    private long maxCheckoutTime=10000;
    public Customer(){
        id=nextID;
        nextID++;
        enterTime = System.currentTimeMillis();
        shopTime=(long)(minShopTime+Math.random()*(maxShopTime-minShopTime));
        checkoutTime=2000;
    }
    @Override
    public String toString() {
        return "Customer "+id;
    }
    @Override
    public void run(){
        while(true){
            if (enterTime + shopTime <= System.currentTimeMillis()) break;
        }
        System.out.println(this.toString()+" is done shopping");
        Main.queue.add(this);
        enterQueueTime=System.currentTimeMillis();
    }
    public void pickedUp(){
        leaveQueueTime =System.currentTimeMillis();
        timeInQueue=leaveQueueTime-enterQueueTime;
    }
}