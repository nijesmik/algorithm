import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeA = sc.nextInt(), sizeB = sc.nextInt();
        Set<Integer> setA = new TreeSet<>();
        for (int i = 0; i < sizeA; i++) {
            setA.add(sc.nextInt());
        }
        for (int i = 0; i < sizeB; i++) {
            setA.remove(sc.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(setA.size() + "\n");
        for (int num : setA) {
            sb.append(num + " ");
        };
        System.out.println(sb);
    }
}