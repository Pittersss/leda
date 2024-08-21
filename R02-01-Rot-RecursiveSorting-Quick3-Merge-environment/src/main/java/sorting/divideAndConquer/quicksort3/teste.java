package sorting.divideAndConquer.quicksort3;

import sorting.divideAndConquer.MergeSort;

public class teste {
    public static void main(String[] args)
    {
        MergeSort<Integer> m = new MergeSort<Integer>();
        Integer[] array = {2,9,0,-1,5,-8,4,5,6};

        m.sort(array, 0, 8);

        for (int i : array)
        {
            System.out.println(i);
        }
    }
}
