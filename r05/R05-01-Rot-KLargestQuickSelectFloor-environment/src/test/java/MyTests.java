import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargest;
import orderStatistic.KLargestOrderStatisticsImpl;
import orderStatistic.QuickSelect;
import problems.FloorBinarySearchImpl;

public class MyTests 
{
    private Integer[] vetorTamPar;
    private Integer[] vetorTamParNegativos;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
    private FloorBinarySearchImpl floorBinarySearch;
    private QuickSelect<Integer> quickSelect;
    //private KLargestOrderStatisticsImpl<Integer> kLargest;


    @Before
    public void setUp()
    {
        vetorTamPar = new Integer[]{ 30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
        vetorTamImpar = new Integer[]{ 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
        vetorValoresRepetidos = new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 };
        vetorTamParNegativos = new Integer[] { -30, -28, -7, -29, -11, -26, -4, -22, -23, -31};
        vetorValoresIguais = new Integer[] { 6, 6, 6, 6, 6, 6 };
        floorBinarySearch = new FloorBinarySearchImpl();
        quickSelect = new QuickSelect<Integer>();
       
    } 
    @Test
    public void QuickSortTest()
    {
        Integer[] arrayOrdenado = {6, 41, 32, 7, 4, 11, 18, 26 ,36, 37, 49};
        Integer[] arrayOrdenado2 = vetorTamImpar.clone();
        Arrays.sort(arrayOrdenado2);
        floorBinarySearch.QuickSortMedianOfThree(vetorTamImpar, 4, vetorTamImpar.length - 1);
        
        assertArrayEquals(arrayOrdenado, vetorTamImpar);
    }
    @Test
    public void FloorVetorParTest()
    {
        assert floorBinarySearch.floor(vetorTamPar, 32) == 31;
    }
    @Test
    public void FloorVetorImparTest()
    {
        assert floorBinarySearch.floor(vetorTamImpar, 7) == 7;
    }
    @Test
    public void FloorVetorParValorNegativoTest()
    {
        assert floorBinarySearch.floor(vetorTamParNegativos, -27) == -28;
    }

    @Test
    public void FloorVetorParNaoExisteTest()
    {
        assert floorBinarySearch.floor(vetorTamPar, 3) == null;
    }

    @Test
    public void orderStatisticsVetorPar1()
    {
        KLargestOrderStatisticsImpl<Integer> kLargest = new KLargestOrderStatisticsImpl<Integer>();
        Integer[] vetorMaiores = new Integer[]{31};
        assertArrayEquals(kLargest.getKLargest(vetorTamPar, 1), vetorMaiores);
    }

    @Test
    public void orderStatisticsVetorPar2()
    {
        KLargestOrderStatisticsImpl<Integer> kLargest = new KLargestOrderStatisticsImpl<Integer>();
        Integer[] vetorMaiores = new Integer[]{31, 30};
        assertArrayEquals(kLargest.getKLargest(vetorTamPar, 2), vetorMaiores);
    }

    @Test
    public void orderStatisticsVetorPar3()
    {
        KLargestOrderStatisticsImpl<Integer> kLargest = new KLargestOrderStatisticsImpl<Integer>();
        Integer[] vetorMaiores = new Integer[]{31, 30, 29};
        assertArrayEquals(kLargest.getKLargest(vetorTamPar, 3), vetorMaiores);
    }

    @Test
    public void orderStatisticsVetorPar4()
    {
        KLargestOrderStatisticsImpl<Integer> kLargest = new KLargestOrderStatisticsImpl<Integer>();
        Integer[] vetorMaiores = new Integer[]{31, 30, 29, 28};
        assertArrayEquals(kLargest.getKLargest(vetorTamPar, 4), vetorMaiores);
    }

    // {4,7,11,22,23,26,28,29,30,31}
    @Test
    public void orderStatisticsVetorPar5()
    {
        KLargestOrderStatisticsImpl<Integer> kLargest = new KLargestOrderStatisticsImpl<Integer>();
        Integer[] vetorMaiores = new Integer[]{31, 30, 29, 28, 26};
        assertArrayEquals(kLargest.getKLargest(vetorTamPar, 5), vetorMaiores);
    }

    @Test
    public void orderStatisticsVetorParFinal()
    {
        KLargestOrderStatisticsImpl<Integer> kLargest = new KLargestOrderStatisticsImpl<Integer>();
        Integer[] vetorMaiores = new Integer[]{31, 30, 29, 28, 26, 23, 22, 11, 7, 4};
        assertArrayEquals(kLargest.getKLargest(vetorTamPar, vetorTamPar.length), vetorMaiores);
    }

    @Test
    public void orderStatisticsVetorElementosIguais()
    {
        KLargestOrderStatisticsImpl<Integer> kLargest = new KLargestOrderStatisticsImpl<Integer>();
        Integer[] vetorMaiores = new Integer[]{6, 6, 6, 6, 6, 6};
        assertArrayEquals(kLargest.getKLargest(vetorValoresIguais, vetorValoresIguais.length), vetorMaiores);
    }

    @Test
    public void orderStatisticsUmAMais()
    {
        KLargestOrderStatisticsImpl<Integer> kLargest = new KLargestOrderStatisticsImpl<Integer>();
        Integer[] vetorVazio = new Integer[]{};
        assertArrayEquals(kLargest.getKLargest(vetorTamPar, 11), vetorVazio);
    }

    // {4,7,11,22,23,26,28,29,30,31};
    @Test
    public void QuickSelectBaseTest()
    {
        assert quickSelect.quickSelect(vetorTamPar, 1) == 4;
    }

    @Test
    public void QuickSelectEndOfArrayTest()
    {
        assert quickSelect.quickSelect(vetorTamPar, vetorTamPar.length) == 31;
    }

    @Test
    public void QuickSelectMiddleOfArrayTest()
    {
        assert quickSelect.quickSelect(vetorTamPar, 4) == 22;
    }

    @Test
    public void QuickSelectKIgualAZeroTest()
    {
        assert quickSelect.quickSelect(vetorTamPar, 0) == null;
    }

    @Test
    public void QuickSelectKNegativoTest()
    {
        assert quickSelect.quickSelect(vetorTamPar, -1) == null;
    }

    @Test
    public void QuickSelectKMaiorQueOArrayTest()
    {
        assert quickSelect.quickSelect(vetorTamPar, 11) == null;
    }

    @Test
    public void QuickSelectVetorNuloTest()
    {
        assert quickSelect.quickSelect(vetorVazio, 1) == null;
    }

    @Test
    public void QuickSelectVetorValoresRepetidos3()
    {
        assert quickSelect.quickSelect(vetorValoresRepetidos, 6) == 4;
    }

    @Test
    public void QuickSelectVetorValoresRepetidos2()
    {
        assert quickSelect.quickSelect(vetorValoresRepetidos, 5) == 4;
    }

    @Test
    public void QuickSelectVetorValoresRepetidos1()
    {
        assert quickSelect.quickSelect(vetorValoresRepetidos, 4) == 4;
    }

    @Test
    public void QuickSelectVetorValoresDepoisRepetidos()
    {
        assert quickSelect.quickSelect(vetorValoresRepetidos, 7) == 5;
    }
    @Test
    public void QuickSelectVetorNegativo()
    {
        assert quickSelect.quickSelect(vetorTamParNegativos, 1) == -31;
    }
}
