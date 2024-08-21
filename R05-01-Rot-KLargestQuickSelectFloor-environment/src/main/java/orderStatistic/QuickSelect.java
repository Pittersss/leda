package orderStatistic;

import util.*;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento
	 *            este array normalmente nao esta ordenado
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 *
	 */
	public T quickSelect(T[] array, int k) 
	{
		T kElement = null;
		if (k > 0 && array.length != 0 && array.length >= k)
		{
			kElement = quickSelectOrderStatisctics(array, 0, array.length - 1, k);
		}

		return kElement;
		
	}
	public T quickSelectOrderStatisctics(T[] array, int leftIndex, int rightIndex, int k)
	{
		T element = null;

		if (leftIndex > rightIndex)
		{
		}
		else
		{
			int pivotIndex;
			if (leftIndex == rightIndex)
			{
 				pivotIndex = leftIndex;
			}
			else{
				pivotIndex = partition(array, rightIndex, leftIndex);
			}
			
			if (pivotIndex + 1 > k)
			{
				element = quickSelectOrderStatisctics(array, leftIndex, pivotIndex - 1, k);
			}
			else if (pivotIndex + 1 < k)
			{
				element = quickSelectOrderStatisctics(array, pivotIndex + 1, rightIndex, k);
			}
			else if (pivotIndex + 1 == k)
			{
				element = array[pivotIndex];
			}
		}
		
		return element;
	}

	public int partition(T[] array, int rightIndex, int leftIndex)
	{
		MedianOfThree(array, leftIndex, rightIndex);

		T pivot = array[rightIndex - 1];
		int swapedIndex = rightIndex - 1;

		if (swapedIndex != leftIndex)
		{
			for (int i = swapedIndex - 1; i >= leftIndex; i--)
			{
				if (array[i].compareTo(pivot) >= 0)
				{
					swapedIndex--;
					Util.swap(array, swapedIndex, i);
				}
			}
		}

		Util.swap(array, rightIndex - 1, swapedIndex);

		return swapedIndex;
	}

	public void MedianOfThree(T[] array, int leftIndex, int rightIndex)
	{
		int middle = (leftIndex + rightIndex)/2;
		if (array[leftIndex].compareTo(array[middle]) > 0)
		{
			Util.swap(array, leftIndex, middle);
		}
		if (array[leftIndex].compareTo(array[rightIndex]) > 0)
		{
			Util.swap(array, rightIndex, leftIndex);
		}
		if (array[middle].compareTo(array[rightIndex]) > 0)
		{
			Util.swap(array, rightIndex, middle);
		}

		Util.swap(array, middle, rightIndex - 1);
	}
	
}