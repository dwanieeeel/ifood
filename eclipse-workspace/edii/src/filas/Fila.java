package filas;

import java.util.Iterator;
import java.util.NoSuchElementException;

	public class Fila<Item> implements Iterable<Item>{
	    private Node last;
	    private Node first;
	    private int n;

	    private class LinkedIterator implements Iterator<Item>{
	    	private Node current;

	        public LinkedIterator(){
	            current = first;
	        }

	        public boolean hasNext(){
	            return current != null;
	        }

	        @Override
	        public Item next() {
	            if(!hasNext()) throw new NoSuchElementException();
	            Item item = current.item;
	            current = current.next;
	            
	            return item;
	        }

			public Iterator<Item> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
	    }
	    
	    private class Node {
	        private Item item;
	        private Node next;
	    }
	    
	    
	    public void addLast(Item item) {
	    	Node newNode = new Node();
	    	newNode.item = item;
	    	newNode.next = null;
	    	if (isEmpty()) {
	    		first = newNode;
	    	} else {
	    	last.next = newNode;
	    	}
	    	last = newNode;
	    	n++;
	    }
	    
	    public void removeFirst() {
	    	 if (isEmpty()) {
				  throw new NoSuchElementException();
				  } else {
					  first = first.next;
				  } n--;
	    }
	    
	    
	    public boolean isEmpty() {
	        return first == null;
	    }
	    
	    public int size(){
	        return n;
	    }
	    public Fila() {
	        first = null;
	        n = 0;
	    }
	    
	    @Override
	    public Iterator<Item> iterator() {
	        return new LinkedIterator();
	    }

		@Override
		public String toString() {
			return "Fila [last=" + last + ", first=" + first + ", n=" + n + ", isEmpty()=" + isEmpty() + ", size()="
					+ size() + ", iterator()=" + iterator() + "]";
		}
	}

