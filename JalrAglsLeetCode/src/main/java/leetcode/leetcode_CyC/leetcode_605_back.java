package leetcode.leetcode_CyC;

class Solution605Back {

    public static void main(String[] args) {
        int[] flowerbed = { 0, 0, 1, 0, 0 };
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int surplus = n;

        for (int i = 0; i < flowerbed.length; i++) {
            
        }

        return surplus == 0;
    }



    public static boolean enablePlant(int[] flowerbed, int pos) {

        if (flowerbed.length == 1 && flowerbed[pos] == 0) {
            return true;
        }

        if(flowerbed.length == 2)

        // 对应三种情况，左边界，中间，有边界
        if (flowerbed.length < 3) {
            return false;
        }

        if (pos == 0) { // 左边界
            if (flowerbed[pos] == 0 && flowerbed[pos + 1] == 0) {
                return true;
            }
        } else if (pos == flowerbed.length - 1) {
            if (flowerbed[pos] == 0 && flowerbed[pos - 1] == 0) {
                return true;
            }
        } else {
            if (flowerbed[pos] == 0 && flowerbed[pos - 1] == 0 && flowerbed[pos + 1] == 0) {
                return true;
            }
        }

        return false;
    }
}
