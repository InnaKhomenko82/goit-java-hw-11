import java.util.Arrays;
import java.util.StringJoiner;

public class FizzBuzz {
    private int number = 1;
    private int finish;
    StringJoiner joiner = new StringJoiner(", ");

    public FizzBuzz(int finish) {
        this.finish = finish;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(33);

        Thread threadA = new Thread(fizzBuzz::fizz);
        Thread threadB = new Thread(fizzBuzz::buzz);
        Thread threadC = new Thread(fizzBuzz::fizzBuzz);
        Thread threadD = new Thread(fizzBuzz::number);

        fizzBuzz.runAll(threadA, threadB, threadC, threadD);
    }

    private void runAll(Thread threadA, Thread threadB, Thread threadC, Thread threadD) {
        for(Thread thread : Arrays.asList(threadA, threadB, threadC, threadD)){
            thread.start();
        }
    }

    public synchronized void fizz(){
        while(number <= finish){
            if (number % 3 == 0 && number % 5 != 0){
                joiner.add("fizz");
                number++;
                notifyAll();
            }
            else{
                try{
                    wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void buzz(){
        while (number <= finish){
            if (number % 5 == 0 && number % 3 != 0){
                joiner.add("buzz");
                number++;
                notifyAll();
            }
            else{
                try{
                    wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void fizzBuzz(){
        while (number <= finish){
            if (number % 15 == 0){
                joiner.add("fizzbuzz");
                number++;
                notifyAll();
            }
            else{
                try{
                    wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void number(){
        while (number <= finish){
            if (number % 3 != 0 && number % 5 != 0){
                joiner.add(String.valueOf(number));
                number++;
                notifyAll();
            }
            else{
                try{
                    wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println(joiner.toString());
    }
}
