package SortingAlgortihms;

import java.util.*;

public class TreeAndGraph {
    public class BinarySearchTree {
        private Node root;

        private static class Node {
            int data;
            Node left, right;

            Node(int data) {
                this.data = data;
            }
        }

        public void insert(int data) {
            root = insertRecursive(root, data);
        }

        private Node insertRecursive(Node root, int data) {
            if (root == null) return new Node(data);
            if (data < root.data) root.left = insertRecursive(root.left, data);
            else root.right = insertRecursive(root.right, data);
            return root;
        }

        public boolean search(int data) {
            return searchRecursive(root, data);
        }

        private boolean searchRecursive(Node root, int data) {
            if (root == null) return false;
            if (root.data == data) return true;
            return data < root.data ? searchRecursive(root.left, data) : searchRecursive(root.right, data);
        }

        public void delete(int data) {
            root = deleteRecursive(root, data);
        }

        private Node deleteRecursive(Node root, int data) {
            if (root == null) return null;
            if (data < root.data) root.left = deleteRecursive(root.left, data);
            else if (data > root.data) root.right = deleteRecursive(root.right, data);
            else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                root.data = minValue(root.right);
                root.right = deleteRecursive(root.right, root.data);
            }
            return root;
        }

        private int minValue(Node root) {
            int minVal = root.data;
            while (root.left != null) {
                minVal = root.left.data;
                root = root.left;
            }
            return minVal;
        }

        public void inorderTraversal() {
            inorderRecursive(root);
            System.out.println();
        }

        private void inorderRecursive(Node root) {
            if (root != null) {
                inorderRecursive(root.left);
                System.out.print(root.data + " ");
                inorderRecursive(root.right);
            }
        }
    }
    public class Graph {
        private Map<Integer, List<Integer>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        public void addVertex(int v) {
            adjList.putIfAbsent(v, new ArrayList<>());
        }

        public void addEdge(int v, int w) {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.putIfAbsent(w, new ArrayList<>());
            adjList.get(v).add(w);
            adjList.get(w).add(v);  // Undirected graph
        }

        public void removeEdge(int v, int w) {
            adjList.get(v).remove((Integer) w);
            adjList.get(w).remove((Integer) v);
        }

        public void removeVertex(int v) {
            for (Integer neighbor : new ArrayList<>(adjList.get(v))) {
                adjList.get(neighbor).remove((Integer) v);
            }
            adjList.remove(v);
        }

        public void bfs(int start) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");
                for (int neighbor : adjList.get(vertex)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println();
        }

        public void dfs(int start) {
            Set<Integer> visited = new HashSet<>();
            dfsRecursive(start, visited);
            System.out.println();
        }

        private void dfsRecursive(int vertex, Set<Integer> visited) {
            if (!visited.add(vertex)) return;
            System.out.print(vertex + " ");
            for (int neighbor : adjList.get(vertex)) {
                dfsRecursive(neighbor, visited);
            }
        }

        public void display() {
            for (int key : adjList.keySet()) {
                System.out.println(key + " -> " + adjList.get(key));
            }
        }
    }

}
