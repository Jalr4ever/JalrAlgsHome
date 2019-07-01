package jianzhi;

public class InversePairsSol {

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        long cnt = mergeSort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
        

    }

    private long mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private long merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int p3 = 0;
        long reverse = 0;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] > arr[p2]) {
                reverse += mid - p1 + 1; // 截至到 p1 到 mid 共有几个
                help[p3++] = arr[p2++];
            } else {
                help[p3++] = arr[p1++];
            }
        }

        while (p1 <= mid) {
            help[p3++] = arr[p1++];
        }

        while (p2 <= r) {
            help[p3++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return reverse;
    }

    // O(n^2) 的解法，时间复杂度过大
    public int InversePairsI(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        int cnt = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    cnt++;
                }
            }
        }

        return cnt % 1000000007;
    }
}