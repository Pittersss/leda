package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		int middle = (rightIndex + leftIndex)/2;

		if (leftIndex >= rightIndex)
		{}
		else{
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
		
		
	}
	public void merge(T[] array, int leftIndex , int middle , int rightIndex)
	{
		T[] copyArray = (T[]) new Comparable[array.length];
		for (int z = leftIndex; z < rightIndex + 1; z++)
		{
			copyArray[z] = array[z];
		}

		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while(i <= middle && j <= rightIndex)
		{
			if(copyArray[i].compareTo(copyArray[j]) <= 0)
			{
				array[k] = copyArray[i];
				i++;
			}
			else{
				array[k] = copyArray[j];
				j++;
			}
			k++;
		}

		while (i <= middle)
		{
			array[k] = copyArray[i];
			i++;
			k++;
		}
		
	}
}
