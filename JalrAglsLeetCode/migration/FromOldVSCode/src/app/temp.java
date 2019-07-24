package app;

import java.util.Arrays;
import java.util.Scanner;

class temp {

}

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int [count];
        String s = sc.nextLine();
        int i = 0;
        while(sc.hasNext()){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1] - arr[1]);
    }
}