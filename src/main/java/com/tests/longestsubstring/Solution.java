package com.tests.longestsubstring;

import java.util.Iterator;
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
        int length = theString.length();
        Map<Character, Integer> map = new LinkedHashMap<>(length < 3 ? length + 1 : (int) ((float) length / 0.75F + 1.0F));

        for (int x = 0; x < chars.length; x++) {
            char c = chars[x];

            System.out.println(map);
            Integer i = map.get(c);
            if (i != null) {

                if (map.size() - 1 == 0) {
                    map.clear();
                    map.put(c, x);
                } else  {
                    Iterator<Character> iterator = map.keySet().iterator();

                    while (iterator.hasNext() && iterator.next() != c) {
                        iterator.remove();
                    }

                    if (iterator.hasNext()) {
                        iterator.remove();
                    }

                    map.put(c, x);
                }

            } else {
                map.put(c, x);
            }

            if (map.size() > longest) {
                longest = map.size();
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
