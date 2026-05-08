package BinarySearch;

public class BinarySearchImplementation {
    public static void main(String[] args) {
        int[] arr = {-5, -4, 0, 3, 5, 9, 10, 18, 98, 100};
        System.out.println(binarySearch(arr, 100));
    }

    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }

}
