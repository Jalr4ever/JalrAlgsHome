package code.Pt2;

/**
 * @program: jalralgs4me
 * @description: Assignment for second assignment
 * <p>
 * Created by Jalr on 2018/10/15.
 */
public class AlgsAssignmentPt2 {

    /**
     * @param c     容量
     * @param w     权值
     * @param v     价值
     * @param x     选择数目
     */
    public static void knapsack(float c, float w[], float v[], float x[]){
            float opt=0;
            int i;
            int n=v.length;//价值数组长度就是货物种类
            Sort(n, v, w);
            for(i = 0; i < n; i++){//初始化
                x[i]=0;
            }
            for (i = 0; i < n; i++){
                if(w[i]>c)//由于已经有序, 则发现第i个数的种类大于容量时, 已经无法存了
                    break;
                x[i]=1;//选中
                c=c-w[i];//剩余容量
            }
        if(i < n){//不够减时，取小数部分
            x[i]=c/w[i];
        }
    }

    /**
     * 对权值数组，权重（单位重量的价值）从大到小排序
     * 临时数组每一行中每一行是(value/weight), value, weight
     *  @param n
     * @param v
     * @param w
     */
    public static void Sort(int n, float v[], float w[]){

        float[][] temp=new  float[n][3];
        for(int i = 0; i < n; i++){
                temp[i][0]=v[i]/w[i];
                temp[i][1]=v[i];
                temp[i][2]=w[i];
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-i; j++){
                if((j+1) < n){
                    if (temp[j][0] < temp[j+1][0]){
                        swapII(temp, j, j+1,0);
                        swapII(temp, j, j+1,1);
                        swapII(temp, j, j+1,2);
                    }
                }
            }
        }

        for(int i = 0; i < temp.length; i++){//测试整理后的权值二维数组
            System.out.println(temp[i][0]+"---"+temp[i][1]+"---"+temp[i][2]);
        }

        for(int i = 0; i < temp.length; i++){
            v[i]=temp[i][1];
            w[i]=temp[i][2];
        }
    }

    /**
     *  交换二维数组的某一行某一个数
     * @param left
     * @param right
     * @param index
     */

    public static void swapII(float[][] a, int left, int right, int index ){
        float temp=a[left][index];
        a[left][index]=a[right][index];
        a[right][index]=temp;
    }

    /**
     *  交换一维数组某一行的数
     * @param a
     * @param left
     * @param right
     */

    public static void swap(float a[], int left,int right){
        float temp;
        temp=a[right];
        a[right]=a[left];
        a[left]=temp;
    }

// TODO: 2018/10/18 三个数组对应有映射关系如何排序？  ---最后使用二维数组，每一行有三列解决了
    public static void main(String[] args) {
        float maxVal=0;
        float[] weight={2, 3, 5, 7, 1, 4, 1 };
        float[] value={10, 5, 15, 7, 6, 18, 3};
        float capacity=15f;//15 kg
        float[] x=new float[7];//七个权重，写7
        knapsack(capacity, weight, value, x);
        for(int i = 0;  i < 7; i++){
            maxVal=maxVal+x[i]*value[i];
        }
        System.out.println("Max value reslut:  "+maxVal);
    }
}

