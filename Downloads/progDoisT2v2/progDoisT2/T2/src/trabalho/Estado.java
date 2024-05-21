package trabalho;

public class Estado {
	private static int count = 0;
	private int id;
	private String nome;
	public Estado() {
		id = ++count;
	}
	public Estado(String nome) {
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
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + "]";
	}
	
	
	

}
