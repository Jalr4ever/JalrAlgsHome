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
class AddTwo {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ltemp1 = l1;
            ListNode ltemp2 = l2;
            int count_l1 = 0;
            int count_l2 = 0;
            int length;
            while (ltemp1 !=null){
                count_l1++;
                ltemp1 = ltemp1.next;
            }
            while (ltemp2 != null){
                count_l2++;
                ltemp2 = ltemp2.next;
            }
            if(count_l1 > count_l2){
                length = count_l1;
            }
            else {
                length = count_l2;
            }
            if(length == 1){
                if(l1.val + l2.val >= 10 ){
                    length = 2;
                }
            }
            int mod_val;
            boolean mod_flag=false;
            int[] val_container=new int [length];
            for( int i = 0; i < length; i++){
                if (i < count_l1 && i < count_l2){
                    mod_val = (l1.val+l2.val) % 10;
                    if (mod_val >= 0 && (l1.val+l2.val) >= 10 ){
                        val_container[i]=mod_val;
                        if (mod_flag == true){
                            val_container[i]++;
                            mod_flag=false;
                        }
                        mod_flag=true;
                    }
                    else {
                        if (mod_flag == true){
                            val_container[i]=l1.val+l2.val+1;
                            mod_flag=false;
                            continue;
                        }
                        val_container[i]=l1.val+l2.val;
                    }
                    l1=l1.next;
                    l2=l2.next;
                }
                else if( i <= count_l1 && i >= count_l2){
                    if((count_l1==1) &&  (count_l2==1)){
                        val_container[i]++;
                        break;
                    }
                    val_container[i] = l1.val;
                    if(mod_flag == true){
                        val_container[i]++;
                    }
                    l1 = l1.next;
                }
                else if(i >= count_l1 && i <= count_l2 ){
                    val_container[i]=l2.val;
                    l2=l2.next;
                }
            }
        for (int t : val_container
             ) {
            System.out.print(t+"      ");
        }
            ListNode[] temp_list_container=new ListNode[length];
            for (int j = 0; j < length; j++){
                temp_list_container[j]=new ListNode(val_container[j]);
            }
            for (int j = 0; j < length; j++){
                if (j+1 == length)
                    break;//越界
                temp_list_container[j].next=temp_list_container[j+1];
            }
            return temp_list_container[0];//链接好的结点
    }

    public static void main(String[] args) {
//    ListNode n1=new ListNode(2);
//    ListNode n2=new ListNode(4);
//    ListNode n3=new ListNode(3);
//
//    ListNode n4=new ListNode(5);
//    ListNode n5=new ListNode(6);
//    ListNode n6=new ListNode(4);
//
//    n1.next=n2;
//    n2.next=n3;
//
//    n4.next=n5;
//    n5.next=n6;
//        ListNode n1=new ListNode(5);
//        ListNode n4=new ListNode(5);
//        ListNode result=addTwoNumbers(n1, n4);
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(8);
//        ListNode n3 = new ListNode(0);
//        n1.next=n2;
//        ListNode result = addTwoNumbers(n1, n3);
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(9);
        ListNode n3=new ListNode(9);
        n2.next=n3;
        ListNode result=addTwoNumbers(n1, n2);
    }
}
