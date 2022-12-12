public class Cashier extends Thread{
    private boolean working=false; //is it currently doing something
    private Customer workingWith; //
    public Cashier(boolean working, Customer workingWith) {
        this.working = working;
        this.workingWith = workingWith;
    }
    public void run(){
        while (true){
            if(!working){
                if (!Main.queue.isEmpty()){
                    workingWith=Main.queue.poll();
                    working=true;
                }
            }
        }
    }
}
