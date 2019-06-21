package newcoder.campus_2017_5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

class HuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] a = s.toCharArray();
        sc.close();
        int cnt = 0;

        HashMap<Character, Integer> frequencyCounter = new HashMap<>();
        for (char var : a) {
            frequencyCounter.put(var, frequencyCounter.getOrDefault(var, 0) + 1);
        }

        for (Entry<Character, Integer> entry : frequencyCounter.entrySet()) {
            int val = entry.getValue() % 2;
            if (val != 0) {
                cnt++;
            }
        }

        System.out.println(cnt > 0 ? cnt : 1);
    }
}