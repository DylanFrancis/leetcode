package com.tests.longestsubstring;

import com.tests.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTests {
    private static final List<Pair<String, Integer>> cases = Arrays.asList(
            new Pair<>("abcabcbb", 3),
            new Pair<>("bbbbb", 1),
            new Pair<>("pwwkew", 3),
            new Pair<>("au", 2),
            new Pair<>("abba", 2),
            new Pair<>("dvdf", 3),
            new Pair<>("aab", 2));

    @Test
    public void allCases() {
        for (Pair<String, Integer> pair : cases) {
            test(pair.getKey(), pair.getValue());
        }
    }

    @Test
    public void specificCase() {
        test("pwwkew", 3);
    }

    private void test(String theString, int expected) {
        Solution solution = new Solution();

        int output = solution.lengthOfLongestSubstring2(theString);

        Assertions.assertEquals(expected, output, theString);
    }

}