package leetcode.leetcode_CyC;

class Solution392 {

    public static void main(String[] args) {

    }
    /*
     * 在查找对应的索引的字符底层还是暴力搜索，但快的原因是找不到字符的情况下，不用匹配到底 时间复杂度 O(n), 慢的原因在于不存在的字符没有提前终止
     */

    /**
     * 索引匹配
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequenceII(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) { // 遍历 s 中的每个字符
            index = t.indexOf(c, index + 1); // 从 0 位置开始查找
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针
     * 
     * @param s - 子串
     * @param t - 全串
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }

        return p1 == s.length() ? true : false;
    }
}