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
            array[++tail] = element;
        }
        else if(array[0] == null)
        {
            tail = -1;
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
			T aux = array[++head];
			array[head] = null;
			return aux;
		}
		else{
			head = -1;
			tail = -1;
			throw new QueueUnderflowException();
		}
        
	}

	@Override
	public T head() {
		T myHead = null;
		if (!isEmpty())
			myHead = array[head + 1];

		return myHead;
	}

	@Override
	public boolean isEmpty() {
		return tail == - 1 || head == tail;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1 || head == tail;
	}

}
