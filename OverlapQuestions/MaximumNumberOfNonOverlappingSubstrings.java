import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings
public class MaximumNumberOfNonOverlappingSubstrings {
    public static List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        List<int[]> intervals = new ArrayList<>();

        for(int i = 0; i<n; i++){
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        // try to create the smallest valid substring
        // starting from each character's first occurrence
        for(int c=0; c<26; c++){
            if(last[c] == -1){
                continue;
            }

            int start = first[c];
            int end = last[c];
            boolean valid = true;

            for(int i=start; i<=end; i++){
                int current = s.charAt(i) - 'a';
                // This character occurred before our start,
                // so we cannot include all of its occurrences.
                if(first[current] < start){
                    valid = false;
                    break;
                }

                end = Math.max(end, last[current]);
            }
            if(valid){
                intervals.add(new int[]{start, end});
            }
        }

        // Sort intervals by ending position
        intervals.sort((a,b) -> Integer.compare(a[1],b[1]));
        List<String> result = new ArrayList<>();
        int previousEnd = -1;

        // Greedily select non-overlapping intervals
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(start > previousEnd){
                result.add(s.substring(start, end+1));
                previousEnd = end;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "adefaddaccc";
        System.out.println(maxNumOfSubstrings(s));
    }
}
