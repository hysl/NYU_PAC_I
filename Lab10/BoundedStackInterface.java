/*
Helen Li
December 15, 2017
*/

public interface BoundedStackInterface<E> extends StackInterface<E>
{
	void push(E element) throws StackOverflowException;

	boolean isFull();
}
