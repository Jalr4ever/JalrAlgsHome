package newcoder.campus_2017_5;

import java.util.Scanner;

class OuChuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        sc.close();
        char[] a = S.toCharArray();
        int pStart = 0;
        int pEnd = (a.length - 1 - 2);
        int pMid = pEnd / 2 + 1;
        int cnt = 0;
        StringBuilder before = new StringBuilder();
        StringBuilder after = new StringBuilder();
        while (pMid <= pEnd) {
            if (a[pStart] == a[pMid]) {
                cnt++;
            }
            before.append(a[pStart++]);
            after.append(a[pMid++]);
            if (pMid > pEnd) {
                if (before.toString().equals(after.toString())) {
                    System.out.println(cnt * 2);
                    return;
                } else {
                    before.delete(0, before.length());
                    after.delete(0, after.length());
                    pStart = 0;
                    pEnd = pEnd - 2;
                    pMid = pEnd / 2 + 1;
                    cnt = 0;
                }
            }
        }
        System.out.println(1);
    }
}