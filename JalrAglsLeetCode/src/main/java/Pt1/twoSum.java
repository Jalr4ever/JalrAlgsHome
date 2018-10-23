package Pt1;

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
}
