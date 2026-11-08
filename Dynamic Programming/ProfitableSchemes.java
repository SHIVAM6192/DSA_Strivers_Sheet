import java.util.Arrays;

// https://leetcode.com/problems/profitable-schemes/
public class ProfitableSchemes {
    static int count;
    static int N;
    static int MOD = 1_000_000_007;
    static int[][][] t;

    public static int solve(int i, int prof, int people, int minProfit, int[] group, int[] profit){
        if (people > N)
            return t[i][prof][people] = 0;

        if (i == group.length){
            if (prof >= minProfit)
                return t[i][prof][people] = 1;
            return t[i][prof][people] = 0;
        }

        if (t[i][prof][people] != -1)
            return t[i][prof][people];

        long taken = solve(i+1, Math.min(prof + profit[i], minProfit), people+group[i], minProfit, group, profit)%MOD;
        long not_taken = solve(i+1, prof, people, minProfit, group, profit)%MOD;

        return t[i][prof][people] = ((int)taken%MOD + (int)not_taken%MOD)%MOD;
    }

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        t = new int[101][101][101];

        for (int i=0; i<101; i++){
            for (int j=0; j<101; j++){
                Arrays.fill(t[i][j], -1);
            }
        }

        N = n;
        count = 0;
        return solve(0, 0, 0, minProfit, group, profit);
    }

    public static void main(String[] args) {
        int n = 10, minProfit = 5;
        int[] group = {2,3,5};
        int[] profit = {6,7,8};
        System.out.println(profitableSchemes(n, minProfit, group, profit));
    }
}
