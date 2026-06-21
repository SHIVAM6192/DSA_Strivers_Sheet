public class MaximumIceCreamBars {
    public static void main(String[] args) {
        int[] inputes = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(inputes, coins) + " IceCream Can Buy");
    }

    public static int maxIceCream(int[] costs, int coins) {
        int mx = 0;
        for(int cost : costs){
            mx = Math.max(mx, cost);
        }

        int[] freq = new int[mx + 1];
        for(int cost : costs){
            freq[cost]++;
        }

        int count = 0;
        for(int cost = 1; cost <= mx; cost++){
            if(coins < cost){
                break;
            }
            if(freq[cost] == 0){
                continue;
            }

            int canBuy = Math.min(freq[cost], coins / cost);
            count += canBuy;
            coins -= canBuy * cost;
        }

        return count;
    }
}
