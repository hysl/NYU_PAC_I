/*
Helen Li
December 15, 2017
*/

public interface StackInterface<E>
{
	void pop() throws StackUnderflowException;

	E top() throws StackUnderflowException;

	boolean isEmpty();
}
