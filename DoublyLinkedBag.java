/**
   A class of bags whose entries are stored in a chain of doubly linked nodes.
   The bag is never full.

*/
public class DoublyLinkedBag<T> implements BagInterface<T>
{
	private DoublyLinkedNode firstNode; // Reference to first node
	private int numberOfEntries;

	public DoublyLinkedBag()
	{
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	public boolean add(T newEntry)      // OutOfMemoryError possible
	// THIS METHOD IS AFFECTED BY THE DOUBLY LINKED NODE
	{
		// Add to beginning of chain:
			return true;
	} // end add

	public T[] toArray()
	{
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

		int index = 0;
		DoublyLinkedNode currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} // end while

			return result;
	} // end toArray

	public boolean isEmpty() 
	{
		return numberOfEntries == 0;
	} // end isEmpty

	public int getCurrentSize() 
	{
		return numberOfEntries;
	} // end getCurrentSize

	public int getFrequencyOf(T anEntry) 
	{
		int frequency = 0;

		int counter = 0;
		DoublyLinkedNode currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
			{
				frequency++;
			} // end if

			counter++;
			currentNode = currentNode.next;
		} // end while

		return frequency;
	} // end getFrequencyOf

	public boolean contains(T anEntry)
	{
		return getReferenceTo(anEntry) != null;
	} // end contains

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private DoublyLinkedNode getReferenceTo(T anEntry)
	{
		boolean found = false;
		DoublyLinkedNode currentNode = firstNode;

		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return currentNode;
	} // end getReferenceTo

	public void clear() 
	{
		while (!isEmpty()) 
			remove();
	} // end clear


	public T remove()
	{
		// THIS METHOD IS AFFECTED BY THE DOUBLY LINKED NODE
		//Remove first node
		T result = null;
		return result;
	} // end remove

	// THIS METHOD IS AFFECTED BY THE DOUBLY LINKED NODE
	public boolean remove(T anEntry) 
	{
		// THIS METHOD IS AFFECTED BY THE DOUBLY LINKED NODE
		// For this method, you will remove the very node that contains
		// anEntry (first occurrence)
		// Do not use previously implemented approach

		boolean result = false;

		return result;
	} // end remove


	// A class of nodes for a chain of doubly linked nodes.
	private class DoublyLinkedNode
	{
		private T	data;					      // Entry in bag
		private DoublyLinkedNode next;		// Link to next node
		private DoublyLinkedNode previous;	// Link to previous node

		private DoublyLinkedNode(T dataPortion)
		{
			this(dataPortion, null, null);	
		} // end constructor

		private DoublyLinkedNode(T dataPortion, DoublyLinkedNode nextNode,
                               DoublyLinkedNode previousNode)
		{
			data = dataPortion;
			next = nextNode;
			previous = previousNode;
		} // end constructor


	} // end DoublyLinkedNode
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		DoublyLinkedNode currentNode = firstNode;
		while (currentNode != null){
			result.append(currentNode.data);
			if (currentNode.next != null) {
				result.append(", ");
			}
			currentNode = currentNode.next;
		}
		return result + "]";
	}

	private DoublyLinkedNode getLastNode(){
		DoublyLinkedNode last = firstNode;
		while (last.next != null){
			last =last.next;
		}
		return last;
	}
	public T[] toArray(boolean reverse){
		if (!reverse) return toArray();
		T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

		int index = 0;
		DoublyLinkedNode currentNode = getLastNode();
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.previous;
		} // end while

		return result;
	}
} // end DoublyLinkedBag
