package desafio_vii;

import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vamos criar sua senha, digite a quantidade de caracteres desejada (min = 8)");
		int quant = sc.nextInt(); sc.nextLine();
		while (quant<8) {
			System.out.println("Numero inválido. A senha deve ter no minimo 8 caracteres.\r\nDigite novamente: ");
			quant = sc.nextInt(); sc.nextLine();
		}
		
		 char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 
				 'p', 'q', 'u', 'v','w','x','y', 'z'};
		 
		 char [] num = {'0','1','2','3','4','5','6','7','8','9'};
		 
		 char [] esp = {'!', '@', '#', '#','$','%','&','*','?','+'};
		 
		 Random random = new Random();
		 
		 StringBuilder senha = new StringBuilder();
		 
		 int cont = 3;
		 int j=0;
		 
		 //Garantindo que a senha tenha ao menos um caractere de cada tipo
		 j = random.nextInt(caracteres.length);
		    senha.append(caracteres[j]);
		 j = random.nextInt(num.length);
		    senha.append(num[j]); 
		 j = random.nextInt(esp.length);
		    senha.append(esp[j]);
		    
		    
		 while (cont < quant) {
			  int tipo = random.nextInt(3); 
			  if (tipo == 0) {
			    j = random.nextInt(caracteres.length);
			    senha.append(caracteres[j]);
			  } else if (tipo == 1) {
			    j = random.nextInt(num.length);
			    senha.append(num[j]);
			  } else {
			    j = random.nextInt(esp.length);
			    senha.append(esp[j]);
			  }
			  cont++;
			}

		 
		 System.out.println("Senha gerada: " + senha);
		 
		 
		 sc.close();
		 
		 }
	}


