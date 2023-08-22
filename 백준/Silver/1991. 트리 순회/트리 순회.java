import java.util.HashMap;
import java.util.Scanner;

class Main {
	static class Node {
		Node left;
		Node right;
		char data;

		Node(char data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		HashMap<Character, Node> hashMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node root = new Node('A');
		hashMap.put('A', root);
		for (int i = 0; i < n; i++) {
			Node node = hashMap.get(sc.next().charAt(0));
			char c2 = sc.next().charAt(0);
			if (c2 != '.') {
				node.left = new Node(c2);
				hashMap.put(c2, node.left);
			}
			char c3 = sc.next().charAt(0);
			if (c3 != '.') {
				node.right = new Node(c3);
				hashMap.put(c3, node.right);
			}
		}
		printTree(root, 0);
		System.out.println();
		printTree(root, 1);
		System.out.println();
		printTree(root, 2);
		System.out.println();
	}
	static void printTree(Node node, int flag) {
		if (flag == 0)
			System.out.print(node.data);
		if (node.left != null) printTree(node.left, flag);
		if (flag == 1)
			System.out.print(node.data);
		if (node.right != null) printTree(node.right, flag);
		if (flag == 2)
			System.out.print(node.data);
	}
}