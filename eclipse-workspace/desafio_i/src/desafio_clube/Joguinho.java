package desafio_clube;

import java.util.Random;
import java.util.Scanner;

public class Joguinho {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int randomnumber = random.nextInt(101);
		
		System.out.println("JOGO DO ADIVINHA \nO sistema escolheu um numero 1 a 100");
		System.out.println("Qual numero voce acha que seja?");
		int numero = sc.nextInt();
		int contdicas = 1;
		while (numero!=randomnumber) {
			maiorOumenor(numero, randomnumber);
			System.out.println("Tente novamente: ");
			numero = sc.nextInt();
			contdicas++;
			if (contdicas==3) {
				System.out.println("DICAS BÔNUS: ");
				parOuimpar(randomnumber);
			}
					
		}
		
		System.out.println("Parabens! Voce acertou!");

	}
	
	public static void maiorOumenor (int num1, int num2) {	
		if (num1<num2) {
			System.out.println("O numero que voce digitou é menor que o numero escolhido pelo sistema");
		} else {
			System.out.println("O numero que voce digitou é maior que o numero escolhido pelo sistema");

		}
	}
	
	public static void parOuimpar(int num) {
		if (num%2==0) {
			System.out.println("O numero escolhido pelo sistema é par");
		} else {
			System.out.println("O numero escolhido pelo sistema é impar");
		}
	}

}
