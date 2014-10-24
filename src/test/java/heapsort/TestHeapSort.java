package heapsort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

@RunWith(Parameterized.class)
public class TestHeapSort {

    private Integer[] arrayToSort;
    private HeapSort underTest = new HeapSort();

    public TestHeapSort(Integer[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Test
    public void testHeapSort() {

        // sort array in position
        underTest.sort(arrayToSort);

        for (int i = 1; i < arrayToSort.length; i++) {
            Assert.assertTrue(arrayToSort[i-1] <= arrayToSort[i]);
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {getRandomIntegerArray()},
                {getRandomIntegerArray()},
                {getRandomIntegerArray()},
                {getRandomIntegerArray()},
                {getRandomIntegerArray()}
        });
    }

    private static Integer[] getRandomIntegerArray() {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(10000))
                .limit(10000).toArray(Integer[]::new);
    }
}
