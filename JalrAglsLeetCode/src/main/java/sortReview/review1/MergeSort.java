package common.NoneRecursive;

class MergeSort {
    
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 6, 7, 4, 9, 8, 10, 1 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }



    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p3 = 0;
        while (p1 <= mid && p2 <= right) {
            help[p3++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[p3++] = arr[p1++];
        }

        while (p2 <= right) {
            help[p3++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
}