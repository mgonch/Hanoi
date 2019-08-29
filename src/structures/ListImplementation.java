package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@code ListImplementation} is a Linked List that wraps {@link Node}s and
 * provides useful operations.
 *
 * @author jcollard
 *
 */
public class ListImplementation<T> implements ListInterface<T> {
	private Node<T> top;
	private Node<T> bottom;
	private int stackSize = 0;


	public ListImplementation() {
	}

	/**
	 * Returns the number of nodes in this list.
	 */
	@Override
	public int size() {
        return stackSize;
	}

	@Override
	public boolean isEmpty() {
		if(top == null){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Appends {@code elem} to the end of this {@code ListImplementation} and
	 * returns itself for convenience.
	 */
	@Override
	public ListImplementation<T> append(T elem) {
		if(elem == null){
			throw new NullPointerException();
		}
		Node<T> tempVar = new Node<T>(elem, null);
		if(isEmpty() == false){
			bottom.setNext(tempVar);
		}
		else{
			top = tempVar;
		}
		bottom = tempVar;
		stackSize++;
		return this;
	}

	/**
	 * Gets the {@code n}th element from this list.
	 */
	@Override
	public T get(int n) {
		if(n < 0 || n >= stackSize){
			throw new NoSuchElementException();
		}
		Node<T> returnedNode = top;
		for(int i = 0; i < n; i++){
			returnedNode = returnedNode.getNext();
		}
		return returnedNode.getData();
	}

	/**
	 * Returns an iterator over this list. The iterator does not support the
	 * {@code remove()} method.
	 */
	@Override
	public Iterator<T> iterator() {
        return new ListIterator<T>(top);
	}
}

