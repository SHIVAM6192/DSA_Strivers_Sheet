package BinarySearch;

import java.util.Arrays;

// https://leetcode.com/problems/search-a-2d-matrix/description/?envType=problem-list-v2&envId=binary-search
public class BinarySearchIn2dMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(searchMatrix(arr, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int idx = searchPotentialRow(matrix, target);
        if (idx != -1){
            return binarySearchOverRow(idx, matrix, target);
        }
        return false;
    }

    public static int searchPotentialRow(int[][] matrix, int target){
        int low = 0;
        int high = matrix.length - 1;
        int idx = matrix[0].length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(matrix[mid][0] <= target && target <= matrix[mid][idx]){
                return mid;
            }
            if(matrix[mid][0] < target){
                low = mid + 1;
            }
            else if(matrix[mid][0] > target){
                high = mid - 1;
            }
        }
        return -1;

    }

    public static boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target){
        int low = 0;
        int high = matrix[rowIdx].length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(matrix[rowIdx][mid] == target){
                return true;
            }
            else if(matrix[rowIdx][mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return false;

    }

}
