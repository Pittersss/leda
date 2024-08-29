package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (list.size() == size) { throw new QueueOverflowException(); }

		list.insert(element);
	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if(list.isEmpty()) { throw new QueueUnderflowException(); }

		T myElement = ((DoubleLinkedListImpl<T>)list).getHead().getData();
		list.removeFirst();

		return myElement;
	}

	@Override
	public T head() {
		return ((DoubleLinkedListImpl<T>)list).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() == this.size;
	}

}
