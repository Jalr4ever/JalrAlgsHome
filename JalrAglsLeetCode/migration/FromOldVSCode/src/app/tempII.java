package app;


class Solution {
    public int InversePairs(int[] array) {
        return (int) (mergeGet(array, 0, array.length - 1) % 1000000007);
    }

    private long mergeGet(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        return mergeGet(arr, left, mid) + mergeGet(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private long merge(int[] arr, int left, int mid, int right) {
        long res = 0;
        int p1 = left;
        int p2 = mid + 1;
        int p3 = 0;
        int[] help = new int[right - left + 1];
        while (p1 <= mid && p2 <= right) {
            if(arr[p2] < arr[p1]){
                res += (mid - p1 +1);
                help[p3++]=arr[p2++];
            }else{
                help[p3++]=arr[p1++];
            }
        }

        while(p1 <= mid){
            help[p3++] = arr[p1++];
        }

        while(p2 <= right){
            help[p3++]= arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[i+left] = help[i];
        }

        return res;

    }
}

class Te {
    public static void main(String[] args) {
        // int[] num = { 1, 2, 3, 4, 5, 6, 7, 0 };
        int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int res = new Solution().InversePairs(num);
        System.out.println();
    }
}
