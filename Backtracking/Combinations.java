import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations
public class Combinations {
    public static void solve(int n, int k, List<Integer> curr, List<List<Integer>> ans){
        if (k == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (n == 0){
            return;
        }

        // pick
        curr.add(n);
        solve(n-1, k-1, curr, ans);

        // not pick
        curr.removeLast();
        solve(n-1, k, curr, ans);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, k, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }
}
