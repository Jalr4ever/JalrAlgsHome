package common.NoneRecursive;

class InsertSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 6, 7, 4, 9, 8, 10, 1 };
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    public static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
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