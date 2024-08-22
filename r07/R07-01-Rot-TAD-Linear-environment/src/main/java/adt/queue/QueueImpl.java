package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

	private void shiftLeft() 
	{
		for (int i = 1; i < array.length; i++)
		{
			if(array[i] != null)
			{
				T aux = array[i - 1];
				array[i - 1] = array[i];
				array[i] = aux;
			}
		}	
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!isFull())
		{
			array[++tail] = element;
		}
		else
		{
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty())
		{
			T aux = array[0];
			array[0] = null;
			shiftLeft();
			return aux;
		}
		else
		{
			throw new QueueUnderflowException();
		}
		
	}

}
