public class Timer extends Thread {
    private int timer;
    private final int stopTimer = 23;

    public synchronized int getTimer(){
        return timer;
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()) {
            try{
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (this) {
                timer++;
            }
            System.out.println(currentThread().getName() + " timer: " + timer);

            if (timer == stopTimer){
                currentThread().interrupt();
            }
        }
    }
}
