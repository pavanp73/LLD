package threads.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    private final List<Integer> list;
    private final ExecutorService executorService;

    public MergeSorter(List<Integer> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {

        int n = list.size();

        if (n <= 1) {
            return list;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < n/2; i++) {
            left.add(list.get(i));
        }

        for (int i = n/2; i < n; i++) {
            right.add(list.get(i));
        }

        // ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter leftSorter = new MergeSorter(left, executorService);
        MergeSorter rightSorter = new MergeSorter(right, executorService);

        Future<List<Integer>> leftSortedFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightSortedFuture = executorService.submit(rightSorter);

        List<Integer> leftSortedList = leftSortedFuture.get();
        List<Integer> rightSortedList = rightSortedFuture.get();

        return merge(leftSortedList, rightSortedList);
    }

    private static List<Integer> merge(List<Integer> leftSortedList, List<Integer> rightSortedList) {
        int i = 0, j = 0;
        List<Integer> sortedList = new ArrayList<>();
        while (i < leftSortedList.size() && j < rightSortedList.size()) {
            if (leftSortedList.get(i) < rightSortedList.get(j)) {
                sortedList.add(leftSortedList.get(i));
                i++;
            } else {
                sortedList.add(rightSortedList.get(j));
                j++;
            }
        }

        while (i < leftSortedList.size()) {
            sortedList.add(leftSortedList.get(i));
            i++;
        }

        while (j < rightSortedList.size()) {
            sortedList.add(rightSortedList.get(j));
            j++;
        }
        return sortedList;
    }
}
