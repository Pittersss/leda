package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class MyMain {
    public static void main(String[] args) {

        AVLTreeImpl<Integer> avl = new AVLTreeImpl<Integer>();
        avl.insert(10);
        avl.insert(5);
        avl.insert(0);
        avl.insert(6);
        avl.rebalance(avl.getRoot());
        System.out.println(avl.getRoot());
    }
}
