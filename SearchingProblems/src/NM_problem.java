import java.util.*;

public class NM_problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size1; i++) {
            set.add(sc.nextInt());
        }
        int count = 0;
        for (int i = 0; i < size2; i++) {
            if (set.contains(sc.nextInt())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
