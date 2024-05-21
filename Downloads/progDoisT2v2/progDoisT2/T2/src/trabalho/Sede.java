package trabalho;

public class Sede {
	private static int count = 0;
	private Integer codigo;
	private Localidade localidade;
	private Endereco endereco;
	public Sede( Localidade localidade) {
		codigo = ++count;
		this.localidade = localidade;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Sede [codigo=" + codigo + ", localidade=" + localidade + ", endereco=" + endereco + "]";
	}
	
	
}
