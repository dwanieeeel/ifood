package trabalho;

public class Cidade {
	private static int count = 0;
	private int id;
	private String nome;
	private Estado estado;
	public Cidade() {
		id = ++count;
	}
	public Cidade(String nome) {
		id = ++count;
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}
	
	

}
