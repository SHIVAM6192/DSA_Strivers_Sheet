public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Total rain trapped: " + trap(height));

    }
    public static int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;

        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;

        while(left <= right){
            // If left bar is smaller or equal to right bar
            if(height[left] <= height[right]){
                // If current left bar is higher than maxLeft, update maxLeft
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }
                else{
                    // Water trapped on left is difference between maxLeft and current height
                    totalWater += maxLeft - height[left];
                }
                left++; // Move left pointer to the right
            }
            else{
                // If current right bar is higher than maxRight, update maxRight
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }
                else{
                    // Water trapped on right is difference between maxRight and current height
                    totalWater += maxRight - height[right];
                }
                right--; // Move right pointer to the left
            }
        }
        return totalWater;
    }
}
