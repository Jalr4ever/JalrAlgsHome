package common;

/**
 * 下划线转驼峰书写
 */
class underlineToHump {
    public static void main(String[] args) {
        String S = "udeder_line_is_ok_p";
        System.err.println(underlineToCamel(S));
    }

    public static String underlineToCamel(String param) {
        char Underline = '_';

        if (param == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char[] res = param.toCharArray();
        boolean isFirst = true;
        for (int i = 0; i < res.length; i++) {
            char val = param.charAt(i);
            if (isFirst) {
                result.append(Character.toUpperCase(val));
                isFirst = false;
            } else if (val == Underline) {
                isFirst = true;
            } else {
                result.append(Character.toLowerCase(val));
            }
        }

        return result.toString();
    }
}