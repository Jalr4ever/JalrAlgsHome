package common;

/**
 * rand() 问题
 */
class randDemo {
    public static void main(String[] args) {
        int i = 0;
        while (i < 100) {
            i++;
            System.out.print(rand7());
            if (i % 5 == 0) {
                System.out.println("");
            }
        }
    }

    public static int rand5() {
        int r = 5;
        return (int) ((r) * Math.random() + 1);// 范围 [1, r+1)，也就是 [1, r]
    }

    public static int rand7() {
        int res = 0;
        while (true) {
            res = rand5() * 4 + rand5();
            if (res <= 21) {
                break;
            }
        }
        return (res % 7) + 1;
    }

}