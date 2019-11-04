package main.java.leetcode.leetcode_category_top_ten.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JalrAlgsBin
 * @description: 括号生成
 * <p>
 * Created by jalr on 2019/10/6.
 */
class leetcode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> paths = new ArrayList<>();
        generate(n, "", 0, 0, paths);
        return paths;
    }

    private void generate(int n,
                          String path,
                          int llen,
                          int rlen,
                          List<String> paths) {
        if (rlen == n && llen == n) {
            paths.add(path);
            return;
        }
        if (llen < n) { //左括号数量依赖于 n
            generate(n, path + "(", llen + 1, rlen, paths);
        }
        if (rlen < llen) { //右括号数量依赖于左括号数量，要保证不超过左括号的数量
            generate(n, path + ")", llen, rlen + 1, paths);
        }
    }
}