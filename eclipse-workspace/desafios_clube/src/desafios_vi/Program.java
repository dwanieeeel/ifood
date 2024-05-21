package desafios_vi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		List <Aluno> alunos = new ArrayList();
		Scanner sc = new Scanner (System.in);
		
		int totalDias;
		System.out.println("Quantos dias terá o periodo letivo? ");
		totalDias = sc.nextInt();
		
		
		System.out.println("Cadastro de aluno: \r\nDigite -1 para terminar");
		
		double nota = 0;
		int faltas = 0;
		
		while (true) {
			System.out.println("Digite a nota: ");
			nota = sc.nextDouble();
			 if (nota == -1) {
	                break;
	            }
			 System.out.println("Digite o numero de faltas: ");
			 faltas = sc.nextInt();
			 if (faltas == -1) {
	                break;
	            }
			 
			 Aluno e = new Aluno (nota, faltas);
			 alunos.add(e);
		}
		
		int cont = 1;
		System.out.println("SITUAÇAO DOS ALUNOS: ");
		for (Aluno aluno : alunos) {
			if (aluno.faltas(totalDias)>35) {
				System.out.println("Aluno "+cont++ +":"+ " "+ "SFR");
			} else {
			System.out.println("Aluno "+cont++ +":"+ " "+ aluno.getConc());
		}
		}
		
		int opcao = 0;
		do {
			System.out.println("Oque deseja fazer?");
			System.out.println("0- Para sair. \r\n" 
			+ "1- Imprimir o total de alunos lidos.\r\n"
				+ "2- Imprimir a maior nota da turma.\r\n"
				+ "3- Imprimir a menor nota da turma.\r\n"
				+ "4- Imprimir a média das notas da turma.\r\n"
				+ "5- Imprimir a porcentagem de alunos reprovados por falta. \r\n"
				+ "6- Imprimir a porcentagem de alunos reprovados por nota insuficiente.");
		opcao = sc.nextInt();
			 switch(opcao) {
		case 1:
			System.out.println("Total de alunos é " + alunos.size());
			break;
		case 2: 
			double maiornota = Double.MIN_VALUE;
			for (Aluno aluno : alunos) {
				if (aluno.getNota()> maiornota) {
					maiornota = aluno.getNota();
				}}
			System.out.println("A maior nota da sala é "+ maiornota);
			break;
		case 3:
			double menornota = Double.MAX_VALUE;
			
			for (Aluno aluno : alunos) {
				if (aluno.getNota()<menornota) {
					menornota = aluno.getNota();
			}}
			System.out.println("A menor nota da sala é "+ menornota);
			break;
		case 4: 
			double media = 0;
			for (Aluno aluno : alunos) {
				media+=aluno.getNota();
			}
			System.out.println("A media de notas da sala é " + media/alunos.size());
			break;
		case 5:
			int reprovados = 0;
			
			for (Aluno aluno : alunos) {
				if (aluno.faltas(totalDias)>35) {
					reprovados++;
				}
			}
			System.out.println("A porcentagem de alunos reprovados por nota é " + (reprovados * 100) / alunos.size()+"%");
			break;
		case 6:
			reprovados = 0;
			for (Aluno aluno : alunos) {
				if (aluno.getNota()<5){		
					reprovados++;
				}
			}
			System.out.println("A porcentagem de alunos reprovados por nota é " + (reprovados * 100) / alunos.size()+"%");
			break;
			 }} while (opcao != 0);
		
		sc.close();
	}
}
