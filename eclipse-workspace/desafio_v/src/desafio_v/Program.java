package desafio_v;

import java.util.Scanner;

public class Program {

	    public static void main(String[] args) {
	    	Scanner sc = new Scanner (System.in);
	    	System.out.println("Digite um numero: ");
	    	 int entrada = sc.nextInt();
	         int[] notas = {100, 50, 20, 10, 5, 2, 1};
	         
	         for (int nota : notas) {
	             int count = entrada / nota;
	                 System.out.printf("%d notas de %d\n", count, nota);
	                 entrada %= nota;
	         }}}

