import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/shift-2d-grid/description
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int size = m*n;

        // Flatten grid into a linear array in row-major order
        int temp[] = new int[size];
        int ind = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                temp[ind++] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ind = 0;
        for(int i=0; i<m; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<n; j++) {
                // Source index is k behind; (+size)%size keeps it non-negative for the wrap
                int idx = ((ind-k)%size + size ) %size;
                int val = temp[idx];
                list.add(val);
                ind++;
            }
            ans.add(list);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        Shift2DGrid obj = new Shift2DGrid();

        System.out.println(obj.shiftGrid(grid, k));
    }
}
