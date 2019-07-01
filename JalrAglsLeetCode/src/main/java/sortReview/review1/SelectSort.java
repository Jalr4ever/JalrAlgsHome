package common.NoneRecursive;

class SelectSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 6, 7, 4, 9, 8, 10, 1 };
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    public static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = len - 1; j > i; j--) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}