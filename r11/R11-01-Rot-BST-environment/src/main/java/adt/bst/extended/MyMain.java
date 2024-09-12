package adt.bst.extended;

import adt.bst.BSTImpl;

public class MyMain {
    public static void main(String[] args) {
        BSTImpl<Integer> tree = new BSTImpl<Integer>();
        Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}

        System.out.println(tree.search(7));
    }
}
