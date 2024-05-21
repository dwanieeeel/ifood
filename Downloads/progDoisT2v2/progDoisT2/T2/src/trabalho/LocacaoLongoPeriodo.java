package trabalho;

import java.time.LocalDate;

public class LocacaoLongoPeriodo extends Locacao{
	private Double porcentagemDesconto;

	public LocacaoLongoPeriodo(int id, LocalDate instanteLocacao, LocalDate instanteDevolucao) {
		super(id, instanteLocacao, instanteDevolucao);
	}

	public LocacaoLongoPeriodo(int id, LocalDate instanteLocacao, LocalDate instanteDevolucao,
			Double porcentagemDesconto) {
		super(id, instanteLocacao, instanteDevolucao);
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	@Override
	public String toString() {
		return "LocacaoLongoPeriodo [porcentagemDesconto=" + porcentagemDesconto + ", getInstanteLocacao()="
				+ getInstanteLocacao() + ", getInstanteDevolucao()=" + getInstanteDevolucao() + ", getId()=" + getId()
				+ "]";
	}
	

}
