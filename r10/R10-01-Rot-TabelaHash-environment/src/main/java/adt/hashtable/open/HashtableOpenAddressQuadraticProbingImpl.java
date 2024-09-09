package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull())
		{
			throw new HashtableOverflowException();
		}

		int probe = 0;
			int myHashCode = ((HashFunctionQuadraticProbing)hashFunction).hash(element, 0);
			while (!(table[myHashCode] instanceof DELETED) 
					&& table[myHashCode] != null 
					&& probe != table.length - 1)
			{
				myHashCode = ((HashFunctionQuadraticProbing)hashFunction).hash(element, ++probe);
				COLLISIONS++;
			}	
			if(probe != table.length - 1)
			{
				table[myHashCode] = element;
			}
			elements++;
	}

	@Override
	public void remove(T element) {
		if(!isEmpty())
		{
			int probe = 0;
			int myHashCode = ((HashFunctionQuadraticProbing)hashFunction).hash(element, probe);

			while(table[myHashCode] != null &&
			 	!table[myHashCode].equals(element) &&
			 	probe != table.length - 1)
			{
				COLLISIONS++;
				myHashCode = ((HashFunctionQuadraticProbing)hashFunction).hash(element, ++probe);

			}
			if (probe != table.length - 1 && table[myHashCode] != null)
			{
				DELETED del = new DELETED();
				table[myHashCode] = del;
				elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		int probe = 0;
		int myHashCode = ((HashFunctionQuadraticProbing)hashFunction).hash(element, probe);
		T myElement = null;

		while (table[myHashCode] != null && !table[myHashCode].equals(element) && probe != table.length) 
		{
			myHashCode = ((HashFunctionQuadraticProbing)hashFunction).hash(element, ++probe);
		}
		if(table[myHashCode] != null && probe != table.length)
		{
			myElement = (T)table[myHashCode];
		}

		return myElement;
	}

	@Override
	public int indexOf(T element) {
		int prob = 0;
		int myHashCode = ((HashFunctionQuadraticProbing)hashFunction).hash(element, prob);

		while (table[myHashCode] != null && !table[myHashCode].equals(element))
		{
			myHashCode = ((HashFunctionQuadraticProbing)hashFunction).hash(element, ++prob);
		}
		if (table[myHashCode] == null)
		{
			myHashCode = -1;
		}

		return myHashCode;
	}
}
