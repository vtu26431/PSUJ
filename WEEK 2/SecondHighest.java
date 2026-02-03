import java.util.*;
import java.util.stream.*;

public class SecondHighest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int result = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);

        System.out.println(result);
    }
}
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

public class LambdaOperations {

    // Lambda to check odd/even
    static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    // Lambda to check prime/composite
    static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    // Lambda to check palindrome
    static PerformOperation isPalindrome() {
        return n -> {
            int original = n, reverse = 0;
            while (n > 0) {
                reverse = reverse * 10 + n % 10;
                n /= 10;
            }
            return original == reverse;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int choice = sc.nextInt();
            int number = sc.nextInt();

            PerformOperation op;
            boolean result;

            switch (choice) {
                case 1:
                    op = isOdd();
                    result = op.check(number);
                    System.out.println(result ? "ODD" : "EVEN");
                    break;

                case 2:
                    op = isPrime();
                    result = op.check(number);
                    System.out.println(result ? "PRIME" : "COMPOSITE");
                    break;

                case 3:
                    op = isPalindrome();
                    result = op.check(number);
                    System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
                    break;
            }
        }
        sc.close();
    }
}
