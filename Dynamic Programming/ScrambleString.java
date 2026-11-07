import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/scramble-string/
public class ScrambleString {
    static Map<String, Boolean> map = new HashMap<>();

    public static boolean solve(String s1, String s2){
        if(s1.equals(s2))
            return true;

        if(s1.length() != s2.length())
            return false;

        String key = s1 + s2;

        if(map.containsKey(key))
            return map.get(key);

        int n = s1.length();
        boolean result = false;

        for(int i=1; i<n; i++){
            boolean swapped = solve(s1.substring(0, i), s2.substring(n-i))
                    && solve(s1.substring(i), s2.substring(0, n-i));

            if(swapped){
                result = true;
                break;
            }

            boolean not_swapped = solve(s1.substring(0, i), s2.substring(0, i))
                    && solve(s1.substring(i), s2.substring(i));

            if(not_swapped){
                result = true;
                break;
            }
        }

        map.put(key, result);

        return result;
    }

    public static boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }

    public static void main(String[] args) {
        String s1 = "great", s2 = "rgeat";  // True

//        String s1 = "abcde", s2 = "caebd";  // False

        System.out.println(isScramble(s1, s2));
    }
}
