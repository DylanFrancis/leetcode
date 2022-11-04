package com.tests.besttimetobuyandsellstock;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;

        for (int x = 0; x < prices.length - 1; x++) {

            int buy = prices[x];

            for (int y = x + 1; y < prices.length; y++) {

                int sell = prices[y];

                if (sell <= buy) {

//                    System.out.println("x=" + x + " skip to " + (y - 1));
                    x = y - 1;
                    break;

                } else {

                    int profit = sell - buy;

                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }

                }
            }
        }
        return maxProfit;
    }
}
