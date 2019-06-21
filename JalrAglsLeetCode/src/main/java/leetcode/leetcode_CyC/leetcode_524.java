package leetcode.leetcode_CyC;

import java.util.List;

class Solution524 {

    public static void main(String[] args) {

    }

    /**
     * 
     * leetcode-524
     * 比较使用暴力匹配
     * 
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {

        String longestStr = "";

        if (s == null || d.isEmpty()) {
            return "";
        }

        for (String str : d) {
            if (isSubStr(s, str)) {
                if (str.length() > longestStr.length()) {
                    longestStr = str; // 更新最长子串
                } else if (!str.equals(longestStr) && str.length() == longestStr.length()) {
                    for (int i = 0; i < str.length(); i++) {
                        int longestStr_asc = (int) longestStr.charAt(i);
                        int str_asc = (int) str.charAt(i);
                        if (longestStr_asc > str_asc) {
                            longestStr = str;
                            break;
                        } else if (longestStr_asc < str_asc) {
                            break; // 原最长子串字典序依旧是最小的，直接不用比较
                        }
                    }
                }
            }
        }

        return longestStr;
    }

    /**
     * 
     * 判断使用双指针
     * 
     * @param s
     * @param target
     * @return
     */
    private static boolean isSubStr(String s, String target) {
        int p1 = 0;
        int p2 = 0;

        if (s.length() < target.length() || s == null || target == null) {
            return false;
        }

        // aabbccdd
        // bbe
        while (p1 < s.length() && p2 < target.length()) {
            if (s.charAt(p1) == target.charAt(p2)) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }

        return (p2 == target.length()); // 匹配完成
    }
}