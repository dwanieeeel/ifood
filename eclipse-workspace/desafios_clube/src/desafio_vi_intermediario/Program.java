package desafio_vi_intermediario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		List <Activities> tarefas = new ArrayList();
		Scanner sc = new Scanner (System.in);
		
		boolean cadastrar = true;
		
		while (cadastrar) {
			 System.out.println("Deseja cadastrar uma nova tarefa? (s/n)");
	            String resposta = sc.nextLine().toLowerCase();
	            if (resposta.equals("s")) {
	            	System.out.println("Digite o título da tarefa:");
	   	         String titulo = sc.nextLine();

	   	         System.out.println("Digite a descrição da tarefa:");
	   	         String descricao = sc.nextLine();

	   	         System.out.println("Digite a data da tarefa (formato yyyy-MM-dd):");
	   	         String dataString = sc.nextLine();
	   	         LocalDate data = LocalDate.parse(dataString);
	   	        		 
	   	         Status status = null;
	   	         System.out.println("Digite o status da tarefa (PENDENTE, EM_PROGRESSO, CONCLUIDA, CANCELADA):");
	   	         String statusString = sc.nextLine().toUpperCase();
	   	         status = Status.valueOf(statusString);

	   	         Activities activities = new Activities(titulo, descricao, data, status);
	   	         tarefas.add(activities);
	   	         
	   	         System.out.println("Tarefa cadastrada com sucesso!");
	            } else if (resposta.equals("n")) {
	                cadastrar = false;
	                System.out.println("Encerrando o programa...");
	            } else {
	                System.out.println("Opção inválida. Por favor, digite 's' para cadastrar uma nova tarefa ou 'n' para sair.");
	            }
		}
		
		int opcao = 0;
		do {
			System.out.println("Oque deseja fazer?");
			System.out.println("0. Para sair \r\n"
					+ "1. Remover tarefas permanentemente. \r\n");	
			
			 switch(opcao) {
				case 1: 
					int cont = 0;
					System.out.println("Qual deseja deletar");
				 for (Activities activities : tarefas) {
					 System.out.println(cont + "," + activities.getTitulo());
					 cont++;
				} 
				 System.out.println("Digite o numero da tarefa");
				 int num = sc.nextInt();
				 sc.nextLine();
                 if (num >= 0 && num < tarefas.size()) {
                     tarefas.remove(num);
                     System.out.println("Tarefa removida com sucesso!");
                 } else {
                     System.out.println("Número de tarefa inválido!");
                 }
                 break;
			 }
			 
			 
		} while (opcao != 0);
		
		
    }
	}
