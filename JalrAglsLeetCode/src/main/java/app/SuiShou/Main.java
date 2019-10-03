package main.java.app.SuiShou;

/**
 * @program: JalrAlgsBin
 * @description: 随手科技的两道测试题
 * <p>
 * Created by jalr4ever on 2019/9/12.
 */
class MainI {
    public static void main(String[] args) {
        String s = "<xml><if test=\"flag>=1\">aaa&gt;&lt;bbb</if></xml> ";
        search(s, "if", "test");
    }

    /**
     * 接收一个 XML 格式的字符串，进行相应的字符替换
     *
     * @param str       XML 格式的字符串
     * @param tag       XML 指定的标签
     * @param attribute XML 指定的属性
     */
    private static void search(String str, String tag, String attribute) {
        String pattern = tag + " " + attribute;
        StringBuilder s = new StringBuilder(str);
        int p1 = s.indexOf(pattern);
        int p2 = s.indexOf("\"", p1);
        int p3 = s.indexOf("\"", p2 + 1);
        while (p1 < s.length() && p2 < s.length() && p3 < s.length()) {
            for (int i = p1; i < p3; i++) {
                if (s.charAt(i) == '>') {
                    s.setCharAt(i + 1, '&');
                    s.insert(i + 2, 'l');
                    s.insert(i + 2, 't');
                } else if (s.charAt(i) == '<') {
                    s.setCharAt(i, '&');
                    s.insert(i + 2, 'r');
                    s.insert(i + 3, 't');
                }
            }

            p1 = s.indexOf(pattern, p1 + 1);
            if (p1 == -1) {
                break;
            }
            p2 = s.indexOf("\"", p1);
            p3 = s.indexOf("\"", p2 + 1);
        }
        System.out.println(s.toString());
    }
}


class MainII {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 对指定的树翻转
     *
     * @param root
     */
    public void change(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        change(root.left);
        change(root.left);
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}