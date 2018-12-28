import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class OccurrenceSet<T> implements Set<T>
{
	private HashMap<T, Integer> hashmap = new HashMap<T, Integer>();

	@Override
	public int size()
	{
		return hashmap.size();
	}

	@Override
	public boolean isEmpty()
	{
		if (hashmap.isEmpty())
		{
			return true;
		} else
		{
			return false;
		}
	}

	@Override
	public boolean contains(Object o)
	{
		return hashmap.keySet().contains(o);
	}

	private ArrayList<T> key_array()
	{
		ArrayList<T> array = new ArrayList<T>(hashmap.keySet());
		Collections.sort(array, new Comparator<T>()
		{

			public int compare(T o1, T o2)
			{
				return hashmap.get(o1).compareTo(hashmap.get(o2));
			}
		});
		return array;

	}

	@Override
	public Iterator<T> iterator()
	{
		class iterator<T> implements Iterator
		{
			ArrayList<T> array1;
			int position = 0;

			public iterator()
			{
				array1 = new ArrayList(hashmap.keySet());
			}

			@Override
			public boolean hasNext()
			{
				position++;
				if (position == array1.size())
				{
					return false;
				} else
				{
					return true;
				}
			}

			@Override
			public Object next()
			{
				position++;
				if (array1.get(position) != null)
				{
					return hashmap.get(position);
				}
				return null;
			}

			@Override
			public void remove()
			{
				if (array1.get(position) != null)
				{
					hashmap.remove(position);
					array1.remove(position);
				}
			}
		}
		iterator<T> iter = new iterator<T>();
		return iter;
	}

	@Override
	public Object[] toArray()
	{
		return key_array().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		return key_array().toArray(a);
	}

	@Override
	public boolean add(T e)
	{
		Integer current_entry = hashmap.get(e);
		if (current_entry == null)
		{
			hashmap.put(e, 1); //
		} else
		{
			hashmap.put(e, current_entry + 1);
		}
		return hashmap.keySet().contains(e);
	}

	@Override
	public boolean remove(Object o)
	{
		Integer current_entry = hashmap.get(o);
		if (current_entry != null)
		{
			hashmap.remove(o);
		}
		return !hashmap.keySet().contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return hashmap.keySet().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		boolean modified = false;
		for (T el : c)
		{
			if (add(el))
				modified = true;
		}
		return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		Integer begin_size = hashmap.size();
		HashMap<T, Integer> new_hashmap = new HashMap<T, Integer>();
		for (Object element : c)
		{
			if (hashmap.keySet().contains(element))
			{
				new_hashmap.put((T) element, hashmap.get(element));
			}
		}
		Integer end_size = new_hashmap.size();
		hashmap = new_hashmap;
		if (begin_size != end_size)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) //
	{
		boolean modified1 = false;
		for (Object el1 : c)
		{
			if (remove(el1))
			{
				modified1 = true;
			}
		}
		return modified1;
	}

	@Override
	public void clear()
	{
		hashmap.clear();

	}

	public String toString()
	{

		return key_array().toString();
	}

}
