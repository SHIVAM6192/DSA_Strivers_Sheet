package BinarySearch;
// https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=problem-list-v2&envId=binary-search
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
        System.out.println(search(arr, 3));
    }

    // this will not work in duplicate values with ascending sorted array

    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if(pivot == -1){
            // just do normal binary search
            return binarySearch(nums, target, 0, nums.length -1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if(nums[pivot] == target){
            return pivot;
        }

        // if target is greater that or equal to nums[0] means element lies from start to pivot range
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // if target is not greater that nums[0] means it lies from pivot + 1 to nums.length -1
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) /2;

            if(target > arr[mid]){
                start = mid + 1;
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    // We will find the pivot elememt so that we get to know from which element array is rotated
    public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }

            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
