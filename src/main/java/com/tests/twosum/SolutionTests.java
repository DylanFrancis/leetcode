package com.tests.twosum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

public class SolutionTests {

    @Test
    public void test01() {
        test(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1});
    }

    @Test
    public void test02() {
        test(new int[] {3, 2, 4}, 6, new int[] {1, 2});
    }

    @Test
    public void test03() {
        test(new int[] {3, 3}, 6, new int[] {0, 1});
    }

    private void test(int [] arr, int target, int[] ... expected) {

        int[] actual = new Solution().twoSum(arr, target);

        System.out.println("answer=" + Arrays.toString(actual));

        Assertions.assertTrue(() -> {
            for (int i = 0; i < expected.length; i++) {
                int[] ints = expected[i];

                if (Arrays.equals(ints, actual)) {
                    return true;
                }
            }
            return false;
        });
    }
}
