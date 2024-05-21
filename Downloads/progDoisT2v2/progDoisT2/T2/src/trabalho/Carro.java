package trabalho;

import java.time.LocalDate;

public class Carro {
	private static int count = 0;
	private int id;
	private String modelo;
	private String placa; // unique?
	private Cor cor;
	private Integer ano;
	private LocalDate dataAquisicao;
	private Categoria categoria;
	
	public Carro() {
		id = ++count;
	}

	public Carro(String modelo, String placa, Cor cor, Integer ano, LocalDate dataAquisicao) {
		id = ++count;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.dataAquisicao = dataAquisicao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public int getId() {
		return id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", modelo=" + modelo + ", placa=" + placa + ", cor=" + cor + ", ano=" + ano
				+ ", dataAquisicao=" + dataAquisicao + ", categoria=" + categoria + "]";
	}

	

	
	
	
	

}
