import java.util.StringTokenizer;

class Solution {

    public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.startsWith(" ")) {
                sb.append(str);
                continue;
            }
            if (isStartWithNumber(str)) {
                sb.append(str.charAt(0));
            } else if (isStartWithLowerAlpha(str)) {
                sb.append((char)(str.charAt(0) - 32));
            } else{
                sb.append(str.charAt(0));
            }
            sb.append(str.substring(1).toLowerCase());
        }

        return sb.toString();
    }

    private static boolean isStartWithLowerAlpha(String str) {
        return str.charAt(0) >= 'a' && str.charAt(0) <= 'z';
    }

    private static boolean isStartWithNumber(String str) {
        return str.charAt(0) >= '0' && str.charAt(0) <= '9';
    }

}