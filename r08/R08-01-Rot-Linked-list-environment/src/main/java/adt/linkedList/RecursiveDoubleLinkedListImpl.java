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
				posteriorElement.setNext(this.getNext());
				this.setData(element);
				

				afterPosteriorElement.setData(posteriorElement.getNext().getData());
				afterPosteriorElement.setNext(posteriorElement.getNext().getNext());
				afterPosteriorElement.setPrevious(posteriorElement);

				this.setNext(posteriorElement);
				this.getNext().setNext(afterPosteriorElement);
				
			}
		}
		
	}

	@Override
	public void removeFirst() {
		
		if(!this.isEmpty())
		{
			if (size() == 1)
			{
				this.setData(null);
			}
			else
			{
				RecursiveDoubleLinkedListImpl<T> previousElement = new RecursiveDoubleLinkedListImpl<>();

				previousElement.setData(this.getNext().getNext().getData());
				previousElement.setNext(this.getNext().getNext().getNext());

				this.setData(this.getNext().getData());
				previousElement.setPrevious(this);

				this.setNext(previousElement);
				
			}
		}
	}

	@Override
	public void removeLast() {
		if (this.isEmpty())
		{
			if(this.getPrevious().getPrevious() == null && this.getPrevious().getData() != null)
			{
				this.getPrevious().setData(null);
			}
			else if(this.getPrevious().getData() != null)
			{
				this.getPrevious().getPrevious().setNext(this);
				this.setPrevious(this.getPrevious().getPrevious());
			}
		}
		else
		{
			RecursiveDoubleLinkedListImpl<T> newNext = new RecursiveDoubleLinkedListImpl<T>();
			newNext.setData(this.getNext().getData());
			newNext.setNext(this.getNext().getNext());
			newNext.setPrevious(this);

			this.setNext(newNext);

			((RecursiveDoubleLinkedListImpl<T>)this.next).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
