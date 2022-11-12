package com.tests.climbingstairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTests {

    @Test
    public void test1() {
        doTest(2, 2);
    }

    @Test
    public void test2() {
        doTest(3, 3);
    }

    @Test
    public void test3() {
        doTest(6, 13);
    }

    private void doTest(int steps, int expected) {
        Assertions.assertEquals(expected, new Solution().climbStairs(steps), "steps=" + steps);
    }
}
