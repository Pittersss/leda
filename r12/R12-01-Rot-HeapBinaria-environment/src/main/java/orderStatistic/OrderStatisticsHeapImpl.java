package orderStatistic;

import java.util.PriorityQueue;

import adt.heap.ComparatorMaxHeap;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem. 
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 *   uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null 
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	
	@Override
	public T getOrderStatistics(T[] array, int k) {
		
		T myStatistic = null;
		if (k > 0 && k <= array.length)
		{
			PriorityQueue<T> heap = new PriorityQueue<T>();
			for (T t : array)
			{
				heap.add(t);
			}
			
			for (int i = 0; i < k; i++)
			{
				myStatistic = heap.remove();
			}		
		}

		return myStatistic;
	}

	
	
}
