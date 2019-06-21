package leetcode.leetcode_old;

class Solution {
    public static void main(String[] args) {
        System.out.println(5555);
    }
    public boolean validPalindrome(String s) {
            int p1 = 0;
            int p2 = s.length() - 1;
            boolean result_i = false;
            boolean result_ii = false;
    
            // not delete yet
            while (p1 < p2) {
                if (s.charAt(p1) == s.charAt(p2)) {
                    p1++;
                    p2--;
                } else {
                    break;
                }
            }
        
            if(s.charAt(p1) == s.charAt(p2)){
                return true;
            }
    
            // delete, need to classify
            if ((p1+1) < s.length() && s.charAt(p1 + 1) == s.charAt(p2)) {
                result_i = classify(p1 + 1, p2, s);
            }
    
            if ((p2-1) > 0 && s.charAt(p1) == s.charAt(p2 - 1)) {
                result_ii = classify(p1, p2 - 1, s);
            }
    
            return (result_i || result_ii);
        }
    
        public static boolean classify(int p1, int p2, String s) {
            while (p1 < p2) {
                if (s.charAt(p1) == s.charAt(p2)) {
                    p1++;
                    p2--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }