package BinaryTree;

public class LowestCommonAncestorBTree {
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    Node root;

    public static void main(String[] args) {

        LowestCommonAncestorBTree tree = new LowestCommonAncestorBTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


    }
}
