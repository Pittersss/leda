package adt.heap;

import java.util.Comparator;

public class ComparatorMaxHeap<T extends Comparable<? super T>> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		int myReturn = 0;
		if (o1.compareTo(o2) < 0)
		{
			myReturn = 1;
		}
		else if (o1.compareTo(o2) > 0)
		{
			myReturn = -1;
		}

		return myReturn;
	}

}
