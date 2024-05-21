package search;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary_Search {

	public static void main(String[] args) {
		 List<Integer> lista = new ArrayList<>();
	        lista.add(1);
	        lista.add(3);
	        lista.add(5);
	        lista.add(7);
	        lista.add(9);
	        lista.add(3);
	        lista.add(1);
	        lista.add(10);
	        lista.add(7);
	        
	        Collections.sort(lista);
	        
	        int target = 7;
	        int result = binarySearch(lista, target, 0, lista.size() - 1);
	        System.out.println("Lista: " + lista);
	        System.out.println("Elemento " + target + " encontrado no índice: " + result);
	    }

	
	
	public static Integer binarySearch(List<Integer> lista, int i, int begin, int end) {
			if (begin <= end) {
				int m = (begin + end) / 2;
				if (lista.get(m) == i) {
					return m;
				} 
				else if (i<lista.get(m)) {
					return binarySearch(lista, i, begin, m-1);
				} else {
					return binarySearch(lista, i, m+1, end);
				}
				
			} return null;
}
}
