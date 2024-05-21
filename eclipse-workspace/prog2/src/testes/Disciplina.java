package testes;

import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private ArrayList<Aluno> alunos = new  ArrayList<>();
	
	public void addAluno(Aluno a) {
		alunos.add(a);
	}
	public void removeAluno(Aluno a) {
		alunos.remove(a);
	}
	public Disciplina(String nome) {
		super();
		this.nome = nome;
	}
	

}
