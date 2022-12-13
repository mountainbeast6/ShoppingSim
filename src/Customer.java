import java.io.*;
import java.util.ArrayList;

public class Customer extends Thread{
    public static int nextID=0;
    private int id;
    private long shopTime; //how long in ms customer shops for
    private long checkoutTime; //how long in ms customer takes to check out
    private long enterTime; //time in ms customer entered
    private long enterQueueTime; //when they enter the Queue
    private long leaveQueueTime; //time in ms customer shops for
    private long timeInQueue=0;
    private long minShopTime=3000;
    private long maxShopTime=20000;
    private long minCheckoutTime=300;
    private long maxCheckoutTime=1000;
    public long getTimeInQueue() {
        return timeInQueue;
    }

    public long getCheckoutTime() {
        return checkoutTime;
    }

    public Customer(){
        id=nextID;
        nextID++;
        enterTime = System.currentTimeMillis();
        shopTime=(long)(minShopTime+Math.random()*(maxShopTime-minShopTime));
        checkoutTime=(long)(minCheckoutTime+Math.random()*(maxCheckoutTime-minCheckoutTime));
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
        this.timeInQueue=this.leaveQueueTime-this.enterQueueTime;
    }
}