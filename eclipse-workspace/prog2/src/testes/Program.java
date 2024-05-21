package testes;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter("alunos.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int opcao = 1;
		while (opcao!=0) {
			System.out.println("O que deseja fazer?");
            System.out.println("1. Cadastrar um novo aluno");
            System.out.println("2. Adicionar aluno à disciplina");
            System.out.println("3. Checar lista de presença de uma disciplina");
            System.out.println("0. Sair");
            System.out.print("Digite a opção desejada: ");

			opcao = sc.nextInt();
			
			
			  switch (opcao) {
              case 1:
            	  System.out.println("Digite o ID: ");
            	  int id = sc.nextInt();
            	  System.out.println("Digite o nome do aluno: ");
            	  String nome = sc.next(); sc.nextLine();
            	  System.out.println("Digite a data de nascimento do Aluno no formato YYYY-MM-DD: ");
                  String dataString = sc.nextLine();
                  LocalDate data = LocalDate.parse(dataString);
                  pw.println("ID: " + id + ", Nome: " + nome + ", Data de Nascimento: " + data);
                  break; 
                  
			  }}}}

