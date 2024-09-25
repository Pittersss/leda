package adt.heap.extended;

import java.util.Comparator;

import adt.heap.ComparatorMaxHeap;
import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer myFloor = null;
		for (Integer element : array)
		{
			insert(element);
		}
		
		if (comparator instanceof ComparatorMaxHeap)
		{
			while (!isEmpty() && rootElement().compareTo((int)numero) > 0)
			{
				extractRootElement();
				
			}
			myFloor = rootElement();
		}
		else{
			while(!isEmpty() && rootElement().compareTo((int)numero) <= 0)
			{
				myFloor = rootElement();
				extractRootElement();
			}
		}
		
		return myFloor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer myCeil = null;
		for (Integer element : array)
		{
			insert(element);
		}

		if (comparator instanceof ComparatorMaxHeap)
		{
			while(!isEmpty() && rootElement().compareTo((int)numero) > 0)
			{
				myCeil = extractRootElement();
			}

			if (!isEmpty() && myCeil.compareTo((int)numero) == 0)
			{
				int myRoot = rootElement();
				if(numero - (double)myRoot == 0.0)
				{
					myCeil = myRoot;
				}
			}
		}
		else{
			while(!isEmpty() && rootElement().compareTo((int)numero) < 0)
			{
				extractRootElement();
			}
			myCeil = extractRootElement();
			if (!isEmpty() && myCeil.compareTo((int)numero) == 0)
			{
				if((double)myCeil - numero != 0)
				{
					myCeil = extractRootElement();
				}
			}
		}
		return myCeil;
	}

}
