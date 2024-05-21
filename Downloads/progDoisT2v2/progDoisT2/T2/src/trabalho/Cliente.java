package trabalho;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private List<Telefone> telefones = new ArrayList<>();
	public Cliente() {
	
	}

	public Cliente(String cpf, String nome, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void addTelefone(Telefone t) {
		telefones.add(t);
	}
	
	public void removeTelefone(Telefone t ) {
		telefones.remove(t);
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefones=" + telefones + "]";
	}
	
}
