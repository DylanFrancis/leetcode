package com.tests.climbingstairs;

import java.util.Map;

public class Solution {

    public int climbStairs(int n) {

//        return climb(n, new HashMap<>());
        return climb2(n, new int[n + 1]);

    }

    private int climb(int n, Map<Integer, Integer> map) {

        if (n <= 1) {
            return 1;
        }

        if (map.containsKey(n)) {

            return map.get(n);

        } else {

            int a = climb(n - 2, map) + climb(n - 1, map);
            map.put(n, a);

            return a;
        }
    }

    private int climb2(int n, int[] arr) {

        if (n <= 1) {
            return 1;
        }

        if (arr[n] != 0) {

            return arr[n];

        } else {

            int a = climb2(n - 2, arr) + climb2(n - 1, arr);
            arr[n] = a;

            return a;
        }
    }
}
