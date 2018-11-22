package code.Pt4;

import javax.xml.transform.Result;

/**
 * @program: JalrAglsHome
 * @description: Work for job scheduling.
 * <p>
 * Created by Jalr on 2018/11/18.
 */
public class AlgsAssignmnetPt4 {
    private static final int AVAIL = -1;           //机器可用
    private static final int UNAVAIL = -2;    //机器不可用
    public static int time;                      //作业需要的时间
    private static int n;                           //作业个数
    private static int m;                         //机器个数
    private static int[] timeNeed ;         //每个作业所需的时间
    private static  int[][] machine;    //机器，两个域，第一行为可用标记, 第二行为机器运行时间数
    private static int nextJob = 0;                             //指向第一个未使用过的 timeNeed索引
//    static int nextMachine = 0;                    //指向可用的 Machine索引

    public static int machineWork(){
        boolean check_all = false;
        int result = 0;

        Sort(timeNeed);//完成从大到小的排序

        initMachine();//可用数都为 UNAVAIL

        while(true){
            while(true){
                int machine_avail = checkMachine();
                if(machine_avail != UNAVAIL && machine_avail !=AVAIL && nextJob < n){ //需要的是可用的索引
                    machine[0][machine_avail] = UNAVAIL;
                    machine[1][machine_avail] = timeNeed[nextJob];
                    nextJob++;
                }
                if(machine_avail == UNAVAIL || nextJob >=n ){
                    break;
                }
            }
            for(int i = 0; i < m; i++){
                if(machine[0][i] == UNAVAIL){ //不可用，代表已经存在作业值
                    machine[1][i]--;
                    if(machine[1][i] == 0){
                        machine[0][i] = AVAIL;
                    }
                }
                for(int k = 0; k < machine[0].length; k++){
                    System.out.print(machine[1][k]+"   ");
                }
                System.out.println();
            }
            result++;
            if(nextJob == n){ //作业全部分配完 & 每个作业都完成了
                for(int k = 0; k < machine[0].length; k++){
                    if(machine[0][k] == AVAIL){
                        check_all = true;
                    }
                    else {
                        check_all = false;
                        break;
                    }
                }
                if (check_all){
                    break;
                }
            }
        }
        return result;
    }

    private static int checkMachine(){
        int result = UNAVAIL;
        for(int i = 0; i < machine[0].length; i++){
            if(machine[0][i] == AVAIL){
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * 对 machine 的第一个域初始化，就是第一行赋值为 AVAIL
     */
    private static void initMachine() {
        nextJob = 0;//指针指向第一个元素
        for (int i = 0; i < machine[0].length; i++){
            machine[0][i] = AVAIL;
        }
    }

    /**
     * 对 timeNeed 数组从大到小排序 - 基于冒泡排序
     * @param timeNeed
     */
    private static void Sort(int[] timeNeed) {
        for(int i = 0; i < timeNeed.length; i++){
            for (int j = 0; j < timeNeed.length-i; j++){
                if(j == timeNeed.length-1){
                    break;
                }
                if(timeNeed[j] < timeNeed[j+1]){
                    Switch(timeNeed, j, j+1);
                }
            }
        }
    }

    private static void Switch(int[] timeNeed, int left, int right) {
        int t = timeNeed[left];
        timeNeed[left] = timeNeed[right];
        timeNeed[right] = t;
    }

    public static void main(String[] args) {
        /**
         * 时间：{ 7, 5, 3, 3, 2 }
         * 机器：{ m1, m2, m3 }
         * 预期结果：7
         */
        n = 5;
        m = 3;
        timeNeed = new int[n];
        machine = new int[2][m];
        timeNeed[0] = 7;
        timeNeed[1] = 5;
        timeNeed[2] = 3;
        timeNeed[3] = 3;
        timeNeed[4] = 2;
        int result =  machineWork();
        System.out.println("No.1 Time: "+result);

        /**
         * 时间 { 2，14，4，16，6，5，3}
         * 机器 { m1, m2, m3 }
         * 预期结果：17
         */
        n = 7;
        m = 3;
        timeNeed = new int[n];
        machine = new int[2][m];
        timeNeed[0] = 2;
        timeNeed[1] = 14;
        timeNeed[2] = 4;
        timeNeed[3] = 16;
        timeNeed[4] = 6;
        timeNeed[5] = 5;
        timeNeed[6] = 3;
        result = machineWork();
        System.out.println("No.2 Time: "+result);
    }
}
