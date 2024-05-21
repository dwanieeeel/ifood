package trabalho;

public class Categoria {
	private static int count = 0;
	private int id;
	private String descricao;
	private Double precoDiario;
	public Categoria() {
		id = ++count;
	}
	public Categoria(String descricao, Double precoDiario) {
		id = ++count;
		this.descricao = descricao;
		this.precoDiario = precoDiario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPrecoDiario() {
		return precoDiario;
	}
	public void setPrecoDiario(Double precoDiario) {
		this.precoDiario = precoDiario;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descricao=" + descricao + ", precoDiario=" + precoDiario + "]";
	}
	
}
