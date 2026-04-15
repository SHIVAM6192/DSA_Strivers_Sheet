public class MaxValueFromArray {
    public static void main(String[] args){
        int[] arr = {1, 9, 3, 22, 7, 8, 10};
        System.out.println(max(arr));
        System.out.println(maxInRange(arr, 3, 5));
    }

    public static int max(int[] arr){
        int maxVal = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
        }
        return  maxVal;
    }

    public static int maxInRange(int[] arr, int startIndex, int endIndex){
        if(startIndex > arr.length - 1 || endIndex > arr.length - 1)
        {
            System.out.println("Index range out og bound.");   // Early exit
            return -1;
        }

        int maxVal = arr[startIndex];
        for(int j = startIndex; j < endIndex; j++){
           if(arr[j] > maxVal){
               maxVal = arr[j];
           }
        }
        return maxVal;
    }
}
