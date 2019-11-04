package main.java.leetcode.leetcode_category_top_ten.bfs;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * @program: JalrAlgsBin
 * @description: 01 矩阵
 * <p>
 * Created by jalr on 2019/10/22.
 */
class leetcode_542 {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] distance = new int[n][m];
        LinkedList<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] status = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //neighborhood
        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();
            int x = (Integer) curPair.getKey();
            int y = (Integer) curPair.getValue();
            for (int i = 0; i < status.length; i++) { // try 4 status neighbor
                int neiX = x + status[i][0];
                int neiY = y + status[i][1];
                if (neiX >= 0 && neiX < n && neiY >= 0 && neiY < m) {
                    if (distance[neiX][neiY] > distance[x][y] + 1) {
                        distance[neiX][neiY] = distance[x][y] + 1;
                        queue.offer(new Pair(neiX, neiY));
                    }
                }
            }
        }
        return distance;
    }
}
