package nodes;

public class Main {
    public static void main(String[] args) {
        LinkedList2<String> list = new LinkedList2<>();
	        list.addFirst("Estrutura de dados 2");
	        list.addLast("Prog1");
	        list.addLast("The Old ThereBefore");
	        list.addLast("SALVATORE");
	        list.removeFirst();
	        list.removeLast();

	        for (var s : list) {
	            System.out.println(s);
	        }

	        System.out.println("Size of list = " + list.size());
	    }
}
