import java.util.*;
import java.util.stream.*;

public class secondhighest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Optional<Integer> secondHighest =
                list.stream()
                    .distinct()                // remove duplicates
                    .sorted(Comparator.reverseOrder()) // descending order
                    .skip(1)                    // skip highest
                    .findFirst();               // get second highest

        System.out.println(secondHighest.orElse(-1));
        sc.close();
    }
}
