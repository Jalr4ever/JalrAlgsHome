package main.java.leetcode.leetcode_me;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JalrAlgsBin
 * @description: 罗马数字转换成数字
 * <p>
 * Created by jalr on 2019/8/30.
 */
class leetcode_13 {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    private int res = 0;

    private void init(Map<String, Integer> map) {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        init(map);
        //substring() 比较特殊，从 0 开始到 len 而不是 len - 1！
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                String key1 = s.substring(i, i + 2);
                boolean success = convert(key1);
                if (success) {
                    i++;//转换成功下一个不用了
                    continue;
                }
            }
            String key2 = s.substring(i, i + 1);
            convert(key2);
        }
        return res;
    }

    private boolean convert(String key) {
        if (map.containsKey(key)) {
            res += map.get(key);
            return true;
        }
        return false;
    }
}
