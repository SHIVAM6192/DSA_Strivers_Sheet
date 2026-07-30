// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i
public class MinimumNumberOfPushesToTypeWordI {
    public static int minimumPushes(String word) {
        int ans = 0;
        for(int i = 0; i < word.length(); i++){
            ans += (i/8)+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String word = "xycdefghij";
        System.out.println(minimumPushes(word));
    }
}
