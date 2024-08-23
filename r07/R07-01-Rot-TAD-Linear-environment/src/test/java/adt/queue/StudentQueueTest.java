package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> normalQueue1;
	public Queue<Integer> normalQueue2;
	public Queue<Integer> normalQueue3;

	public Queue<Integer> circulaQueue1;
	public Queue<Integer> circulaQueue2;
	public Queue<Integer> circulaQueue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila Normal com 3 elementos não cheia.
		normalQueue1.enqueue(1);
		normalQueue1.enqueue(2);
		normalQueue1.enqueue(3);

		// Fila Normal com 2 elementos de tamanho 2. Fila cheia.
		normalQueue2.enqueue(1);
		normalQueue2.enqueue(2);

		// Fila Circular com 3 elementos não cheia.
		circulaQueue1.enqueue(1);
		circulaQueue1.enqueue(2);
		circulaQueue1.enqueue(3);

		// Fila Circular com 2 elementos de tamanho 2. Fila cheia.
		circulaQueue2.enqueue(1);
		circulaQueue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		normalQueue1 = new QueueImpl<Integer>(4);
		normalQueue2 = new QueueImpl<Integer>(2);
		normalQueue3 = new QueueImpl<Integer>(5);

		circulaQueue1 = new CircularQueue<Integer>(4);
		circulaQueue2 = new CircularQueue<Integer>(2);
		circulaQueue3 = new CircularQueue<Integer>(5);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHeadNormalQueue() {
		assertEquals(new Integer(1), normalQueue1.head());
	}

	@Test
	public void testNormalIsEmpty() {
		assertFalse(normalQueue1.isEmpty());
		assertTrue(normalQueue3.isEmpty());
	}

	@Test
	public void testNormalIsFull() {
		assertFalse(normalQueue1.isFull());
	}

	@Test
	public void testNormalEnqueue() {
		try {
			normalQueue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		normalQueue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testNormalDequeue() {
		try {
			assertEquals(new Integer(1), normalQueue1.dequeue());
		} catch (QueueUnderflowException e) {
			fail();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testNormalDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), normalQueue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}

	@Test
	public void headValidation1() throws QueueOverflowException, QueueUnderflowException
	{
		normalQueue1.enqueue(4);
		normalQueue1.dequeue();
		assert normalQueue1.head() == 2;
	}

	@Test
	public void headValidation2() throws QueueOverflowException, QueueUnderflowException
	{
		normalQueue1.enqueue(4);
		normalQueue1.dequeue();
		normalQueue1.dequeue();
		assert normalQueue1.head() == 3;
	}

	@Test
	public void headValidation3() throws QueueOverflowException, QueueUnderflowException
	{
		normalQueue1.enqueue(4);
		normalQueue1.dequeue();
		normalQueue1.dequeue();
		normalQueue1.dequeue();
		assert normalQueue1.head() == 4;
	}
	@Test
	public void headValidation4() throws QueueOverflowException, QueueUnderflowException
	{
		normalQueue1.enqueue(4);
		normalQueue1.dequeue();
		normalQueue1.dequeue();
		normalQueue1.dequeue();
		normalQueue1.dequeue();
		assert normalQueue1.head() == null;
	}

	//Circular Queue Tests

	//Base Tests
	@Test
	public void testHeadCircularQueue() {
		assertEquals(new Integer(1), circulaQueue1.head());
	}

	@Test
	public void testCircularIsEmpty() {
		assertFalse(circulaQueue1.isEmpty());
		assertTrue(circulaQueue3.isEmpty());
	}

	@Test
	public void testCircularIsFull() {
		assertFalse(circulaQueue1.isFull());
	}

	@Test
	public void testCircularEnqueue() {
		try {
			circulaQueue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testCircularEnqueueComErro() throws QueueOverflowException {
		circulaQueue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testCircularDequeue() {
		try {
			assertEquals(new Integer(1), circulaQueue1.dequeue());
		} catch (QueueUnderflowException e) {
			fail();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testCircularDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), circulaQueue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}

	@Test
	public void remocoesSucessivasEAdicoesAteEncher() throws QueueUnderflowException, QueueOverflowException
	{
		circulaQueue1.dequeue();
		circulaQueue1.enqueue(1);
		circulaQueue1.enqueue(1);

		assert circulaQueue1.isFull();
	}
}