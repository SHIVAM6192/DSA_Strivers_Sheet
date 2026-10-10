package GraphQuestions;

// https://leetcode.com/problems/find-the-town-judge
public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];

        for(int[] arr : trust){
            int u = arr[0];
            int v = arr[1];

            count[u]--;
            count[v]++;
        }

        for (int i=1; i<=n; i++){
            if (count[i] == n-1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge fTJ = new FindTheTownJudge();
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        System.out.println(fTJ.findJudge(n, trust));
    }
}
