package threads.callable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(4, 7, 2, 9, 5, 6, 0);

        ExecutorService executorService = Executors.newCachedThreadPool();

        MergeSorter mergeSorter = new MergeSorter(list, executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter); // blocking call

        System.out.println("Sorted List: " + sortedListFuture.get());

        executorService.shutdown();
    }
}
