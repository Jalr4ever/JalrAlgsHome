package common.NoneRecursive;

class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 6, 7, 4, 9, 8, 10, 1 };
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int len = arr.length;
        boolean isSorted = false;
        for (int i = 0; i < len - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}