import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {12, 85, 79},
                {7, -8, 66},
                {75, 46, 32, 11, 45},
                {18, 4}
        };
        int target = 66;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] search(int[][] arr, int target){
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                if(arr[row][col] == target){
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{-1, -1};
    }

}
