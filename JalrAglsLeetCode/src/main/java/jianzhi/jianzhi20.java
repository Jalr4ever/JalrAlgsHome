package jianzhi;

import java.util.Stack;

public class jianzhi20 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();

        int p1 = 0;
        int p2 = 0;

        while ((p1 < pushA.length) && (p2 < popA.length)) {
            if (pushA[p1] != popA[p2]) {
                stack.push(pushA[p1++]);
            } else {
                stack.push(pushA[p1++]);
                while (!stack.isEmpty()) {
                    if (stack.peek() == popA[p2]) {
                        stack.pop();
                        p2++;
                    } else {
                        break;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}