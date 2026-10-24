import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-days-spent-together
public class CountDaysSpentTogether {
    public static int toDay(String date){
        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        int total = day;
        for (int i=0; i<month-1; i++){
            total += daysInMonth[i];
        }

        return total;
    }

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrive = toDay(arriveAlice);
        int aliceLeave = toDay(leaveAlice);

        int bobArrive = toDay(arriveBob);
        int bobLeave = toDay(leaveBob);

        int start = Math.max(aliceArrive, bobArrive);
        int end = Math.min(aliceLeave, bobLeave);

        if (start > end){
            return 0;
        }

        return end - start + 1;
    }
    public static void main(String[] args) {
        String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19";

        System.out.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }
}
