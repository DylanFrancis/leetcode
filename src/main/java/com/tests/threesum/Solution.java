package com.tests.threesum;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Solution {

    //  [-1, 0, 1, 2, -1, -4] [-4, -1, -1, 0, 1, 2]
    //  [0, 0, 0]
    public List<List<Integer>> threeSum(int[] nums) {

        if (true) {
            return threeSum4(nums);
        }

//        System.out.println(Arrays.toString(nums));

        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

//        System.out.println(Arrays.toString(nums));

        List<List<Integer>> answer = new ArrayList<>(nums.length / 3);

        for (int x = 0; x < nums.length; x++) {

            int left = nums[x];

            if (left > 0) {
                return answer;
            }

            if (x > 0 && nums[x - 1] == left) {
                continue;
            }

            for (int y = x + 1; y < nums.length; y++) {

                int mid = nums[y];

                if (y > x + 1 && mid == nums[y - 1]) {
                    continue;
                }

                if (left + mid > 0) {
                    break;
                }

                for (int z = y + 1; z < nums.length; z++) {

                    int right = nums[z];

                    if (z > y + 1 && right == nums[z - 1]) {
                        continue;
                    }

                    int sum = left + mid + right;
                    if (sum == 0) {

                        answer.add(Arrays.asList(left, mid, right));

                        break;

                    } else if (sum > 0){

                        break;

                    }

                }

            }

        }



        return answer;
    }

    public List<List<Integer>> threeSum2(int[] nums) {

//        System.out.println(Arrays.toString(nums));

        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        Map<Integer, List<Integer>> map = new HashMap<>();

//        System.out.println(Arrays.toString(nums));

        List<List<Integer>> answer = new ArrayList<>(nums.length / 3);

        for (int x = 0; x < nums.length; x++) {

            int left = nums[x];

            if (left > 0) {
                return answer;
            }

            if (x > 0 && nums[x - 1] == left) {
                continue;
            }

            for (int y = x + 1; y < nums.length; y++) {

                int mid = nums[y];

                if (y > x + 1 && mid == nums[y - 1]) {
                    continue;
                }

                int sum = left + mid;

                if (sum > 0) {
                    break;
                }

                if (map.containsKey(mid * -1)) {

                    List<Integer> l = map.get(mid * -1);
                    l.add(mid);
                    answer.add(l);

                } else {

                    map.put(sum, new LinkedList<>(Arrays.asList(left, mid)));

                }
            }
        }



        return answer;
    }

    public List<List<Integer>> threeSum3(int[] nums) {

        System.out.println(Arrays.toString(nums));

        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        List<List<Integer>> answer = new ArrayList<>(nums.length / 3);

        for (int x = 0; x < nums.length; x++) {

            int left = nums[x];

            if (left > 0) {
                return answer;
            }

            if (x > 0 && nums[x - 1] == left) {
                continue;
            }

            for (int y = nums.length - 1; y > x; y--) {

                int mid = nums[y];

                if (y < nums.length - 1 && mid == nums[y + 1]) continue;

                for (int z = y - 1; z > x; z--) {

                    int right = nums[z];

                    int sum = left + mid + right;

                    if (sum == 0) {

                        answer.add(Arrays.asList(left, right, mid));

                        break;

                    } else if (sum < 0){

                        break;

                    }

                }

            }

        }



        return answer;
    }


    public List<List<Integer>> threeSum4(int[] nums) {

//        System.out.println(Arrays.toString(nums));

        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));

        List<List<Integer>> answer = new ArrayList<>(nums.length / 3);

        for (int x = 0; x < nums.length; x++) {

            int left = nums[x];

            if (left > 0) {
                return answer;
            }

            if (x > 0 && nums[x - 1] == left) {
                continue;
            }

            int small = x + 1;
            int big = nums.length - 1;

            while (small < big) {

                int sum = left + nums[small] + nums[big];

                if (sum == 0) {

                    answer.add(List.of(nums[x], nums[small], nums[big]));

                    big--;

                    while (big > small && nums[big] == nums[big + 1]){
                        big--;
                    }
                }
                else if (sum > 0) {

                    big--;

                } else {

                    small++;

                }

            }
        }



        return answer;
    }
}
