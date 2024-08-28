package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl()
	{
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) 
	{
		if (element != null)
		{
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());

			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>();

			aux.setData(getHead().getData());
			aux.setNext(getHead().getNext());
			aux.setPrevious(newHead);
			newHead.setNext(aux);

			if (head.isNIL())
			{
				this.setLast(newHead);
			}

			this.setHead(newHead);
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty())
		{
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>();
			newHead.setData(getHead().getNext().getData());
			newHead.setNext(getHead().getNext().getNext());
			newHead.setPrevious(new DoubleLinkedListNode<T>());

			this.setHead(newHead);
		}
	}		

	@Override
	public void removeLast() {
		if (!isEmpty())
		{
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>();

			newLast.setData(getLast().getPrevious().getData());
			newLast.setNext(new DoubleLinkedListNode<T>());
			newLast.setPrevious(getLast().getPrevious().getPrevious());
			getLast().getPrevious().getPrevious().setNext(newLast);
			
			this.setLast(newLast);
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
