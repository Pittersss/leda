package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.linkedList.DoubleLinkedListImpl;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackDoubleLinkedListImpl<Integer>(4);
		stack2 = new StackDoubleLinkedListImpl<Integer>(2);
		stack3 = new StackDoubleLinkedListImpl<Integer>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop1() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testTop2() throws StackOverflowException {
		stack1.push(4);
		assert stack1.top() == 4;
	}

	@Test
	public void testTop3() throws StackOverflowException, StackUnderflowException {
		stack1.push(4);
		stack1.pop();
		stack1.pop();
		assert stack1.top() == 2;
	}

	@Test
	public void testIsEmpty1() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsEmpty2s() {
		assert stack3.isEmpty();
	}

	@Test
	public void testIsFull1() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testIsFull2() {
		assert stack2.isFull(); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack2.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
										// permitir outra insercao
	}

	@Test
	public void testPop1() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPop2() {
		try {
			stack1.pop();
			stack1.pop();
			assert stack1.pop() == 1;
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPop3() {
		try {
			stack1.pop();
			stack1.pop();
			stack1.pop();
			assert stack1.pop() == null;
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack3.pop()); // levanta excecao apenas se
													// stack1 for vazia
	}
	
	@Test (expected = StackUnderflowException.class)
	public void testSucessivosPopComErro() throws StackUnderflowException {
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
	}
}