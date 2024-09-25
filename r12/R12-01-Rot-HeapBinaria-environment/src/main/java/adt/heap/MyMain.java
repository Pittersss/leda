package adt.heap;

import java.util.Comparator;

import adt.heap.extended.FloorCeilHeapImpl;
import orderStatistic.OrderStatisticsHeapImpl;

public class MyMain {
    public static void main(String[] args) {
        Heap<Integer> heap;
        Comparator<Integer> comparator = new  ComparatorMaxHeap<Integer>();
        FloorCeilHeapImpl floorEceil = new FloorCeilHeapImpl(comparator);
        //System.out.println(comparator.compare(1, 2));
		heap = new HeapImpl<Integer>(comparator);
        
        Integer[] array = {};
        heap.buildHeap(array);

        System.out.println(floorEceil.floor(array, 6));

    }


    

    
}
