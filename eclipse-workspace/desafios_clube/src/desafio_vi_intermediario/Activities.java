package desafio_vi_intermediario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Activities {
	private String titulo;
	private String descricao;
	private LocalDate vencimento;
	private Status status;
	private List<String>notas = new ArrayList<>();
	
	public Activities(String titulo, String descricao, LocalDate vencimento, Status status) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.vencimento = vencimento;
		this.status = status;
	}
	
	private void addNota(String nota) {
		notas.add(nota);
	}
	
	private void removeNota(int index) {
		notas.remove(index);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate data) {
		this.vencimento = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
}
