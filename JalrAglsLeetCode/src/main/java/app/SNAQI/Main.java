package main.java.app.SNAQI;

import sun.reflect.generics.visitor.Visitor;
import sun.swing.plaf.synth.DefaultSynthStyle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: JalrAlgsBin
 * @description: Created by jalr on 2019/9/9.
 */
class MainII {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();
    }

    private static int getRes(String s1, String s2) {
        if (s1.equals("")) {
            return s2.length();
        }
        if (s2.equals("")) {
            return s1.length();
        }
        if (s1.length() == s2.length()) {

        }
        return 0;
    }
}


class MainI {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(result(n));
    }

    private static int result(int n) {
        int res = 1;
        long p1 = 1;
        long p2 = 1;
        long cur = 0;
        while (p1 <= n && p2 <= n) {
            if (cur < n) {
                cur += p2;
                p2++;
            } else if (cur > n) {
                cur -= p1;
                p1++;
            } else {
                res++;
                cur += p2;
                p2++;
            }
        }
        return res;
    }
}

class MainIII {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split("#");
//        for (String s : str) {
//            System.out.println(s.trim());
//        }
//        System.out.println();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String cur = str[i];
            char k = '0';
            char v = '0';
            for (int j = 0; j < cur.length(); j++) {
                char curChar = cur.charAt(j);
                if (Character.isLetter(curChar)) {
                    k = curChar;
                } else if (Character.isDigit(curChar)) {
                    v = curChar;
                }
            }
            map.put(k, v);
        }
        if (map.containsKey('0')) {
            map.remove('0');
        }
        System.out.println(map.size());
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            Character key = entry.getKey();
            Character val = entry.getValue();
            System.out.println(key + " " + val);
        }
    }
}
