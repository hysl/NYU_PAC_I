/*
Helen Li
December 20, 2017
*/

import java.util.*;

@SuppressWarnings("unchecked")
public class Set<E>
{
	private E[] data;
	private int size;

	public Set()
	{
		data = (E[]) new Object[10];
		size = 0;
	}

	public Set(E[] data)
	{
		this.data = data;
		this.size = data.length;
		removeDuplicates(data);
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public boolean add(E e)
	{
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] == e)
				return false;
		}
		
		data[size] = e;
		size++;
		return true;
	}

	public int size()
	{
		return size;
	}

	public E remove(E e)
	{
		if (size == 0)
			return null;

		for (int i = 0; i < size; i++)
		{
			if (data[i] == e)
			{
				int indexOfE = i;
				E temp = data[i];
				for (int j = indexOfE + 1; j < size; indexOfE++)
				{
					data[j - 1] = data[j];
				}
				size--;
				return temp;
			}
		}
		return null;
	}

	public boolean contains(E e)
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i] == e)
			{
				return true;
			}
		}
		return false;
	}

	public String toString()
	{
		String string = "";
		
		if (size == 0)
		{
			string += "Set is empty!";
			return string;
		}
		else
		{
			for (int i = 0; i < size - 1; i++)
			{
				string += data[i] + ", ";
			}
			string += data[size-1];

			return string;
		}
	}

	private void removeDuplicates(E[] data)
	{
		if (size > 0)
		{
			Arrays.sort(data);

			for (int i = 1; i < size; i++)
			{
				if (data[i] == data[i - 1])
				{
					for (int j = i + 1; j < size; j++)
					{
						data[j - 1] = data[j];
					}
					size--;
					i--;
				}
			}
		}
	}
}
