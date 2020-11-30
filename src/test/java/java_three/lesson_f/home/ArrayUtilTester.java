package java_three.lesson_f.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java_three.lesson_f.home.ArrayUtil;

public class ArrayUtilTester {

    private ArrayUtil util;

    @BeforeEach
    public void init() {
        util = new ArrayUtil();
    }

    @Test
    public void testNumbersAfterFour1() {
        Assertions.assertArrayEquals(new int[]{1, 7}, util.getAfterFour(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void testNumbersAfterFour2() {
        Assertions.assertArrayEquals(new int[]{2, 3, 10, 1, 7}, util.getAfterFour(new int[] {1, 2, 4, 4, 2, 3, 10, 1, 7}));
    }

    @Test
    public void testNumbersAfterFourException() {
        Assertions.assertThrows(RuntimeException.class, () -> util.getAfterFour(new int[] {1, 2, 10, 5, 2, 3, 10, 1, 7}));
    }

    @Test
    public void testArrayCheckerTrue() {
        Assertions.assertTrue(util.checkArray(new int[]{1, 2, 4, 4, 2, 3, 10, 1, 7}));
    }

    @Test
    public void testArrayCheckerFalseWithoutOnes() {
        Assertions.assertFalse(util.checkArray(new int[]{9, 2, 4, 4, 2, 3, 10, 5, 7}));
    }

    @Test
    public void testArrayCheckerFalseWithoutFours() {
        Assertions.assertFalse(util.checkArray(new int[]{1, 5, 2, 3, 7, 3, 1, 5, 7}));
    }

    @Test
    public void testArrayCheckerFalse() {
        Assertions.assertFalse(util.checkArray(new int[]{5, 5, 2, 3, 7, 3, 2, 5, 7}));
    }

}
