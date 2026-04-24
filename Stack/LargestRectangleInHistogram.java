import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {3,6,5,7,4,8,1,0};
        System.out.println("The largest area in the histogram is " + largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        // Nearest left smaller
        for(int i = 0; i < n; i++){
            while(!st.empty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            leftSmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        st.clear();

        // Nearest right smaller
        for(int i = n -1; i >= 0; i--){
            while(!st.empty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            rightSmall[i] = st.isEmpty() ? n-1 : st.peek() -1 ;
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int width = rightSmall[i] - leftSmall[i] + 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}
