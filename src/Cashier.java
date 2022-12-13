public class Cashier extends Thread{
    private boolean working=false; //is it currently doing something
    private long startedWorkTime;
    private Customer workingWith; //
    public Cashier() {
        this.start();
    }
    @Override
    public void run(){
        while (true){
            if(!working){
                if (!Main.queue.isEmpty()){
                    workingWith=Main.queue.poll();
                    working=true;
                    System.out.println("Workin With Customer");
                    startedWorkTime= System.currentTimeMillis();
                    if(workingWith!=null) {
                        workingWith.pickedUp();
                    }
                }
            }
            if(workingWith!=null) {
                if (workingWith.getCheckoutTime() + startedWorkTime < System.currentTimeMillis()) {
                    Main.hopper.add(workingWith);
                    working = false;
                    workingWith=null;
                    System.out.println("Finished Customer Off ;)");
                }
            }
        }
    }
}
