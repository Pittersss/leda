package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		boolean haveSwap = true;
		
		while (haveSwap) 
		{
			haveSwap = false;
			for (int i = leftIndex ; i < rightIndex ; i++)
			{
				if ( i != array.length - 1 && array[i].compareTo(array[i + 1]) > 0) 
				{ 
					util.Util.swap(array, i + 1, i);
					haveSwap = true;
				}
			}

			for (int j = rightIndex; j > leftIndex ; j--)
			{
				if (array[j].compareTo(array[j - 1]) < 0)
				{
					util.Util.swap(array, j - 1, j);
					haveSwap = true;
				}
			}
		}
		
	}
}
