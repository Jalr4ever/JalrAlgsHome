package leetcode.leetcode_me;

class Solution5118 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (n == 0) {
            return null;
        }

        int[] res = new int[n];

        for (int[] arr : bookings) {
            int i = arr[0] - 1;
            int j = arr[1] - 1;
            int val = arr[2];
            for (; i <= j; i++) {
                res[i] += val;
            }
        }

        return res;
    }

}