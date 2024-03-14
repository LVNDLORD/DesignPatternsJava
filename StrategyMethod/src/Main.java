import java.util.Random;

public class Main {
    private static final int SMALL_ARRAY_SIZE = 100;
    private static final int LARGE_ARRAY_SIZE = 100_000;

    public static void measureSortingPerformance(SortStrategy strategy, int[] data) {
        SortingContext context = new SortingContext();
        context.setStrategy(strategy);
        long startTime = System.currentTimeMillis();
        context.sortArray(data.clone());
        long endTime = System.currentTimeMillis();
        System.out.println(strategy.getClass().getSimpleName() + " : " + (endTime - startTime) + " ms");
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(SMALL_ARRAY_SIZE);
        int[] largeArray = generateRandomArray(LARGE_ARRAY_SIZE);

        System.out.println("Sorting a small array of integers: ");
        measureSortingPerformance(new InsertionSortStrategy(), smallArray);
        measureSortingPerformance(new SelectionSortStrategy(), smallArray);
        measureSortingPerformance(new BubbleSortStrategy(), smallArray);

        System.out.println("\nSorting a large array of integers: ");
        measureSortingPerformance(new InsertionSortStrategy(), largeArray);
        measureSortingPerformance(new SelectionSortStrategy(), largeArray);
        measureSortingPerformance(new BubbleSortStrategy(), largeArray);
    }
}
