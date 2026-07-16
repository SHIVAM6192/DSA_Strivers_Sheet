import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-elements
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (int key : freq.keySet()){
            int frequency = freq.get(key);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >=0 && counter < k; pos--){
            if (bucket[pos] != null){
                for (Integer integer : bucket[pos]){
                    res[counter++] = integer;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
