package org.example;

public class AVLTree {
    private AVLNode root;
    private AVLBalance balance = new AVLBalance();

    public void insert(int value) {
        root = insertVal(root, value);
    }

    public AVLNode getRoot() {
        return root;
    }

    private AVLNode insertVal(AVLNode node, int value) {
        if (node == null) {
            return new AVLNode(value);
        }
        if (value < node.value) {
            node.left = insertVal(node.left, value);
        } else if (value > node.value) {
            node.right = insertVal(node.right, value);
        } else {
            return node;
        }

        node.height = 1 + Math.max(balance.height(node.left), balance.height(node.right));
        int bf = balance.getBalance(node);

        if (bf > 1 && value < node.left.value)
            return balance.rotateRight(node);
        if (bf < -1 && value > node.right.value)
            return balance.rotateLeft(node);
        if (bf > 1 && value > node.left.value) {
            node.left = balance.rotateLeft(node.left);
            return balance.rotateRight(node);
        }
        if (bf < -1 && value < node.right.value) {
            node.right = balance.rotateRight(node.right);
            return balance.rotateLeft(node);
        }

        return node;
    }
}
