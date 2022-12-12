public class Cashier extends Thread{
    private boolean working=false; //is it currently doing something
    private long startedWorkTime;
    private Customer workingWith; //
    public Cashier() {
    }
    public void run(){
        while (true){
            if(!working){
                if (!Main.queue.isEmpty()){
                    workingWith=Main.queue.poll();
                    working=true;
                    System.out.println("Workin With Customer");
                    startedWorkTime= System.currentTimeMillis();
                }
            }
            else if(workingWith.getCheckoutTime()+startedWorkTime<System.currentTimeMillis()){
                Main.done.add(workingWith);
                working=false;
                System.out.println("Finished Customer Off ;)");
            }
        }
    }
}
