import java.util.*;

public class LongestConsecutive {
    public static void main(String[] args){
        int[] a = {104, 100, 4, 200, 103, 1, 3, 2, 105, 5, 101, 102, 103};

        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int ans = longestConsecutive.longestConsecutive(a);
        System.out.println("The longest consecutive sequence is " + ans);

    }

    private int longestConsecutive(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        int longest = 1;
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < n; i++){
            st.add(nums[i]);
        }

        for(int it : st){
            if(!st.contains(it -1)){
                int cnt = 1;
                int x = it;
                while(st.contains(x + 1)){
                    x = x + 1;
                    cnt = cnt + 1;
                }

                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}

/*
    Brute Force solution

    private int longestConsecutive(int[] nums){

        if(nums.length == 0)
            return 0;

        int longest = 1;

        for(int i = 0; i < nums.length; i++){
            int cnt = 1;
            int x = nums[i];

            while(linearSearch(nums, x+1) == true){
                x += 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    private boolean linearSearch(int[] arr, int num){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
 */