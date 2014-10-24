package heapsort;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.stream.Stream;

@RunWith(JUnitParamsRunner.class)
public class TestHeapSort {

    private static final int NUMBER_OF_ARRAYS_TO_TEST = 10;
    private static final int LENGTH_OF_ARRAY = 10000;


    private HeapSort underTest = new HeapSort();

    @Test
    @Parameters(method = "getData")
    public void testHeapSort(Integer[] arrayToSort) {

        // sort array in position
        underTest.sort(arrayToSort);

        for (int i = 1; i < arrayToSort.length; i++) {
            Assert.assertTrue(arrayToSort[i-1] <= arrayToSort[i]);
        }
    }

    private static Object[] getData() {
        Object[] o = new Object[NUMBER_OF_ARRAYS_TO_TEST];

        for (int i = 0; i < o.length; i++) {
            o[i] = new Object[]{createRandomIntArray()};
        }
        return o;
    }

    private static Integer[] createRandomIntArray() {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(10000))
                .limit(LENGTH_OF_ARRAY).toArray(Integer[]::new);
    }
}