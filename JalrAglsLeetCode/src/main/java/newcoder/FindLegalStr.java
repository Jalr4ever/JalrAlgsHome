package main.java.newcoder;

/**
 * @program: JalrAlgsBin
 * @description: 牛客 - 寻找合法字符串
 * <p>
 * Created by jalr on 2019/9/14.
 */

import java.util.*;
import java.io.*;

class FindLegalStr {
    private static ArrayList<String> paths = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        solution(n, "", n, n);
        StringBuilder sb = new StringBuilder();
        for (String s : paths) {
            sb.append(s).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static void solution(int n, String cur, int left, int right) {
        if (left == 0 && right == 0) {
            paths.add(cur);
            return;
        }
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        solution(n, cur + "(", left - 1, right);
        solution(n, cur + ")", left, right - 1);
    }
}