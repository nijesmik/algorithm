import java.util.*;

public class Main {
	static class Meeting {
		int start;
		int end;
		Meeting (int s, int e) {
			start = s;
			end = e;
		}
		int getStart() {return start;}
		int getEnd() {return end;}
	}
	static int cnt, prev;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<Meeting> list = new ArrayList<>();
		while (t-- > 0)
			list.add(new Meeting(sc.nextInt(), sc.nextInt()));
		cnt = 0; prev = 0;
		list.stream().sorted(Comparator.comparing(Meeting::getEnd).thenComparing(Meeting::getStart)).forEach(meeting->{
			if (meeting.start >= prev) {
				cnt++;
				prev = meeting.end;
			}
		});
		System.out.println(cnt);
	}
}