package threads.example;

public class HelloWorldPrinter implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello world from another thread:" + Thread.currentThread().getName());
    }
}
