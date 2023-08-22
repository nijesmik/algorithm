import java.util.HashMap;
import java.util.Scanner;

class Main {
	static String[] ans = new String[3];
    static class Node {
		Node left;
		Node right;
		char data;

		Node(char data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		ans[0] = ""; ans[1] = ""; ans[2] = "";
		HashMap<Character, Node> hashMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node root = new Node('A');
		hashMap.put('A', root);
		for (int i = 0; i < n; i++) {
			Node node = hashMap.get(sc.next().charAt(0));
			char a = sc.next().charAt(0);
			if (a != '.') {
				node.left = new Node(a);
				hashMap.put(a, node.left);
			}
			char b = sc.next().charAt(0);
			if (b != '.') {
				node.right = new Node(b);
				hashMap.put(b, node.right);
			}
		}
		getAns(root);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}

	static void getAns(Node node) {
		ans[0] += node.data; 
		if (node.left != null) getAns(node.left);
		ans[1] += node.data; 
		if (node.right != null) getAns(node.right);
		ans[2] += node.data; 
	}
}