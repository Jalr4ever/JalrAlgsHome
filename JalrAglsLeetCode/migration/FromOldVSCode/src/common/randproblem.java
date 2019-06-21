package common;

class randDemo {
    public static void main(String[] args) {
        rand5();
    }

    public static int rand5() {
        int r = 5;
        System.out.println(rand7());
        return r;
    }

    public static int rand7() {
        int r = 7;
        return (int) ((r + 1) * Math.random()); //范围 [0, r+1)，也就是 [0, r] 
    }
    
}