package desafio_iv;

public class Calculator {
	
	public static double soma(double a, double b) {
		return a + b;
	}
	
	public static double subtracao(double a, double b) {
		return a - b;
	}

	public static double divisao(double a, double b) {
		return a/b;
	}
	
	public static double multiplicacao(double a, double b) {
		return a * b;
	}
	
	public static Double exp(double a, double b) {
		return Math.pow(a, b);
	}
	
	public static double raiz(double a) {
		return Math.sqrt(a);
	}
	
	public static void bashkara (double a, double b, double c) {
		double delta = b * b - 4 * a * c;
		
		if (delta < 0) {
             System.out.println("Sem raízes reais (raízes imaginárias).");
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);

            System.out.println("Raiz 1 (x1): " + x1);
            System.out.println("Raiz 2 (x2): " + x2);
		}
	}
	
}
