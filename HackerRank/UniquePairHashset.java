import java.util.*;

public class UniquePairHashset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String[] left = new String[T];
        String[] right = new String[T];
        for(int i = 0; i < T; i++){
            left[i] = sc.next();
            right[i] = sc.next();
        }
//        HashSet<String> set = new HashSet<>();
        Set<List<String>> set = new HashSet<>();
        for(int i = 0; i < T; i++){
            List<String> list = new ArrayList<>();
            list.add(left[i]);
            list.add(right[i]);

            set.add(list);
            System.out.println(set.size());
        }
        sc.close();

    }
}
