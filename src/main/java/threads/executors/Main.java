package threads.executors;

import threads.printnumbers.NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        NumberPrinter numberPrinter;
        for (int i = 1; i <= 100; i++) {
            if (i == 50) {
                System.out.println("Hello");
            }
            numberPrinter = new NumberPrinter(i);
            executorService.submit(numberPrinter);
        }
        executorService.shutdown();
    }
}