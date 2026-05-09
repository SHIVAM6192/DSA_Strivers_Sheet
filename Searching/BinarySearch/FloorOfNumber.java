package BinarySearch;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = {-5, -4, 0, 3, 5, 9, 10, 18, 98, 100};
        System.out.println(floorOfNumber(arr, -10));
    }

    // return smallest number <= target
    public static int floorOfNumber(int[] arr, int target){
        // but what if the target is smallest that the smallest number in the array


        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

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

        return end;
    }
}
