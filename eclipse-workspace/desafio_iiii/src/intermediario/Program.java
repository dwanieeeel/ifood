package intermediario;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int teste = 50;

		System.out.println(DecimalOctal(teste));

}
	
	public static String DecimalBinario(int numero) {
		StringBuilder binario = new StringBuilder();

		while (numero!=0) {
			int resto = numero % 2;
			binario.insert(0, resto);
			numero/=2;
		}
		
		return binario.toString();
	}
	
	public static Integer BinarioDecimal(String binario) {
		int decimal = 0;
		
		for (int i = binario.length()-1; i >= 0; i--) {
			char c = binario.charAt(i);
			int digito = c - '0';
			decimal += digito * Math.pow(2, binario.length() - 1 - i);
		}
		
		return decimal;
}
	
	public static String DecimalOctal (Integer numero) {
		StringBuilder octal = new StringBuilder();
		while (numero!=0) {
			int resto = numero % 8;
			octal.insert(0,resto);
			numero/=8;
		}
		
		return octal.toString();
	}
	
}
