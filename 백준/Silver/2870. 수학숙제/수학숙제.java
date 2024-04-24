import java.util.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        while (n-- > 0) {
            String[] numbers = sc.next().split("[a-z]");
            for (String number : numbers) {
                if (number.length() > 0) {
                    pq.add(new BigInteger(number));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb);
    }
}
