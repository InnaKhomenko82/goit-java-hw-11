public class Detector extends Thread {
    Timer count;
    int timer;

    public Detector(Timer count){
        this.count = count;
    }

    @Override
    public void run() {
        while (count.isAlive()){
            try {
                timer = count.getTimer();
                if (timer%5 == 0 && timer !=0){
                    System.out.println(currentThread().getName() + " Прошло 5 секунд");
                    sleep(2000);
                }
            } catch (IllegalStateException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish - " + Thread.currentThread().getName());
    }
}
