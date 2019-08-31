package main.java.leetcode.leetcode_me;

import java.util.*;

/**
 * @program: JalrAlgsBin
 * @description: 有效的括号
 * <p>
 * Created by jalr on 2019/9/1.
 */
class leetcode_20 {
    private HashMap<Character, Character> map = new HashMap<>();
    private Stack<Character> stack = new Stack<>();

    private void init() {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        if (s.length() % 2 != 0) { //奇数长度一定不封闭
            return false;
        }
        init();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char key = arr[i];
            if (map.containsKey(key)) {
                stack.push(map.get(key));
            } else {
                if (!stack.isEmpty() && stack.peek() == key) {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
