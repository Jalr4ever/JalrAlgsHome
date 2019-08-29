package main.java.leetcode.leetcode_me;

import java.util.HashMap;

/**
 * @program: JalrAlgsBin
 * @description: 209 - 单词规律
 * <p>
 * Created by jalr on 2019/8/24.
 */

class leetcode_290 {
    public boolean wordPattern(String patterns, String str) {
        char[] pattern = patterns.toCharArray();
        String[] words = str.split(" ");
        if (pattern.length != words.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length; i++) {
            char curKey = pattern[i];
            if (!map.containsKey(curKey)) {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(curKey, words[i]);
            } else {
                String old = map.get(curKey);
                boolean isSame = old.equals(words[i]);
                if (!isSame) {
                    return false;
                }
            }
        }
        return true;
    }
}
