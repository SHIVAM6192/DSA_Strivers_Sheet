package Questions;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-operations-to-sort-a-string
public class MinimumOperationsToSortAString {
    public static int minOperations(String s) {
        int n = s.length();

        char[] arr = s.toCharArray();
        char[] sorted = arr.clone();
        Arrays.sort(sorted);

        // if string already sorted then we don't need to do anything
        if(Arrays.equals(arr, sorted)){
            return 0;
        }

        // If the length of string is 2 then we cant perform any operation
        if(n == 2){
            return -1;
        }

        // Find the minimum and maximum characters in string
        char mn = s.charAt(0);
        char mx = s.charAt(0);

        for(int i=1; i<n; i++){
            char ch = s.charAt(i);

            if(ch < mn){
                mn = ch;
            }

            if(ch > mx){
                mx = ch;
            }
        }

        // If the string first or last character is at correct place then we need
        // only one operation to perform
        if(s.charAt(0) == mn || s.charAt(n-1) == mx){
            return 1;
        }

        // Count occurrences of minimum and maximum characters
        int minCount = 0;
        int maxCount = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == mn) minCount++;

            if(s.charAt(i) == mx) maxCount++;
        }

        // If the mxChar at start and minChar at end and occurrence of both is exactly one then we need to perform 3 operation to sort the string
        // z c b a -> 3 Operations
        if(s.charAt(0) == mx && s.charAt(n-1) == mn &&
                maxCount == 1 && minCount == 1)
        {
            return 3;
        }

        // If all above condition are false the for any string we can sort it in 2 operations
        return 2;
    }

    public static void main(String[] args) {
        String s1 = "card";
        System.out.println(minOperations(s1));

        String s2 = "dog";
        System.out.println(minOperations(s2));

        String s3 = "zcbka";
        System.out.println(minOperations(s3));

        String s4 = "zhsmdawqa";  // two occurrence of 'a'
        System.out.println(minOperations(s4));
    }
}
