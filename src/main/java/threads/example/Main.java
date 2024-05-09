package threads.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread thread = new Thread(helloWorldPrinter);

        thread.start();
    }
}