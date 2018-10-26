package main.java.Pt1;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.awt.*;

/**
 * @program: JalrAlgsBin
 * @description: The second problem.
 * <p>
 * Created by Jalr on 2018/10/25.
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isUSE=false;
        ListNode ltemp1 = l1;
        ListNode ltemp2 = l2;
        int count_l1 = 0;
        int count_l2 = 0;
        int length;

        //统计l1 && l2 长度
        while (ltemp1 !=null){
            count_l1++;
            ltemp1 = ltemp1.next;
        }
        while (ltemp2 != null){
            count_l2++;
            ltemp2 = ltemp2.next;
        }

        //设置 l1 && l2 长度
        if(count_l1 > count_l2){
            length = count_l1+1;
        }
        else {
            length = count_l2+1;
        }

        //设置val_container，求val_container
        int[] val_container = new int[length];

        if (count_l1 < count_l2){
            for(int k = 0; k < length-1; k++){
                if(k >= count_l1){
                    val_container[k] = l2.val;
                    l2=l2.next;
                }
                else{
                    val_container[k]=l1.val+l2.val;
                    l1=l1.next;
                    l2=l2.next;
                }
            }
        }

        else if (count_l1 > count_l2){
            for( int k = 0; k < length-1; k++){
                if( k >= count_l2 ){
                    val_container[k]=l1.val;
                    l1=l1.next;
                }
                else{
                    val_container[k]=l1.val+l2.val;
                    l1=l1.next;
                    l2=l2.next;
                }
            }
        }
        else{ //count_l1 == count_l2
            for(int k = 0; k < length-1; k++ ){
                val_container[k] = l1.val+l2.val;
                l1=l1.next;
                l2=l2.next;
            }
        }

        //求矫正过进位的val_container

        for(int k = 0; k < length-1; k++){ //只矫正错误进位
            if( val_container[k] >= 10){
                val_container[k] = val_container[k] % 10;
                val_container[k+1]++;
                if(k+1 == length-1){
                    isUSE=true;
                }
            }
        }

        if(!isUSE){//如果没有进到预留位
            length--;//更新数组长度
        }

        //把val_container转换成单链表链接起来

        //初始化结点
        ListNode[] list_node_container=new ListNode[length];
        for (int k = 0; k < length; k++ ){
            list_node_container[k] = new ListNode(val_container[k]);
        }
        for (int k = 0; k < length; k++){
            if(k+1 == length){//防止越界
                break;
            }
            list_node_container[k].next=list_node_container[k+1];
        }

        return list_node_container[0];//返回头结点
    }
}
