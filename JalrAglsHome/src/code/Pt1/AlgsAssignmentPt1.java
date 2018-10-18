package code.Pt1;

import org.omg.CORBA.IRObject;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: jalralgs4me
 * @description: The first AlgsAssigment.
 * <p>
 * Created by Jalr on 2018/10/14.
 */
class AlgsAssignmentPt1 {


    public static int asgn_one_1(int a[], int x, AtomicInteger i, AtomicInteger j){//

        int left=0, right=a.length-1, mid=(left+right)/2;
        if(a.length==0) {
            System.out.println("ERROR-Empty array !");
        }
        else {
            while (left <= right){
                if(x > a[mid]){
                    left=mid+1;//在右区间
                    mid=(left+right)/2;
                }
                else if(x < a[mid]){
                    right=mid-1;//在左区间
                    mid=(left+right)/2;
                }
                else{
                    i.set(mid+1);
                    j.set(mid+1);
                    System.out.println("x element max and min index equals "+(mid+1));
                    return  mid+1;//表示已经找到跳出循环, 返回位置，不是数组位置
                }
            }
        }
        if(left>right){//矫正
            if((right+2)<a.length)
            right=right+2;
            else{
                System.out.println("Out of array boundary !");
                return -1;//数组越界
            }
        }
        System.out.println("The min is "+left+" \n "+"The max is "+right);
        i.set(right);
        j.set(left);
        System.out.println("Element not found!");
        return -1;
    }

    public static void main(String[] args) {
        AtomicInteger i=new AtomicInteger(0);
        AtomicInteger j=new AtomicInteger(0);

        int[] a={2, 6, 7, 10, 13, 15, 19, 21, 32, 41};
        System.out.println(asgn_one_1(a, 13, i, j));
        System.out.println("Test integer val:  "+i+"   "+j);
    }
}
