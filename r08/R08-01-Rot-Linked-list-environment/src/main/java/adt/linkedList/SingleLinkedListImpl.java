package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int counter = 0;
		SingleLinkedListNode<T> auxHead = new SingleLinkedListNode<>();
		auxHead = head;
		while(auxHead != null && !auxHead.isNIL())
		{
			counter++;
			auxHead = auxHead.getNext();
		}

		return counter;
	}

	@Override
	public T search(T element) {
		T myElement = null;
		SingleLinkedListNode<T> auxHead = new SingleLinkedListNode<>();
		auxHead = head;
		while (!auxHead.isNIL())
		{
			if (auxHead.data.equals(element))
			{
				myElement = auxHead.data;
				break;
			}
			auxHead = auxHead.getNext();
		}
		return myElement;

	}

	@Override
	public void insert(T element) {
		if (head.isNIL())
		{
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>();
			newHead.data = element;
			newHead.next = head;
			head = newHead;
		}
		else
		{
			SingleLinkedListNode<T> auxHead = new SingleLinkedListNode<T>();
			auxHead = head;

			while(!auxHead.isNIL())
			{
				auxHead = auxHead.next;
			}

			auxHead.setData(element);
			auxHead.next = new SingleLinkedListNode<T>();
		}
		
	}

	@Override
	public void remove(T element) {
	
		if (!isEmpty())
		{
			if(head.data.equals(element))
			{
				head = head.next;
			}
			else
			{
				SingleLinkedListNode<T> auxHead = new SingleLinkedListNode<T>();
				auxHead = head;

				while(!auxHead.isNIL() && !auxHead.data.equals(element))
				{
					auxHead = auxHead.next;
				}

				auxHead.data = auxHead.next.data;
				auxHead.next = auxHead.next.next;
			}
		}
		
	}

	@Override
	public T[] toArray() {
		T[] myList = (T[]) new Comparable[size()];
		SingleLinkedListNode<T> auxHead = new SingleLinkedListNode<T>();
		auxHead = head;
		int i = 0;
		while (!auxHead.isNIL())
		{
			myList[i++] = auxHead.data;
			auxHead = auxHead.next;
		}

		return myList;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
