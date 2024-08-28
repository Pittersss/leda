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
				RecursiveDoubleLinkedListImpl<T> posteriorElement = new RecursiveDoubleLinkedListImpl<T>();
				RecursiveDoubleLinkedListImpl<T> afterPosteriorElement = new RecursiveDoubleLinkedListImpl<T>();
				posteriorElement.setData(this.getData());
				posteriorElement.setPrevious(this);
				posteriorElement.setNext(this.getNext().getNext());
				this.setData(element);

				afterPosteriorElement.setData(this.getNext().getNext().getData());
				afterPosteriorElement.setNext(this.getNext().getNext().getNext());
				this.getNext().setNext(afterPosteriorElement);

				((RecursiveDoubleLinkedListImpl)this.getNext().getNext()).setPrevious(posteriorElement);
				this.setNext(posteriorElement);
				
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
