package main.java.app.DiDi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @program: JalrAlgsForDiDi
 * @description: Created by jalr on 2019/8/27.
 */

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        printMax(str[0], str[1]);
    }
    private static void printMax(String s1, String s2){
        if (s1.equals(s2)){
            System.out.println("1");
            return;
        }
        if (s2.length() > s1.length()){
            System.out.println("0");
            return;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int p1 = arr1.length - 1;
        int p2 = arr2.length - 1;
        int res = 0;
        while (p1 >= 0 && p2 >= 0) {
            if (arr1[p1] == arr2[p2]) {
                p1--;
                p2--;
            } else {
                p1--;
            }
            if (p2 < 0) {
                res = p1 + 2;
            }
        }
        System.out.println(res);
    }
}


