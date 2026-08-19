import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/cinema-seat-allocation
public class CinemaSeatAllocation {

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // row -> seat in each row booked
        Map<Integer, Set<Integer>> mp = new HashMap<>();

        for(int[] reservedSeat : reservedSeats){
            int row = reservedSeat[0];
            int seat = reservedSeat[1];

            mp.putIfAbsent(row, new HashSet<>());
            mp.get(row).add(seat);
        }

        // If any row does not have any booked seat then we can add
        // at most 2 groups in that
        int result = (n - mp.size()) * 2;

        for(Set<Integer> bookedSeat : mp.values()){

            boolean groupA = !bookedSeat.contains(2) && !bookedSeat.contains(3) &&
                    !bookedSeat.contains(4) && !bookedSeat.contains(5);
            boolean groupB = !bookedSeat.contains(4) && !bookedSeat.contains(5) &&
                    !bookedSeat.contains(6) && !bookedSeat.contains(7);
            boolean groupC = !bookedSeat.contains(6) && !bookedSeat.contains(7) &&
                    !bookedSeat.contains(8) && !bookedSeat.contains(9);

            if(groupA && groupC){
                result += 2;
            }
            else if(groupA || groupB || groupC){
                result += 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        System.out.println(maxNumberOfFamilies(n, reservedSeats));
    }
}
