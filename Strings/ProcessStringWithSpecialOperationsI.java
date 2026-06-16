public class ProcessStringWithSpecialOperationsI {
    public static void main(String[] args) {
        System.out.println(processStr("a#b%*"));
    }
    public static String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()){
            if (ch >= 'a' && ch <='z'){
                sb.append(ch);
            }
            else if(ch == '*'){
                if (!sb.isEmpty()){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else if (ch == '#'){
                sb.append(sb);
            }
            else if (ch == '%'){
                sb.reverse();
            }
        }

        return sb.toString();
    }
}
