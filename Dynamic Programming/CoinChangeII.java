public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] waysDp = new int[amount + 1];

        waysDp[0] = 1;

        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                waysDp[i] = waysDp[i] + waysDp[i - coin];
            }
        }

        return waysDp[amount];
    }

    public static void main(String[] args) {
        CoinChangeII cc = new CoinChangeII();
        int[] arr = {1, 2, 4, 3, 5};
        int amount = 5;

        /*
        * 1 1 1 1 1
        * 1 2 2
        * 1 1 1 2
        * 1 4
        * 1 1 3
        * 2 3
        * 5
        * */
        System.out.println(cc.change(amount, arr));
    }
}
