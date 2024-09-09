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
		SingleLinkedListNode<T> auxHead = new SingleLinkedListNode<T>();
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

	public void inverseLinkedList(SingleLinkedListNode<T> head)
	{
		int mySize = getSize(head) - 1;
		int index = mySize;
		SingleLinkedListNode<T> aux = head;

		while (mySize != 0)
		{
			
			while(index != 0)
			{
			if (!aux.getNext().isNIL())
			{
				T headData = head.getData();
				head.setData(head.getNext().getData());
				head.getNext().setData(headData);
			}
				head = head.getNext();
				index--;                                                           
			}
			head = aux;
			mySize--;
			index = mySize;
		}
		
	}

	public Integer middleOfSingleLinkedList(SingleLinkedListNode<T> head)
	{
		int size = getSize(head);
		SingleLinkedListNode<T> aux = head;

		head = aux;

		if (size % 2 != 0)
		{
			size /= 2;
		}
		else{
			size = (size/2) + 1;
		}

		int i = 0;
		while(i != size){
			head = head.getNext();
			i++;
		}
		return size;
	}

	public int getSize(SingleLinkedListNode<T> head)
	{
		int size = 0;
		while (!head.isNIL()) 
		{
			head = head.getNext();
			size++;
		}
		return size;
	}
	public T mergeTwoSingleLinkedList(SingleLinkedListNode<Integer> node1, SingleLinkedListNode<Integer> node2)
	{
		SingleLinkedListNode<Integer> maior = node2;
		SingleLinkedListNode<Integer> menor = node1;
		
		if (node1.getData() >= node2.getData())
		{
			maior = node1;
			menor = node2;
		}
		
		SingleLinkedListNode<Integer> headAux = menor;

		while (!maior.isNIL())
		{
			if (menor.isNIL() || maior.getData() <= menor.getData())
			{
				SingleLinkedListNode<T> newElement = new SingleLinkedListNode<T>();

				menor.setNext(maior);
				menor.getNext().setNext(menor.getNext());
				maior = maior.getNext();
			}
		}


	}
	

}
