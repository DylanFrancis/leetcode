package com.tests.twosum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

//    test(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1});
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int x = 0; x < nums.length; x++) {

            int left = nums[x];
            int sub = target - nums[x];

            if (map.containsKey(sub)) {

                return new int[] {map.get(sub), x};

            } else {

                map.put(left, x);

            }

        }

        return null;
    }

    public List<List<Integer>> twoSum2(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        int small = 0;
        int big = nums.length - 1;

        while (small < big) {

            int sum = nums[small] + nums[big];

            if (sum == target) {

                answer.add(List.of(nums[small], nums[big]));
                big--;

                while (big > small && nums[big] == nums[big + 1]) {
                    big--;
                }
            } else if (sum < target) {

                small++;

            } else {

                big++;

            }
        }

        return answer;
    }
}
