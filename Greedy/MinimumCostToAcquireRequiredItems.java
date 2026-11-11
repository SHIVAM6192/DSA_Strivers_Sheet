// https://leetcode.com/problems/minimum-cost-to-acquire-required-items
public class MinimumCostToAcquireRequiredItems {
    public static long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if((long)cost1 + cost2 <= costBoth){
            return (long) cost1 * need1 + (long) cost2 * need2;
        }

        int both = Math.min(need1, need2);
        long total = (long) both * costBoth;

        need1 -= both;
        need2 -= both;

        if(need1 > 0){
            total += (long) need1 * Math.min(cost1, costBoth);
        }
        if(need2 > 0){
            total += (long) need2 * Math.min(cost2, costBoth);
        }

        return total;
    }

    public static void main(String[] args) {
        int cost1 = 5, cost2 = 4, costBoth = 15, need1 = 2, need2 = 3;
        System.out.println(minimumCost(cost1, cost2, costBoth, need1, need2));
    }
}
