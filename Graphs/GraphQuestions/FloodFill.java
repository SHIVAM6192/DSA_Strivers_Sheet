package GraphQuestions;

import java.util.Arrays;

// https://leetcode.com/problems/flood-fill/description/
public class FloodFill {

    public void dfs(int[][] image, int i, int j, int newColor, int orgColor){
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length ||
                image[i][j] == newColor || image[i][j] != orgColor)
        {
            return;
        }

        image[i][j] = newColor;
        dfs(image, i - 1, j, newColor, orgColor);  // top
        dfs(image, i, j + 1, newColor, orgColor);  // right
        dfs(image, i + 1, j, newColor, orgColor);  // bottom
        dfs(image, i, j - 1, newColor, orgColor);  // left
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);

        return image;
    }

    public static void main(String[] args) {
        FloodFill floodF = new FloodFill();

        int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};

        int[][] result = floodF.floodFill(arr, 1, 1, 2);

        for (int[] a : result){
            System.out.println(Arrays.toString(a));
        }
    }
}
