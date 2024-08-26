package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl()
	{
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>)head;
		
	}

	@Override
	public void insertFirst(T element) 
	{
		DoubleLinkedListNode<T> newElement = new DoubleLinkedListNode<T>();
		newElement.setData(element);
		newElement.setNext(getHead());
		newElement.setPrevious(new DoubleLinkedListNode<T>());
		((DoubleLinkedListNode<T>)this.getHead()).setPrevious(newElement);
		if (head.isNIL())
		{
			setLast(newElement);
		}
		setHead(newElement);
		
		this.getHead();
		
		
		

	}

	@Override
	public void removeFirst() {
		head = head.next;
		
	}

	@Override
	public void removeLast() {
		last = last.previous;
		last.next = new DoubleLinkedListNode<T>();
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
