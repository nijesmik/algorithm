import java.util.*;

public class Solution {
	static int[][] stairs;
	static int ans;
	static class Person {
		int r, c, len1, len2, stair;

		Person(int a, int b) {
			r = a;
			c = b;
		}

		void setLength() {
			len1 = Math.abs(stairs[0][0] - r) + Math.abs(stairs[0][1] - c);
			len2 = Math.abs(stairs[1][0] - r) + Math.abs(stairs[1][1] - c);
		}
	}
	static List<Person> Persons;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			stairs = new int[2][3];
			Persons = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tmp = sc.nextInt();
					if (tmp == 1) Persons.add(new Person(i, j));
					else if (tmp > 1) {
						int num = 1;
						if (stairs[0][2] == 0) num = 0;
						stairs[num][0] = i;
						stairs[num][1] = j;
						stairs[num][2] = tmp;
					}
				}
			}
			Persons.forEach(Person::setLength);
			ans = Integer.MAX_VALUE;
			combination(0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static void combination(int idx) {
		if (idx == Persons.size()) {
			simulation();
			return;
		}
		Persons.get(idx).stair = 1;
		combination(idx+1);
		Persons.get(idx).stair = 2;
		combination(idx+1);
	}
	static void simulation() {
		LinkedList<Integer> wait1 = new LinkedList<>();
		LinkedList<Integer> wait2 = new LinkedList<>();
		for (Person p : Persons) {
			if (p.stair == 1) wait1.add(p.len1);
			else wait2.add(p.len2);
		}
		wait1.sort(Comparator.naturalOrder());
		wait2.sort(Comparator.naturalOrder());
		Deque<Integer> stair1 = new ArrayDeque<>();
		Deque<Integer> stair2 = new ArrayDeque<>();
		for (int i = 0; i < stairs[0][2]; i++) {
			stair1.add(0);
		}
		for (int i = 0; i < stairs[1][2]; i++) {
			stair2.add(0);
		}
		int time  = 0, people1 = 0, people2 = 0;
		while (!wait1.isEmpty() || !wait2.isEmpty() || people1+people2 > 0) {
			time++;
			people1 -= stair1.pollFirst();
			people2 -= stair2.pollFirst();
			int tmp = 0;
			while (people1 < 3 && !wait1.isEmpty() && wait1.peek() < time) {
				wait1.poll();
				tmp++;
				people1++;
			}
			stair1.addLast(tmp);
			tmp =0;
			while (people2 < 3 && !wait2.isEmpty() && wait2.peek() < time) {
				wait2.poll();
				tmp++;
				people2++;
			}
			stair2.addLast(tmp);
		}
		ans = Math.min(ans, time);
	}
}