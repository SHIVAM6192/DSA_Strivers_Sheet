import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args){
        List<List<Integer>> result = generateTriangle(6);
        System.out.println(result);
    }

    public static List<List<Integer>> generateTriangle(int numRow){
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRow == 0)
            return triangle;

        // The first row is always [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        // Build the triangle row by row starting from the second row (index 1)
        for(int i = 1; i < numRow; i++){
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // The first element of every row is always 1
            currentRow.add(1);

            // Calculate the inner elements by summing the two directly above
            for(int j = 1; j < i; j++){
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element of every row is always 1
            currentRow.add(1);

            // Add the completed row to the triangle
            triangle.add(currentRow);
        }

        return triangle;
    }
}
