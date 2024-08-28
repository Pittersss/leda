package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		if (data == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		int counter = 0;

		if (isEmpty())
		{
			counter = 0;
		}
		else
		{
			counter = this.next.size() + 1;
		}
		return counter;
	}

	@Override
	public T search(T element) {
		T myElement = null;
		if (element != null)
		{
			if(isEmpty())
			{}
			else if (this.data.equals(myElement))
			{
				myElement = this.data;
			}
			else
			{
				myElement = this.next.search(myElement);
			}
		}
		return myElement;
	}

	@Override
	public void insert(T element) {
		if (element != null)
		{
			if(isEmpty())
			{
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<T>();
			}
			else
			{
				this.next.insert(element);
			}
		}
		
	}

	@Override
	public void remove(T element) {
		T myElement = null;
		if (isEmpty())
		{}
		else
		{
			if(this.data.equals(element))
			{
				this.setData(next.data);
				this.setNext(getNext().getNext());
			}
			else
			{
				this.next.remove(myElement);
			}
		}
	}

	@Override
	public T[] toArray() {
		java.util.LinkedList<T> myArray = new java.util.LinkedList<T>();
		
		converteArray(myArray, this);
		return (T[]) myArray.toArray();
	}

	private void converteArray(java.util.LinkedList<T> list, RecursiveSingleLinkedListImpl<T> node)
	{
		if(!node.isEmpty()){
			list.add(node.getData());
			converteArray(list, node.getNext());
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
