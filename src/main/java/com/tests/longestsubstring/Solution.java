package com.tests.longestsubstring;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring2(String theString) {
        if (theString.isEmpty()) {
            return 0;
        }

        if (theString.isBlank() || theString.length() == 1) {
            return 1;
        }

        int longest = 0;
        char[] chars = theString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int x = 0; x < chars.length; x++) {
            char c = chars[x];

            int i = stringBuilder.indexOf(c + "");
            if (i != -1) {

                if (stringBuilder.length() - 1 == i) {
                    stringBuilder.setLength(0);
                    stringBuilder.append(c);
                } else  {
                    String toSet = stringBuilder.substring(i + 1, stringBuilder.length());
                    stringBuilder.setLength(0);
                    stringBuilder.append(toSet).append(c);
                }

            } else {
                stringBuilder.append(c);
            }

            if (stringBuilder.length() > longest) {
                longest = stringBuilder.length();
            }
        }

        return longest;
    }

    /**
     * Given a string, find the length of the longest substring
     * without repeating characters.
     */
    public int lengthOfLongestSubstring(String theString) {
        if (theString.isEmpty()) {
            return 0;
        }

        if (theString.isBlank()) {
            return 1;
        }

        if (theString.length() == 1) {
            return 1;
        }

        int longest = 0;
        int count = 0;
        char[] chars = theString.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int x = 0; x < chars.length; x++) {
            Character c = chars[x];

            if (map.containsKey(c)) {
                Integer oldIdx = map.get(c);
                map.put(c, x);

                count = x - oldIdx;
            } else {
                map.put(c, x);
                count++;
            }

            if (count > longest) {
                longest = count;
            }
        }

        return longest;
    }


    public static void main(String[] args) {
        Solution longestSubstring = new Solution();

        System.out.println(longestSubstring.lengthOfLongestSubstring2("abcabcbb")); // 3
        System.out.println(longestSubstring.lengthOfLongestSubstring2("bbbbb")); // 1
        System.out.println(longestSubstring.lengthOfLongestSubstring2("pwwkew")); // 3
        System.out.println(longestSubstring.lengthOfLongestSubstring2("au")); // 2
        System.out.println(longestSubstring.lengthOfLongestSubstring2("abba")); // 2
        System.out.println(longestSubstring.lengthOfLongestSubstring2("aab")); // 2
    }
}
