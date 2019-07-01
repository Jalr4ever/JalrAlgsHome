package common;

class HeapSort {

    private static int temp_num = -1;

    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 6, 7, 4, 9, 8, 10, 1 };
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    public static void heapSort(int[] arr) {
        int length = arr.length - 1;
        swim(arr, length);
        sink(arr, length);

    }

    private static void swim(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
    }

    private static void sink(int[] arr, int len) {
        for (int i = len; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i - 1);
        }
    }

    private static void adjustHeap(int[] arr, int k, int len) {
        
        temp_num = arr[k];

        for (int i = 2 * k; i <= len && len != 0; i = i * 2) {
            if (i < len && arr[i] < arr[i + 1]) {
                i++;
            }

            if (temp_num > arr[i]) {
                break;
            } else {
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = temp_num;
        temp_num = -1;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}