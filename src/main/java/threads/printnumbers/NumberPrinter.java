package threads.printnumbers;

public class NumberPrinter implements Runnable {

    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println("Number: " + number + " printed by thread: " +
                Thread.currentThread().getName());
    }
}
