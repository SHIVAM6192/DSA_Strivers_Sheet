import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/frog-jump
public class FrogJump {
    Map<Integer, Integer> mp = new HashMap<>();
    int[][] t = new int[2001][2001];
    int n;

    public boolean solve(int[] stones, int curr_stone_idx, int prevJump){
        if (curr_stone_idx == n)
            return true;

        if (t[curr_stone_idx][prevJump] != -1)
            return t[curr_stone_idx][prevJump] == 1;

        boolean result = false;

        for (int nextJump = prevJump-1; nextJump<= prevJump+1; nextJump++){
            if (nextJump > 0){
                int next_stone = stones[curr_stone_idx] + nextJump;
                if (mp.containsKey(next_stone)){
                    result = result || solve(stones, mp.get(next_stone), nextJump);
                }
            }
        }

        t[curr_stone_idx][prevJump] = (result ? 1 : -1);

        return result;
    }

    public boolean canCross(int[] stones) {
        n = stones.length;
        if (stones[1] != 1)
            return false;

        for (int i=0; i<n; i++)
            mp.put(stones[i], i);

        for (int i=0; i<2000; i++){
            Arrays.fill(t[i], -1);
        }

        return solve(stones, 0, 0);
    }

    public static void main(String[] args) {
        FrogJump fj = new FrogJump();
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(fj.canCross(stones));
    }
}
