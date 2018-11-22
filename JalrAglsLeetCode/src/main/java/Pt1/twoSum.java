package Pt1;

import sun.swing.plaf.synth.DefaultSynthStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JalrAglsLeetCode
 * @description: First problem!
 * <p>
 * Created by Jalr on 2018/10/23.
 */
public class twoSum {
    public static int[] twoSum(int[] num, int target){
        int[] a=new int[2];
        for(int i = 0; i < num.length; i++){
            for(int j = i+1;i < num.length; j++){
                if(j == num.length){
                    break;
                }
                if (num[i]+num[j] == target){
                    a[0]=i;
                    a[1]=j;
                    return a;
                }
            }
        }
        return a;
    }

    public static int[] answer_1(int[] nums, int target ){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //存下键值，值是数组索引，我们要用的值
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
