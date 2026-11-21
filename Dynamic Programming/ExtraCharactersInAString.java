import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharactersInAString {
    Set<String> set = new HashSet<>();
    int n;
    int[] t = new int[51];

    public int solve(int idx, String s){
        if(idx >= n)
            return 0;

        if(t[idx] != -1)
            return t[idx];

        StringBuffer currStr = new StringBuffer();
        int minExtra = n;

        for(int i=idx; i<n; i++){
            currStr.append(s.charAt(i));

            int currExtra = (!set.contains(currStr.toString())) ? currStr.length() : 0;

            int nextExtra = solve(i+1, s);
            int total = currExtra + nextExtra;
            minExtra = Math.min(minExtra, total);
        }

        return t[idx] = minExtra;
    }

    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        Arrays.fill(t, -1);
        for(String str : dictionary){
            set.add(str);
        }

        return solve(0, s);
    }

    public static void main(String[] args) {
        ExtraCharactersInAString obj = new ExtraCharactersInAString();
        String s = "sayhelloworld";
        String[] dictionary = {"hello","world"};
        System.out.println(obj.minExtraChar(s, dictionary));
    }
}
