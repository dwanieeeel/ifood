package trabalho;

import java.time.LocalDate;

public class LocacaoDiaria extends Locacao{
	private int diasPrevistos;
	
	public LocacaoDiaria(int id, LocalDate instanteLocacao, LocalDate instanteDevolucao, Cliente cliente, Carro carro) {
		super(id, instanteLocacao, instanteDevolucao, cliente, carro);
	}

	public LocacaoDiaria(int id, LocalDate instanteLocacao, LocalDate instanteDevolucao, Cliente cliente, Carro carro, int diasPrevistos) {
		super(id, instanteLocacao, instanteDevolucao, cliente, carro);
		this.diasPrevistos = diasPrevistos;
	}

	public int getDiasPrevistos() {
		return diasPrevistos;
	}

	public void setDiasPrevistos(int diasPrevistos) {
		this.diasPrevistos = diasPrevistos;
	}

	@Override
	public String toString() {
		return "LocacaoDiaria [diasPrevistos=" + diasPrevistos + ", getInstanteLocacao()=" + getInstanteLocacao()
				+ ", getInstanteDevolucao()=" + getInstanteDevolucao() + ", getId()=" + getId() + ", getCliente()="
				+ getCliente() + ", getCarro()=" + getCarro() + ", getValor()=" + getValor() + "]";
	}
	
	

}