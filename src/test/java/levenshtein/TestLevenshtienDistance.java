package levenshtein;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TestLevenshtienDistance {

    private LevenshteinDistance underTest
            = new LevenshteinDistance();

    @Test
    @Parameters(method = "getMinimumTestValues")
    public void testMinOfThree(int a, int b, int c, int expected) {

        int actual = underTest.min(a, b, c);
        assertEquals(actual, expected);

    }

    private static Object[] getMinimumTestValues() {
        return new Object[]{
                new Object[]{4, 6, 5, 4},
                new Object[]{-1, -2, -3, -3},
                new Object[]{1, 0, -3, -3},
                new Object[]{0, 0, 0, 0},
                new Object[]{-3, -2, -1, -3}
        };
    }

    @Test
    @Parameters(method = "getStringsWithKnownDistance")
    public void testEditDistance(String s1, String s2, int expectedDistance) {

        int actualDistance = underTest.calculateDistance(s1, s2);
        assertEquals(expectedDistance, actualDistance);

    }

    private static Object[] getStringsWithKnownDistance() {
        return new Object[] {
                new Object[] {"Hello", "hello", 1},
                new Object[] {"", "hello", 5},
                new Object[] {"", "", 0},
                new Object[] {"world", "hello", 4},

        };
    }
}
