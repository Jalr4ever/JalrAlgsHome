package main.java.leetcode.leetcode_me;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JalrAlgsBin
 * @description: 报数
 * <p>
 * Created by jalr on 2019/9/7.
 */

class leetcode_38 {
    private Map<Integer, String> map = new HashMap<>();

    public String countAndSay(int n) {
        int p1 = 1;
        map.put(1, "1");
        while (p1 < n) {
            char[] last = map.get(p1++).toCharArray();
            int p2 = 0;
            int p3 = 0;
            int len = last.length;
            int curCount = 0;
            StringBuilder sb = new StringBuilder();
            while (p2 < len && p3 < len) {
                if (last[p2] == last[p3]) {
                    p3++;
                    curCount++;
                    if (p2 < len && p3 < len) { //最后一次不继续
                        continue;
                    }
                }
                sb.append(String.valueOf(curCount)).append(String.valueOf(last[p2]));
                p2 = p3;
                curCount = 0;
            }
            map.put(p1, sb.toString());
        }
        return map.get(n);
    }
}
