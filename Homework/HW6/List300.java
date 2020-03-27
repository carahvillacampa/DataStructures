package hw6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface List300<T> extends Iterable<T> {
	public boolean add(T item);
	public boolean add(int idx, T item);
	public T set(int idx, T item); // return previous item at that idx
	public boolean contains(T item);
	public T get(int idx); // or null
	public void clear();
	public boolean isEmpty();
	public int size();
	public boolean remove(T item);
	public T remove(int idx); // or null
	public Iterator<T> iterator();
}
