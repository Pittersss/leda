package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (element != null)
		{
			if (!isFull())
			{
				array[++top] = element;
			}
		else { throw new StackOverflowException(); }
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (top == -1)
			throw new StackUnderflowException();
			
		T aux = null; 
		aux = array[top--];
		return aux;
		
	}


}
