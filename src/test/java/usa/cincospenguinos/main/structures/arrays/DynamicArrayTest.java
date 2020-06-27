package usa.cincospenguinos.main.structures.arrays;

import org.junit.Test;

public class DynamicArrayTest {

    /* ***IMPORTANT TIMING NOTE***
     * For some reason the way that JUnit runs each of these separate timings as part of the same process messes
     * with the results. Running them together will provide different behavior than running them separately. To get
     * the correct (or, at least, expected) results for both of these timings, RUN THEM SEPARATELY.
     */

    @Test
    public void time_fastestDynamicArrayTypeGrowAtLength() {
        System.out.println("Fastest Type for Growth At Length");
        System.out.println("# of Elements\tSimpleDynamicArray\tDoubleBackedDynamicArray");

        int trials = 100000;
        int sizes[] = { 10, 100, 1000, 10000, 100000, 1000000 };

        for (int size : sizes) {
            long simpleTime = 0;
            long doubleBackedTime = 0;

            for (int trial = 1; trial <= trials; trial++) {
                simpleTime += timeForSetGrowAtLength(new SimpleDynamicArray<>(8));
                doubleBackedTime += timeForSetGrowAtLength(new DoubleBackedDynamicArray<>(8));
            }

            simpleTime /= trials;
            doubleBackedTime /= trials;

            System.out.println(size + "\t" + simpleTime + "\t" + doubleBackedTime);
        }
    }

    @Test
    public void time_fastestDynamicArrayTypeGrowAtThreeQuarters() {
        System.out.println("Fastest Type for Growth At 3/4 Length");
        System.out.println("# of Elements\tSimpleDynamicArray\tDoubleBackedDynamicArray");

        int trials = 100000;
        int sizes[] = { 10, 100, 1000, 10000, 100000, 1000000 };

        for (int size : sizes) {
            long simpleTime = 0;
            long doubleBackedTime = 0;

            for (int trial = 1; trial <= trials; trial++) {
                simpleTime += timeForSetGrowAtThreeQuarters(new SimpleDynamicArray<>(8));
                doubleBackedTime += timeForSetGrowAtThreeQuarters(new DoubleBackedDynamicArray<>(8));
            }

            simpleTime /= trials;
            doubleBackedTime /= trials;

            System.out.println(size + "\t" + simpleTime + "\t" + doubleBackedTime);
        }
    }

    private long timeForSetGrowAtLength(DynamicArray<Integer> arrayToTest) {
        long operationStart = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            boolean mustGrow = i == arrayToTest.length();

            if (mustGrow) {
                arrayToTest.grow();
            }

            arrayToTest.set(i, i);
        }
        long operationEnd = System.nanoTime();

        return operationEnd - operationStart;
    }

    private long timeForSetGrowAtThreeQuarters(DynamicArray<Integer> arrayToTest) {
        long operationStart = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            boolean mustGrow = i == arrayToTest.length() * 3 / 4;

            if (mustGrow) {
                arrayToTest.grow();
            }

            arrayToTest.set(i, i);
        }
        long operationEnd = System.nanoTime();

        return operationEnd - operationStart;
    }
}