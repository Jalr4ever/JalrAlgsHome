    package main.java.Ptemp;

    /**
     * @program: JalrAlgsBin
     * @description: Holy shit.
     * <p>
     * Created by Jalr on 2018/10/25.
     */
    /**
     *
     * 0.统计链表最大长度，可以使用哈希映射或动态链表，这里不使用，要手动统计
     *
     * 1.确定 val_container的 length，就是两条链表的最大值+1，最后一个位为进位预留位，可不用，用布尔标志isUSE
     *
     * bool isUSE = false;
     *
     * Tips: 可例用对双链来统计非空的结点位置，方便避免越界产生的空指针异常
     *
     * 2.接下来求val_container
     *
     * if ( l1长度 < l2长度 ){
     *
     *     把总和加起来，赋值到val_container
     *
     *     由于在这里已经确定了l2长度大于l1长度，可利用l2长度来做for
     *     for(int k = 0; k < l2_length-1; k++){ //到倒数第二个结点
     *         if( k= l1_length){ //到 l1终点
     *             val_container[k]=l2.val;
     *             更新 l2 , 往下指
     *         }
     *         val_container[k]=l1.val+l2.val;
     *         更新 l1与 l2, 往下指
     *     }
     * }
     *
     * else if ( l1长度 > l2长度 ){
     *     for(int k = 0; k < l1_length-1; k++){
     *         if( k= l2_length){ //到 l1 终点
     *             val_container[k]=l1.val;
     *             更新 l1, 往下指
     *         }
     *         val_container[k]=l1.val+l2.val;
     *         更新 l1与 l2, 往下指
     *     }
     * }
     *
     * else if ( l1长度 = l2长度 ){
     *
     *          把总和加起来，赋值到val_container
     *
     *     for( int k = 0; k < l1_length-1; k++ ){//由于是相等，长度取二者之一即可
     *         val_container[k]=l1.val+l2.val;
     *         更新 l1与 l2, 往下指
     *     }
     *  }
     *
     * 3.到这里，已经得到了val_container数组了，要判断其进位情况，确定最终正确的val，以及新的length
     *
     *  for(int k = 0; k < val_container.length-1; k++){
     *
     *      if ( val_container[k] >= 10 ){   //只更新存在进位的
     *          val_container[k] = val_container[k] % 10;
     *          if (val_container.length)
     *              val_container[k+1]++;
     *          if( (k+1) == val_container.length-1 ){ //说明启用预留位
     *              isUSE=true;
     *          }
     *      }
     * }
     *
     * 4. 求得val_container, 由于always pass by value，需要用结点数组list_node_container，再依次链接，利用isUSE
     * 判断到底是node container到底是length还是length-1
     *
     *
     */
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    class Prefor2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            boolean isUSE=false;
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
                length = count_l1+1;
            }
            else {
                length = count_l2+1;
            }
            if (count_l1 < count_l2){
                for(int k = 0; k < length-1; k++){

                }
            }
            else if (count_l1 > count_l2){

            }
            else{ //count_l1 == count_l2

            }



            return null;
        }

        public static void main(String[] args) {

        }
    }
