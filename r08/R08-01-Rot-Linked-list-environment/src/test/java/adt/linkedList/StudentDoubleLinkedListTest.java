package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;
	private	DoubleLinkedList<Integer> lista4;
	private RecursiveDoubleLinkedListImpl<Integer> lista5;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);

		lista5.insert(3);
		lista5.insert(2);
		lista5.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação

		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new SingleLinkedListImpl<Integer>();
		lista3 = new DoubleLinkedListImpl<Integer>();
		lista4 = new DoubleLinkedListImpl<Integer>();
		lista5 = new RecursiveDoubleLinkedListImpl<Integer>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}

	//Métodos Herdados
	@Test
	public void testSize1()
	{
		assert lista1.size() == 3;
	}

	@Test
	public void testSize2()
	{
		((DoubleLinkedList<Integer>) lista1).removeLast();
		assert lista1.size() == 2;
	}

	@Test
	public void testSize3()
	{
		((DoubleLinkedList<Integer>) lista1).removeLast();
		((DoubleLinkedList<Integer>) lista1).removeLast();
		assert lista1.size() == 1;
	}

	@Test
	public void testAdicionandoNoInicioListaVazia()
	{
		lista4.insertFirst(1);
		Assert.assertArrayEquals(new Integer[] {1}, lista4.toArray());
		assert lista4.search(1) ==  1;
	}

	//Recursive

	@Test
	public void testRemoveLastRecursive() {
		lista5.removeLast();
		Assert.assertArrayEquals(new Integer[] {3, 2}, lista5.toArray());
	}
	@Test

	public void testRemoveFirstRecursive() {
		lista5.removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista5.toArray());
	}

	@Test
	public void testInsertFirstRecursive() {
		lista5.removeFirst();
		lista5.insertFirst(4);
		Assert.assertArrayEquals(new Integer[] {4, 2, 1 }, lista5.toArray());
	}
}