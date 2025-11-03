package org.example;

public class AVLBalance {
    public int height(AVLNode node){
        return node == null ? 0 : node.height;
    }

    public int getBalance(AVLNode node){
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    public AVLNode rotateRight(AVLNode y){
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public AVLNode rotateLeft(AVLNode x){
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;     
    }
}
