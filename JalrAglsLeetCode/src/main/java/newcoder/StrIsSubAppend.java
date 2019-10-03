package main.java.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @pro gram: JalrAlgsBin
 * @description: 字符串是否是由子串拼接 - 招商银行信用卡中心 2018 秋招第一道
 * <p>
 * Created by jalr on 2019/9/13.
 */
class StrIsSubAppend {
    public static void main(String[] ars) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        char[] arr = str.toCharArray();
        String res = "";
        for (int i = 0; i < arr.length / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j <= i) {
                sb.append(arr[j++]);
            }
            String sub = sb.toString(); //最长子串
            while (sb.length() < str.length()) {
                sb.append(sub);
            }
            String after = sb.toString();
            if (after.equals(str) && sub.length() > res.length()) {
                res = sub;
            }
        }
        System.out.println(res.equals("") ? false : res);
    }
}
