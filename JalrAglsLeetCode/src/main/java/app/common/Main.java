package main.java.app.common;

import java.util.*;


class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        int start = 0;
        int end = 0;
        int len;
        for (int i = 0; i < s.length(); i++) {
            int len1 = compute(s, i, i);// 奇数回文扩展
            int len2 = compute(s, i, i + 1);// 偶数回文扩展
            len = Math.max(len1, len2);
            if (len > end - start) { //新的长度大于旧的长度
                start = i - len / 2;
                end = i + (len + 1) / 2;
            }
        }
        System.out.println(start + "--" + end);
        return s.substring(start, end + 1);
    }

    private int compute(String s, int start, int end) {
        int R = 0;
        int L = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            R = end;
            L = start;
            start--;
            end++;
        }
        return R - L;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Solution().longestPalindrome(s));
    }
}