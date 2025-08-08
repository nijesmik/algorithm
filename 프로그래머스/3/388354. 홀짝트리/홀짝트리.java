

import java.util.*;

public class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        class Tree {
            Map<Integer, List<Integer>> graph = new HashMap<>();

            Tree(int[] nodes, int[][] edges) {
                for (int node : nodes) {
                    graph.put(node, new ArrayList<>());
                }

                for (int[] edge : edges) {
                    int from = edge[0];
                    int to = edge[1];
                    graph.get(from).add(to);
                    graph.get(to).add(from);
                }
            }

            boolean isOENode(int node, boolean isRoot) {
                int nodeParity = node % 2;
                int childrenCount = graph.get(node).size();
                if (!isRoot) {
                    childrenCount--;
                }
                int childrenParity = childrenCount % 2;
                return nodeParity == childrenParity;
            }

            boolean isOETree(int node, int parent) {
                if (!isOENode(node, parent == 0)) {
                    return false;
                }
                List<Integer> children = graph.get(node);
                for (int child : children) {
                    if (child == parent) {
                        continue;
                    }
                    if (!isOETree(child, node)) {
                        return false;
                    }
                }
                return true;
            }

            boolean isReverseOENode(int node, boolean isRoot) {
                return !isOENode(node, isRoot);
            }

            boolean isReverseOETree(int node, int parent) {
                if (!isReverseOENode(node, parent == 0)) {
                    return false;
                }
                List<Integer> children = graph.get(node);
                for (int child : children) {
                    if (child == parent) {
                        continue;
                    }
                    if (!isReverseOETree(child, node)) {
                        return false;
                    }
                }
                return true;
            }
        }

        Tree tree = new Tree(nodes, edges);
        int[] answer = new int[2];
        for (int root : nodes) {
            if (tree.isOETree(root, 0)) {
                answer[0]++;
            }
            if (tree.isReverseOETree(root, 0)) {
                answer[1]++;
            }
        }
        return answer;
    }
}
