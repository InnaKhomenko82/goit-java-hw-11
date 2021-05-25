public class ThreadTester {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Detector detector = new Detector(timer);

        timer.start();
        detector.start();
    }
}
