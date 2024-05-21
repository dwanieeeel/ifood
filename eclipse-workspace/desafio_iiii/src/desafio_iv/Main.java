package desafio_iv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Oque deseja fazer?");
		System.out.println("1. SOMAR \n2. SUBTRAIR \n3. DIVIDIR \n4. MULTIPLICAR \n5. EXPONENCIACAO \n6. RAIZ QUADDRADA \n7.BASHKARA ");
		int opcao = sc.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("Digite o primeiro numero");
			double n1 = sc.nextDouble();
			System.out.println("Digite o segundo numero");
			double n2 = sc.nextDouble();
			System.out.println(Calculator.soma(n1,n2));
			break;
		case 2:
			System.out.println("Digite o primeiro numero");
			n1 = sc.nextDouble();
			System.out.println("Digite o segundo numero");
		    n2 = sc.nextDouble();
			 System.out.println(Calculator.subtracao(n1,n2));
			break;
		case 3:
			System.out.println("Digite o dividendo");
			n1 = sc.nextDouble();
			System.out.println("Digite o divisor");
		    n2 = sc.nextDouble();
			System.out.println(Calculator.divisao(n1,n2));
			break;
		case 4:
			System.out.println("Digite o multiplicando");
			n1 = sc.nextDouble();
			System.out.println("Digite o multiplicador");
		    n2 = sc.nextDouble();
			System.out.println(Calculator.multiplicacao(n1,n2));
			break;
		case 5:
			System.out.println("Digite a base");
			n1 = sc.nextDouble();
			System.out.println("Digite o expoente");
		    n2 = sc.nextDouble();
			System.out.println(Calculator.exp(n1,n2));
			break;
		case 6:
			System.out.println("Digite o numero");
			n1 = sc.nextDouble();
			System.out.println(Calculator.raiz(n1));
			break;
		case 7:
			System.out.println("Digite a");
			n1 = sc.nextDouble();
			System.out.println("Digite b");
		    n2 = sc.nextDouble();
		    System.out.println("Digite c");
			double n3 = sc.nextDouble();
			Calculator.bashkara(n1, n2, n3);
			break;
			default:
				System.out.println("Opcao invalida");
				break;
		}
	sc.close();
	
	}
		
	}
