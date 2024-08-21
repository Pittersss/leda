package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		for (int j = leftIndex; j < rightIndex + 1; j++)
		{
			util.Util.swap(array, j, getSmallerIndex(array, j, rightIndex));
		}
		
	}

	public int getSmallerIndex(T[] array, int startIndex, int endIndex)
	{
		int smallerIndex = startIndex;
		for (int i = startIndex; i < endIndex + 1; i++)
		{
			if (array[i].compareTo(array[smallerIndex]) < 0) { smallerIndex = i; }
		}

		return smallerIndex;
	}
}
