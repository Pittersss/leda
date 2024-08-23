package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull())
        {
			if(tail == -1)
				head = 0;
				
            tail = (tail + 1) % array.length;
			array[tail] = element;
			elements++;
        }
        else
        {
            throw new QueueOverflowException();
        }
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
		{
			throw new QueueUnderflowException();
		}
		
		T aux = array[head];
		head = (head + 1) % array.length;
		elements--;
		if (isEmpty()) 
		{
			tail = -1;
			head = -1;	
		}
		return aux;
        
	}

	@Override
	public T head() {
		T myHead = null;
		if (!isEmpty())
			myHead = array[head];

		return myHead;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
