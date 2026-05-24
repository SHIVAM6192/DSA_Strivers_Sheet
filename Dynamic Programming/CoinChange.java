// https://leetcode.com/problems/coin-change/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        int[] minCoinDp = new int[amount + 1];

        for(int i = 1; i <= amount; i++){
            minCoinDp[i] = Integer.MAX_VALUE;

            for (int coin : coins){
                if (coin <= i && minCoinDp[i - coin] != Integer.MAX_VALUE){
                    minCoinDp[i] = Math.min(minCoinDp[i], 1 + minCoinDp[i - coin]);
                }
            }
        }

        if (minCoinDp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return minCoinDp[amount];
    }
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] arr = {1,2,5};
        int amount = 80;

        System.out.println(cc.coinChange(arr, amount));
    }
}
