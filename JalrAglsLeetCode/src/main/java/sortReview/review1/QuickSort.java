package main.java.sortReview.review1;

class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 2, 6, 5, 3, 4, 8, 7, 9, 1, 10};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    private static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        return i;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}