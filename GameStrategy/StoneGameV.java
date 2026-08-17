import java.util.Arrays;

// https://leetcode.com/problems/stone-game-v
public class StoneGameV {
    static int[][] t = new int[501][501];
    public static int solve(int l, int r, int[] cumSum){
        if(l >= r){
            return 0;
        }
        if(t[l][r] != -1){
            return t[l][r];
        }

        int score = 0;
        for(int mid = l; mid <= r-1; mid++){
            int leftSum = cumSum[mid] - (l-1 >= 0 ? cumSum[l-1] : 0);  //[l..mid]
            int rightSum = cumSum[r] - cumSum[mid]; //mid+1, r

            if(leftSum < rightSum){
                score = Math.max(score, leftSum + solve(l, mid, cumSum));
            }
            else if(leftSum > rightSum){
                score = Math.max(score, rightSum + solve(mid+1, r, cumSum));
            }
            else {
                score = Math.max(score, Math.max(leftSum + solve(l, mid, cumSum),
                        rightSum + solve(mid + 1, r, cumSum)));
            }

        }

        return t[l][r] = score;
    }

    public static int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] cumSum = new int[n];
        cumSum[0] = stoneValue[0];

        for(int i = 1; i < n; i++){
            cumSum[i] = cumSum[i-1] + stoneValue[i];
        }

        for (int i = 0; i < 501; i++) {
            Arrays.fill(t[i], -1);
        }

        return solve(0, n-1, cumSum);
    }

    public static void main(String[] args) {
        int[] stoneValue = {6,2,3,4,5,5};
        System.out.println(stoneGameV(stoneValue));
    }
}
