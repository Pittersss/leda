package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;

public class MyMain {
    public static void main(String[] args) {
        AbstractHashtableOpenAddress<HashtableElement> table1;
        table1 = new HashtableOpenAddressQuadraticProbingImpl<HashtableElement>(
				10, HashFunctionClosedAddressMethod.DIVISION, 3, 5);
		// o tamanho real utilizado vai ser PROPOSED_SIZE
		table1.insert(new HashtableElement(10));
        table1.insert(new HashtableElement(10)); // coloca no slot indexado com
													// 0
		table1.insert(new HashtableElement(15)); // coloca no slot indexado com
													// 5
		table1.insert(new HashtableElement(2)); // coloca no slot indexado com 2
		table1.insert(new HashtableElement(12)); // coloca no slot indexado com
													// 8, teve 2 colisoes
		table1.insert(new HashtableElement(4)); // coloca no slot indexado com 4
		table1.insert(new HashtableElement(8));

        table1.remove(new HashtableElement(17));
        table1.remove(new HashtableElement(12));
        table1.search(new HashtableElement(12));

        System.out.println(table1.indexOf(new HashtableElement(10)));
    }
}
