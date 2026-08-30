import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements
public class MakeLexicographicallySmallestArrayBySwappingElements {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i=0; i<n; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);

        ArrayList<Deque<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> group = new HashMap<>();

        int groupIndex = 0;
        list.add(new LinkedList<>());
        list.get(groupIndex).offer(temp[0]);
        group.put(temp[0], groupIndex);

        for (int i=1; i<n; i++){
            if (temp[i] - list.get(groupIndex).peekLast() > limit){
                groupIndex++;
                list.add(new LinkedList<>());
            }
            list.get(groupIndex).offer(temp[i]);
            group.put(temp[i], groupIndex);
        }

        for (int i=0; i<n; i++){
            int gi = group.get(nums[i]);
            nums[i] = list.get(gi).poll();
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,9,8};
        int limit = 2;
        int[] result = lexicographicallySmallestArray(nums, limit);

        System.out.println(Arrays.toString(result));
    }
}
