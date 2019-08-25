/*
Helen Li
December 15, 2017
*/

@SuppressWarnings("unchecked")
public class ArrayStack<E> implements BoundedStackInterface<E>
{
	protected final int CAPACITY = 100;
	protected E[] stack;
	protected int topIndex = -1;

	public ArrayStack()
	{
		stack = (E[]) new Object[CAPACITY];
	}

	public ArrayStack(int maxSize)
	{
		stack = (E[]) new Object[maxSize];
	}

	public boolean isEmpty()
	{
		if (topIndex == -1)
			return true;
		else
			return false;
	}

	public boolean isFull()
	{
		if (topIndex == (stack.length - 1))
			return true;
		else
			return false;
	}
	
	public void push(E element) throws StackOverflowException
	{
		if (!isFull())
		{
			topIndex++;
			stack[topIndex] = element;
		}
		else
			throw new StackOverflowException("Push attempted on a full stack.");
	}

	public void pop()
	{
		if (!isEmpty())
		{
			stack[topIndex] = null;
			topIndex--;
		}
		else
			throw new StackUnderflowException("Pop attempted on an empty stack.");
	}

	public E top()
	{
		E topOfStack = null;
		if (!isEmpty())
		{
			topOfStack = stack[topIndex];
			return topOfStack;
		}
		else
			throw new StackUnderflowException("Top attempted on an empty stack.");
	}
}
