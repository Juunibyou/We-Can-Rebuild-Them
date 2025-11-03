package org.example;

public class AVLTree {
    private AVLNode root;
    private AVLBalance balance = new AVLBalance();

    public AVLNode getRoot() {
        return root;
    }

//INSERT    
    public void insert(int value) {
        root = insertAVL(root, value);
    }

    private AVLNode insertAVL(AVLNode node, int value) {
        if (node == null) {
            return new AVLNode(value);
        }
        if (value < node.value) {
            node.left = insertAVL(node.left, value);
        } else if (value > node.value) {
            node.right = insertAVL(node.right, value);
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

//DELETE
    public void delete(int value){
        root = deleteAVL(root, value);
    }

    private AVLNode deleteAVL(AVLNode node, int value){
        if(node == null) {
            return null;
        }

        if(value < node.value){
            node.left = deleteAVL(node.left, value);
        }
        else if(value > node.value){
            node.right = deleteAVL(node.right, value);
        }
        else {
            if (node.left == null || node.right == null) {
            node = (node.left != null) ? node.left : node.right;
            } 
            else {
            AVLNode min = getMin(node.right);
            node.value = min.value;
            node.right = deleteAVL(node.right, min.value);
            }
        }

        if(node == null){
            return null;
        }

        node.height = 1 + Math.max(balance.height(node.left), balance.height(node.right));
        int bf = balance.getBalance(node);

        //left left
        if (bf > 1 && balance.getBalance(node.left) >= 0){
            return balance.rotateRight(node);
        }
        //left right
        if (bf > 1 && balance.getBalance(node.left) < 0){
            node.left = balance.rotateLeft(node.left);
            return balance.rotateRight(node);
        }
        //right right
        if (bf < -1 && balance.getBalance(node.right) <= 0){
            return balance.rotateLeft(node);
        }
        //right left
        if (bf < -1 && balance.getBalance(node.right) > 0){
            node.right = balance.rotateRight(node.right);
            return balance.rotateLeft(node);
        }

        return node;
    }

    public AVLNode getMin(AVLNode node){
        AVLNode current = node;
        while(current.left != null){
            current = current.left;
        }

        return current;
    }
}
