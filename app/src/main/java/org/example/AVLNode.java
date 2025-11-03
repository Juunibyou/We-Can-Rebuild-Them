package org.example;

public class AVLNode {
    
    public int value;
    public AVLNode left;
    public AVLNode right;
    public int height;

    public AVLNode(int val){
        this.value = val;
        this.height = 1;
    }

}
