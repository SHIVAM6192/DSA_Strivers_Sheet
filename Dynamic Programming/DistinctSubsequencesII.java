// https://leetcode.com/problems/distinct-subsequences-ii
public class DistinctSubsequencesII {
    public static int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        int total = 0;
        int[] end = new int[26];

        for(char ch : s.toCharArray()){
            int index = ch - 'a';
            int oldTotal = total;
            int newSubsequences = (oldTotal + 1 - end[index] + MOD) % MOD;
            total = (total + newSubsequences) % MOD;
            end[index] = (end[index] + newSubsequences) % MOD;
        }
        return total;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(distinctSubseqII(s));
    }
}
