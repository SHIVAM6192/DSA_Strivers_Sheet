import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies
public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int m = g.length;
        int n = s.length;

        int i = 0;
        int j = 0;

        while(i<m && j<n){
            if(g[i] <= s[j]){
                i++;
            }
            j++;
        }

        return i;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};

        System.out.println(findContentChildren(g, s));
    }
}

