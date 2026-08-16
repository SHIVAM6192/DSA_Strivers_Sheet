// https://leetcode.com/problems/stone-game-ix
public class StoneGameIX {
    public static boolean stoneGameIX(int[] stones) {
        int[] counts = new int[3];

        for(int stone : stones){
            counts[stone % 3]++;
        }

        // Scenario A: Count of multiples of 3 is EVEN
        if(counts[0] % 2 == 0){
            // Alice win if there is atleast one '1' and at least one '2'
            return counts[1] > 0 && counts[2] > 0;
        }
        // Scenario B: Count of multiples of 3 is ODD
        else{
            // Alice wins if the difference between '1's and '2's is greater than 2
            return Math.abs(counts[1] - counts[2]) > 2;
        }

    }
    public static void main(String[] args) {
        int[] stones1 = {2,1};
        int[] stones2 = {2};
        System.out.println(stoneGameIX(stones1));
        System.out.println(stoneGameIX(stones2));

    }
}
