package main.java.app.Tcent;

import sun.reflect.generics.tree.Tree;

import javax.print.attribute.standard.NumberUp;
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @program: JalrAlgsBin
 * @description: tencent
 * <p>
 * Created by jalr on 2019/9/20.
 */
class MainIIIII {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] nms1 = new long[n];
        long[] nms2 = new long[n];
        String[] s1 = bf.readLine().split(" ");
        String[] s2 = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nms1[i] = Long.parseLong(s1[i]);
            nms2[i] = Long.parseLong(s2[i]);
        }
        long[][] nums = new long[n][n];

        for (int i = 0; i < n; i++) {
            long n1 = nms1[i];
            for (int j = 0; j < n; j++) {
                nums[i][j] = n1 + nms2[j];
            }
        }
        solution(nums, n);
    }

    private static void solution(long[][] arr, int n) {
        int p1 = 0;
        int p2 = 0;
        long result = arr[p1][p2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (p1 == i && p2 == j) {
                    continue;
                }
                result ^= arr[i][j];
            }
        }
        System.out.println(result);
    }
}


class MainTemp {
    public static void main(String[] args) {
        PriorityQueue<Integer> m = new PriorityQueue<>();
        for (int i = 0; i < 5; i++) {
            m.offer(0);
        }
        System.out.println(m);
    }
}

class MainIIII {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int k = Integer.parseInt(str1[1]);
        int[] nums = new int[n];
        String[] str2 = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str2[i]);
        }
    }

    private static void solution(int n, int k, int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
        }
        int update = 0;
        while (k > 0) {
            int min = 0;
            while (!minHeap.isEmpty()) {
                if (minHeap.peek() == 0) {
                    minHeap.poll();
                    continue;
                }
                min = minHeap.poll();
            }
            update += min;
            System.out.println(min);
            minHeap.offer(0);
            k--;
        }
    }
}

class MainIII{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(bf.readLine());
            String[] str = bf.readLine().split(" ");
            long[] nums = new long[count];
            for (int j = 0; j < count; j++) {
                nums[j] = Long.parseLong(str[j]);
            }
            Arrays.sort(nums);
            solution(nums);
        }
    }
    private static void solution(long[] arr) {
        int p2 = (arr.length / 2) - 1;
        long left  = 0;
        long right = 0;
        for (int i = 0; i < p2; i++) {
            left += arr[i];
        }
        for (int i = p2; i < arr.length; i++) {
            right += arr[i];
        }
        System.out.println(left+" "+right);
    }
}


class MainII {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<Long, Integer> map = new HashMap<>();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] str = bf.readLine().split(" ");
            int count = Integer.parseInt(str[0]);
            long relay = Long.parseLong(str[1]);
            list.add(relay);
            map.put(relay, count);
        }
        Collections.sort(list);
        solution(map, list);
    }

    private static void solution(Map<Long, Integer> map, List<Long> list) {
        long max = Long.MIN_VALUE;
        int p1 = 0;
        int p2 = list.size() - 1;
        while (p1 <= p2) {
            long vl = list.get(p1);
            long v2 = list.get(p2);
            int t1 = map.get(vl);
            int t2 = map.get(v2);
            if (t1 == 0) {
                p1++;
                continue;
            }
            if (t2 == 0) {
                p2--;
                continue;
            }
            max = Math.max((vl + v2), max);
            map.put(vl, --t1);
            map.put(v2, --t2);
        }
        System.out.println(max);
    }
}


class MainI {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(bf.readLine());
            String str = bf.readLine();
            judge(len, str);
        }
    }

    private static void judge(int len, String str) {
        if (len < 11) {
            System.out.println("NO");
            return;
        }
        int p = 0;
        while (p < str.length()) {
            if (str.charAt(p) == '8' && str.length() - p >= 11) {
                System.out.println("YES");
                return;
            }
            p++;
            if (str.length() - p < 11) {
                System.out.println("NO");
                return;
            }
        }

    }
}
