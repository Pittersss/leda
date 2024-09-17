package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.SimpleBSTManipulation;
import adt.bst.SimpleBSTManipulationImpl;

public class MyMain {
    public static void main(String[] args) {
        SimpleBSTManipulationImpl<Integer> sbm = new SimpleBSTManipulationImpl<Integer>();
        FloorCeilBSTImpl fcb = new FloorCeilBSTImpl();
        BSTImpl<Integer> tree1 = new BSTImpl<Integer>();
        BSTImpl<Integer> tree2 = new BSTImpl<Integer>();
        Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree1.insert(i);
            tree2.insert(i);
		}
        
       Integer[] array2 = {3};
       System.out.println(fcb.ceil(array, 3));
    }
}
