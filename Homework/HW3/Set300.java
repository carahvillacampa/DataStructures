package homework3;

import java.util.Iterator;

public interface Set300<T> extends Iterable<T> {
	
	public boolean add(T item);
	
	public boolean remove(T item);
	
	public boolean contains(T item);
	
	
	//use iterator method since it's extending 
    //iterable
	public Iterator<T> iterator(); 

	
	

}
