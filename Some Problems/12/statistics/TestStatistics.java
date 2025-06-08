package statistics;

import java.util.Arrays;
import java.util.Random;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        System.out.println("Testing MyArrayList:");
        MyArrayList arrayList = new MyArrayList();
        TestStatistics testArrayList = new TestStatistics(new Statistics(arrayList)); // Placeholder, will be updated in testMyArrayList
        testArrayList.testMyArrayList();

        System.out.println("\nTesting MyLinkedList:");
        MyLinkedList linkedList = new MyLinkedList();
        TestStatistics testLinkedList = new TestStatistics(new Statistics(linkedList)); // Placeholder, will be updated in testMyLinkedList
        testLinkedList.testMyLinkedList();      

    }

    public void testMyArrayList() {
        Random random = new Random();
        int length = random.nextInt(21) + 30; // [30, 50]
        MyArrayList list = new MyArrayList();
        System.out.print("Original Data (MyArrayList): ");
        for (int i = 0; i < length; i++) {
            double val = 1 + random.nextDouble() * 19; // [1, 20]
            list.add(val);
        }
        System.out.println(list.toString());

        this.statistics = new Statistics(list);

        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());

        MyList sortedList = list.sortIncreasing();
        System.out.println("Sorted Data: " + sortedList.toString());

        double[] ranks = statistics.rank();
        System.out.println("Ranks: " + Arrays.toString(ranks));

        // Test search - tìm một phần tử có trong list và một phần tử không có
        if (list.size() > 0) {
            MyIterator iterator = list.iterator(0);
            double existingElement = (double) iterator.next(); // Lấy phần tử đầu tiên để test
            System.out.println("Searching for " + existingElement + ": Index " + statistics.search(existingElement));
        }
        double nonExistingElement = 25.0; // Giả sử 25.0 không có trong list [1,20]
        System.out.println("Searching for " + nonExistingElement + ": Index " + statistics.search(nonExistingElement));
    }

    public void testMyLinkedList() {
        Random random = new Random();
        int length = random.nextInt(21) + 30; // [30, 50]
        MyLinkedList list = new MyLinkedList();
        System.out.print("Original Data (MyLinkedList): ");
        for (int i = 0; i < length; i++) {
            double val = 1 + random.nextDouble() * 19; // [1, 20]
            list.add(val);
        }
        System.out.println(list.toString());

        this.statistics = new Statistics(list);

        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());

        MyList sortedList = list.sortIncreasing();
        System.out.println("Sorted Data: " + sortedList.toString());

        double[] ranks = statistics.rank();
        System.out.println("Ranks: " + Arrays.toString(ranks));

        // Test search - tìm một phần tử có trong list và một phần tử không có
        if (list.size() > 0) {
            MyIterator iterator = list.iterator();
            double existingElement = (double) iterator.next(); // Lấy phần tử đầu tiên để test
            System.out.println("Searching for " + existingElement + ": Index " + statistics.search(existingElement));
        }
        double nonExistingElement = 25.0; // Giả sử 25.0 không có trong list [1,20]
        System.out.println("Searching for " + nonExistingElement + ": Index " + statistics.search(nonExistingElement));
    }
}
