public class StockBuyAndSell {
    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // Initialize the minimum price to a large number
        int minPrice = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices){
            // If current price is less than minPrice, update minPrice
            if (price < minPrice){
                minPrice = price;
            }
            // Else calculate profit and update maxProfit if it's greater
            else{
                max = Math.max(max, price - minPrice);
            }
        }
        return max;
    }

// Brute Force
//    public static int maxProfit(int[] prices) {
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < prices.length; i++){
//            for (int j = i + 1; j < prices.length; j++){
//                int profit = prices[j] - prices[i];
//                max = Math.max(profit, max);
//            }
//        }
//        return max;
//    }
}
