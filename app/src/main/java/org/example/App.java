package org.example;

public class App {
  public static void main(String[] args) {
    AVLTree tree = new AVLTree();
 
    // Inserts four nodes into the tree
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);
    tree.insert(6);
 
    System.out.println(tree.serialize());
 
    tree.delete(6);
    
    System.out.println(tree.serialize());
  }
}
