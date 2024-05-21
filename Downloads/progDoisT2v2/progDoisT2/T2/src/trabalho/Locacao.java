package trabalho;

import java.time.LocalDate;
import java.time.Period;

public abstract class Locacao {
	private static int count = 0;
	private int id;
	private LocalDate instanteLocacao;
	private LocalDate instanteDevolucao;
	protected Cliente cliente;
	protected Carro carro;
	private Double valor;
	public Locacao() {
		id = ++count;
	}
	public Locacao(int id, LocalDate instanteLocacao, LocalDate instanteDevolucao, Cliente cliente, Carro carro) {
		id = ++count;
		this.id = id;
		this.instanteLocacao = instanteLocacao;
		this.instanteDevolucao = instanteDevolucao;
		this.cliente = cliente;
		this.carro = carro;
	}
	public LocalDate getInstanteLocacao() {
		return instanteLocacao;
	}
	public void setInstanteLocacao(LocalDate instanteLocacao) {
		this.instanteLocacao = instanteLocacao;
	}
	public LocalDate getInstanteDevolucao() {
		return instanteDevolucao;
	}
	public void setInstanteDevolucao(LocalDate instanteDevolucao) {
		this.instanteDevolucao = instanteDevolucao;
	}
	public int getId() {
		return id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	// Método que calcula o valor da locação com base na categoria do carro e na duração da locação
	public void calcularValor() {
		// Obtendo o preço da diária da categoria do carro
		Double precoDiario = carro.getCategoria().getPrecoDiario();
		// Calculando a diferença entre as datas de locação e devolução
		Period periodo = Period.between(instanteLocacao, instanteDevolucao);
		// Obtendo o número de dias do período
		int dias = periodo.getDays();
		// Multiplicando o preço da diária pelo número de dias
		Double valorBase = precoDiario * dias;
		// Aplicando um desconto ou uma multa de acordo com o tipo de locação
		if (this instanceof LocacaoDiaria) {
			// Se for locação diária, verifica se o número de dias previstos foi respeitado
			LocacaoDiaria ld = (LocacaoDiaria) this; // Fazendo um downcasting
			int diasPrevistos = ld.getDiasPrevistos(); // Obtendo o número de dias previstos
			if (dias > diasPrevistos) {
				// Se o número de dias for maior que o previsto, aplica uma multa de 10% sobre o valor base
				valor = valorBase * 1.1;
			} else {
				// Se o número de dias for menor ou igual ao previsto, mantém o valor base
				valor = valorBase;
			}
		} else if (this instanceof LocacaoLongoPeriodo) {
			// Se for locação de longo período, aplica um desconto sobre o valor base
			LocacaoLongoPeriodo llp = (LocacaoLongoPeriodo) this; // Fazendo um downcasting
			Double porcentagemDesconto = llp.getPorcentagemDesconto(); // Obtendo a porcentagem de desconto
			valor = valorBase * (1 - porcentagemDesconto / 100); // Aplicando o desconto
		}
	}
	
}