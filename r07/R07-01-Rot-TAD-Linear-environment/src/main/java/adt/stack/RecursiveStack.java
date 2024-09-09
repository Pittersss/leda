package adt.stack;

public class RecursiveStack {

    private Integer[] array;
	private int top;
    private int size;

	@SuppressWarnings("unchecked")
	public RecursiveStack(int size) {
        this.size = size;
		array = new Integer[size];
		top = -1;
	}
    

	public Integer top() {
        Integer myTop = null;
        if (top != -1)
        {
            myTop = array[top];
        }
		return myTop;
	}

	
	public boolean isEmpty() {
		return top == -1;
	}

	
	public boolean isFull() {
		return top == array.length - 1;
	}

	
	public void push(Integer element) throws StackOverflowException 
    {
		if (element != null)
		{
			if (!isFull())
			{
				array[++top] = element;
			}
		else { throw new StackOverflowException(); }
		}
	}

	
	public Integer pop() throws StackUnderflowException {
		if (top == -1)
			throw new StackUnderflowException();
			
		Integer aux = null; 
		aux = array[top--];
		return aux;
		
	}

    public Integer getMin() throws StackOverflowException, StackUnderflowException
    {
        Stack<Integer> aux = new StackImpl<Integer>(size);
        Integer smaller = top();
        int i = 0;
        while (!this.isEmpty())
        {
            Integer element = this.pop();
            if (element < smaller)
            {
                smaller = element;

            }
            aux.push(element);
            i++;
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());  
        }

        return smaller;
    }
   
    
}
