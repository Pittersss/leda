package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;
	protected int elementsIn;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
		this.elementsIn = 0;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) { throw new StackOverflowException(); }
		elementsIn++;
		top.insert(element);

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) { throw new StackUnderflowException(); }

		T myElement = ((DoubleLinkedListImpl<T>)top).getLast().getData();
		top.removeLast();
		elementsIn--;
		return myElement;
	}

	@Override
	public T top() {
		T myElement = ((DoubleLinkedListImpl<T>)top).getLast().getData();
		return myElement;
	}

	@Override
	public boolean isEmpty() {
		return elementsIn == 0;
	}

	@Override
	public boolean isFull() {
		return elementsIn == size;
	}

}
