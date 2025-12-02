package com.gdstruc.quiz6;

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(9);
        tree.insert(13);
        tree.insert(35);
        tree.insert(44);
        tree.insert(22);
        tree.insert(4);
        tree.insert(8);
        tree.insert(2);
        tree.insert(32);
        tree.insert(18);
        tree.insert(20);
        tree.insert(29);
        tree.insert(31);

        System.out.println("Traversing in order:");
        tree.traverseInOrder();

        System.out.println("Traversing in descending order:");
        tree.traverseInOrderDescending();

        System.out.println("Getting the minimum value:");
        System.out.println(tree.getMin());

        System.out.println("Getting the maximum value:");
        System.out.println(tree.getMax());

    }
}