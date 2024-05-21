package entities;

public class Account {
	private static Integer Nextid = 1;
	private Integer id;
	private Integer senha;
	private Double saldo;
	
	public Account(Integer senha, Double saldo) {
		super();
		this.senha = senha;
		this.saldo = saldo;
		this.id = Nextid++;
	}
	
	public void saque(Double valor) {
		if (valor<saldo) {
			saldo-=valor;
			System.out.println("Transacao finalizada com sucesso!");
		} else {
			System.out.println("Saldo insuficente");
		}
	}
	
	public void deposito(Double valor) {
		if (valor>0.0) {
			saldo+=valor;
			System.out.println("Transacao finalizada com sucesso!");
		} else {
			System.out.println("Não é possivel depositar valores negativos!");
		}
	}
	
	
	public Integer getPassword() {
		return senha;
	}
	public void setPassword(Integer password) {
		this.senha = password;
	}
	public Double getBalance() {
		return saldo;
	}
	public void setBalance(Double balance) {
		this.saldo = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", senha=" + senha + ", saldo=" + saldo + "]";
	}

	
	
	

}
