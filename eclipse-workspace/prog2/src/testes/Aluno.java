package testes;

import java.time.LocalDate;

public class Aluno {
	private Integer id;
	private String name;
	private LocalDate nascimento;

	public Aluno(Integer id, String name, LocalDate nascimento) {
		super();
		this.id = id;
		this.name = name;
		this.nascimento = nascimento;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getNascimento() {
		return nascimento;
	}


	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}


	@Override
	public String toString() {
		return "Informações do aluno:\nID = " + id + "\nNome = " + name + "\nNascimento = " + nascimento;
	}
	
	 
	
	

}
