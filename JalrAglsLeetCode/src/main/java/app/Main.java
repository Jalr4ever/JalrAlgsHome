package main.java.app;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Main {
    private static List<List<Character>> res = new ArrayList<>();
    private static Stack<Character> path = new Stack<>();

    private static void sub(char[] chars, int curSize, int len) {
        if (curSize == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        sub(chars, curSize + 1, len); //选择不加
        path.push(chars[curSize]);
        sub(chars, curSize + 1, len); //选择加
        path.pop(); //状态重置

    }

    public static void main(String[] args) {
        String S = "abc";
        sub(S.toCharArray(), 0, S.length());
        for (List<Character> r : res) {
            System.out.println(r);
        }
        new ArrayList<>(new PriorityQueue<>());
    }
}

class Solution {

}

class SolutionII {

    // curSize 表示当前的路径 path 里面有多少个元素
    private Stack<Integer> path = new Stack<>();
    private List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;


    private void generatePermution(int[] nums, int curSize, int len) {
        if (curSize == len) {
            // 此时 path 已经保存了 nums 中的所有数字，已经成为了一个排列
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, curSize + 1, len);
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                path.pop();
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        visited = new boolean[len];
        generatePermution(nums, 0, len);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        SolutionII solution = new SolutionII();
        List<List<Integer>> permute = solution.permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
}
