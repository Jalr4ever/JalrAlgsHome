package main.java.newcoder.programmerguide;

/**
 * @program: JalrAlgsBin
 * @description: 拼接字典序最小字符串
 * <p>
 * Created by jalr on 2019/8/10.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        String[] str = new String[num];
        for (int i = 0; i < num; i++) {
            str[i] = bf.readLine();
        }
        printMin(str);

    }

    private static void printMin(String[] str) {
        if (str.length == 1) {
            System.out.println(str[0]);
        }

        Arrays.sort(str, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder res = new StringBuilder();
        for (String aStr : str) {
            res.append(aStr);
        }
        System.out.println(res.toString());
    }
}
