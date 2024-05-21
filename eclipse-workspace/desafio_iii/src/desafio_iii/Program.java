package desafio_iii;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite uma palavra e te direi a quantidade vogais e consoantes nela: ");
		String palavra = sc.next(); sc.nextLine();
		int contc = 0;
		int contv = 0;
		
		char[] charArray = palavra.toCharArray();
		 char[] charConcoantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
		 char[] charVogais = {'a','e','i','o','u'};
		for (char c : charArray) {
			for (char d : charConcoantes) {
				if (c==d) {
					contc++;
				}
			}
		}
		
		for (char c : charArray) {
			for (char d : charVogais) {
				if (c==d) {
					contv++;
				}
			}
		}
		
		System.out.println("Consoantes: " + contc + "\nVogais: " + contv);
		
		sc.close();

	}

}
