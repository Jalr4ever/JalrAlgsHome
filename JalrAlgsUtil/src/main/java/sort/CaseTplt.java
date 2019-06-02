package sort;

import java.util.Arrays;

/**
 * @program: AlgrsUtil
 * @description: Generate testing array, now it's for me to test sort algrs
 * <p>
 * Created by jalr on 2019/6/2.
 */
public class CaseTplt {
    public static int[] generateRandomArrayDyna(int size, int boundary){
        int[] arr = new int[(int)((size+1) * Math.random())];
        for(int i =0; i< arr.length;i++){
            int temp = (int)((boundary+1) * Math.random()); //产生 0 - boundary 的数
            arr[i] = temp;
        }
        printArray(arr);
        return arr;
    }

    public static int[] generateRandomArrayFix(int size, int boundary){
        int[] arr = new int[size];
        for(int i =0; i<arr.length;i++){
            int temp = (int) ((boundary+1) * Math.random());
            arr[i] = temp;
        }
        printArray(arr);
        return arr;
    }

    public static void rawArray(int[] arr) {
        System.out.println("Raw: ");
        printArray(arr);
    }

    public static void rightMethod(int[] arr) {
        int[] a = copyArray(arr);
        Arrays.sort(a);
        System.out.println("Right result: ");
        printArray(a);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
    }

    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
