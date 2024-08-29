package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) { throw new StackOverflowException(); }
		top.insert(element);

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) { throw new StackUnderflowException(); }

		T myElement = ((DoubleLinkedListImpl<T>)top).getLast().getData();
		top.removeLast();

		return myElement;
	}

	@Override
	public T top() {
		T myElement = ((DoubleLinkedListImpl<T>)top).getLast().getData();
		return myElement;
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return top.size() == size;
	}

}
