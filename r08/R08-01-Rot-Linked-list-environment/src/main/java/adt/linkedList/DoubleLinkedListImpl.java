package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl()
	{
		this.head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) 
	{
		DoubleLinkedListNode<T> newElement = new DoubleLinkedListNode<T>();
		newElement.setData(element);
		newElement.setNext(getHead());
		newElement.setPrevious(new DoubleLinkedListNode<T>());
		if (head.isNIL())
		{
			setLast(newElement);
		}
		this.setHead(newElement);
		((DoubleLinkedListNode<T>)this.getHead().next).setPrevious(newElement);

	}

	@Override
	public void removeFirst() {
		if(!isEmpty())
		{
			this.setHead(getHead().getNext());
			getHead().setPrevious(new DoubleLinkedListNode<T>());
		}
	}		

	@Override
	public void removeLast() {
		if (!isEmpty())
		{
			setLast(getLast().getPrevious());
			getLast().setNext(new DoubleLinkedListNode<T>());
		}
		
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

	@Override
	public DoubleLinkedListNode<T> getHead()
	{
		DoubleLinkedListNode<T> myHead = new DoubleLinkedListNode<T>();
		myHead.data = this.head.data;
		myHead.next = this.head.next;

		return myHead;
	}

	@Override 
	public void insert(T element) 
	{
		DoubleLinkedListNode<T> newElement = new DoubleLinkedListNode<T>();
		if(isEmpty())
		{
			newElement.setData(element);
			newElement.setNext(new DoubleLinkedListNode<T>());
			newElement.setPrevious(new DoubleLinkedListNode<T>());
			setLast(newElement);
			setHead(newElement);
		}
		else
		{
			newElement.setData(element);
			newElement.setNext(new DoubleLinkedListNode<T>());
			getLast().setNext(newElement);
			newElement.setPrevious(getLast());
			setLast(newElement);
		}
	}

}
