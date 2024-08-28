package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if (element != null)
		{
			if (this.isEmpty())
			{
				this.setData(data);
				this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			}
			else
			{
				this.previous.insertFirst(element);
			}
		}
		
	}

	@Override
	public void removeFirst() {
		
		if(this.isEmpty())
		{
			RecursiveDoubleLinkedListImpl<T> newHead = new RecursiveDoubleLinkedListImpl<T>();
			newHead.setData(this.getNext().getNext().getData());
			newHead.setPrevious(this);
			newHead.setNext(this.getNext().getNext().getNext());
			this.setNext(newHead);
		}
		else
		{
			((RecursiveDoubleLinkedListImpl<T>)this.next).removeFirst();
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
