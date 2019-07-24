package jianzhi;


import java.util.Stack;

/**
 * 栈的压入弹出序列, 入了就弹出，入栈一段，弹出一段
 * 
 * 1,2,3,4,5 -- 4,5,3,2,1 -- 4,3,5,1,2
 */
class Solution {
    public static void main(String[] args) {
        int[] a1 = { 1, 2, 3, 4, 5 };
        int[] a2 = { 4, 3, 5, 1, 2 };
        System.out.println(new Solution().IsPopOrder(a1, a2));

    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int p1 = pushA.length - 1;
        int p2 = 0;
        Stack<Integer> stack = new Stack<>();
        while (p2 < popA.length) {
            if (pushA[p1] == popA[p2]) { // 对应入了就弹
                p1--;
                p2++;
            } else if (!stack.isEmpty() && stack.peek() == pushA[p1]) { // 对应入一段再弹出
                stack.pop();
                p1--;
            } else {
                stack.push(popA[p2++]);
            }
        }
        return stack.isEmpty();
    }
}