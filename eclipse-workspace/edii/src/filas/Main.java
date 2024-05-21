package filas;

public class Main {
	public static void main(String[] args) {
		Fila<String> fila = new Fila<>();
	        fila.addLast("Prog1");
	        fila.addLast("Prog2");
	        fila.addLast("Prog3");
	        fila.removeFirst();
	        
	        System.out.println("Tamanho da fila: " + fila.size());
	        
	        for (String string : fila) {
				System.out.println(string);
			}
}
}
