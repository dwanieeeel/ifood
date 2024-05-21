package trabalho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Categoria economica = new Categoria("Econômica", 100.0);
		Categoria intermediaria = new Categoria("Intermediária", 150.0);
		Categoria executiva = new Categoria("Executiva", 200.0);
		Categoria luxo = new Categoria("Luxo", 300.0);
		
		// Criando as listas para armazenar os dados
		List<Cliente> clientes = new ArrayList<>();
		List<Carro> carros = new ArrayList<>();
		List<Locacao> locacoes = new ArrayList<>();
		
		// Criando o scanner para ler os dados do usuário
		Scanner sc = new Scanner(System.in);
		
		// Criando uma variável para controlar o loop do menu
		boolean continuar = true;
		
		// Iniciando o loop do menu
		while (continuar) {
			// Chamando o método menu e armazenando a escolha do usuário
			int opcao = menu(sc);
			
			// Verificando a opção escolhida pelo usuário
			switch (opcao) {
			case 1:
				// Cadastrar cliente
				cadastrarCliente(sc, clientes);
				break;
			case 2:
				// Cadastrar carro
				cadastrarCarro(sc, carros, economica, intermediaria, executiva, luxo);
				break;
			case 3:
				// Realizar locação
				realizarLocacao(sc, locacoes, clientes, carros);
				break;
			case 4:
				// Devolver carro
				devolverCarro(sc, locacoes);
				break;
			case 5:
				// Listar clientes
				listarClientes(clientes);
				break;
			case 6:
				// Listar carros
				listarCarros(carros);
				break;
			case 7:
				// Listar locações
				listarLocacoes(locacoes);
				break;
			case 0:
				// Sair
				sair();
				continuar = false;
				break;
			default:
				// Opção inválida
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
		
		// Fechando o scanner
		sc.close();
	}
	
	public static void sair() {
	System.out.println("Obrigado por usar o sistema da locadora de carros!");
	System.out.println("Espero que você tenha gostado dos meus serviços.");
	System.out.println("Até a próxima!");
}

	public static void listarLocacoes(List<Locacao> locacoes) {
	System.out.println("Listando locações...");
	for (Locacao l : locacoes) { // Percorrendo a lista de locações
		System.out.println(l); // Imprimindo a locação usando o método toString
	}
}

	public static void listarCarros(List<Carro> carros) {
		System.out.println("Listando carros...");
		for (Carro c : carros) { // Percorrendo a lista de carros
			System.out.println(c); // Imprimindo o carro usando o método toString
	}
}

	public static void listarClientes(List<Cliente> clientes) {
	System.out.println("Listando clientes...");
	for (Cliente c : clientes) { // Percorrendo a lista de clientes
		System.out.println(c); // Imprimindo o cliente usando o método toString
	}
}

	public static void devolverCarro(Scanner sc, List<Locacao> locacoes) {
	System.out.println("Devolvendo carro...");
	System.out.print("Digite o id da locação que você quer devolver: ");
	int id = sc.nextInt();
	sc.nextLine(); // Consumindo a quebra de linha
	Locacao locacao = null; // Inicializando a variável locacao
	for (Locacao l : locacoes) { // Percorrendo a lista de locações
		if (l.getId() == id) { // Verificando se o id informado é igual ao id da locação atual
			locacao = l; // Atribuindo a locação atual à variável locacao
			break; // Saindo do loop
		}
	}
	if (locacao == null) { // Verificando se a locação foi encontrada
		System.out.println("Locação não encontrada. Tente novamente.");
		return; // Encerrando o método
	}
	System.out.print("Digite a data de devolução do carro (no formato yyyy-MM-dd): ");
	String data = sc.nextLine();
	LocalDate instanteDevolucao = LocalDate.parse(data); // Convertendo a string em uma data
	locacao.setInstanteDevolucao(instanteDevolucao); // Atribuindo a data de devolução ao objeto da classe Locacao
	locacao.calcularValor(); // Chamando o método que calcula o valor da locação
	System.out.println("O valor da locação é: " + locacao.getValor());
	System.out.println("Carro devolvido com sucesso!");
}

	public static void realizarLocacao(Scanner sc, List<Locacao> locacoes, List<Cliente> clientes, List<Carro> carros) {
	System.out.println("Realizando locação...");
	System.out.print("Digite o CPF do cliente que vai alugar o carro: ");
	String cpf = sc.nextLine();
	Cliente cliente = null; // Inicializando a variável cliente
	for (Cliente c : clientes) { // Percorrendo a lista de clientes
		if (c.getCpf().equals(cpf)) { // Verificando se o CPF informado é igual ao CPF do cliente atual
			cliente = c; // Atribuindo o cliente atual à variável cliente
			break; // Saindo do loop
		}
	}
	if (cliente == null) { // Verificando se o cliente foi encontrado
		System.out.println("Cliente não encontrado. Tente novamente.");
		return; // Encerrando o método
	}
	System.out.print("Digite a placa do carro que vai ser alugado: ");
	String placa = sc.nextLine();
	Carro carro = null; // Inicializando a variável carro
	for (Carro c : carros) { // Percorrendo a lista de carros
		if (c.getPlaca().equals(placa)) { // Verificando se a placa informada é igual à placa do carro atual
			carro = c; // Atribuindo o carro atual à variável carro
			break; // Saindo do loop
		}
	}
	if (carro == null) { // Verificando se o carro foi encontrado
		System.out.println("Carro não encontrado. Tente novamente.");
		return; // Encerrando o método
	}
	System.out.print("Digite a data de locação do carro (no formato yyyy-MM-dd): ");
	String data = sc.nextLine();
	LocalDate instanteLocacao = LocalDate.parse(data); // Convertendo a string em uma data
	System.out.print("Digite o tipo de locação (1 - Diária, 2 - Longo período): ");
	int tipo = sc.nextInt();
	sc.nextLine(); // Consumindo a quebra de linha
	Locacao locacao = null; // Inicializando a variável locacao
	switch (tipo) { // Verificando a opção escolhida pelo usuário
	case 1:
		// Locação diária
		System.out.print("Digite o número de dias previstos para devolução do carro: ");
		int diasPrevistos = sc.nextInt();
		sc.nextLine(); // Consumindo a quebra de linha
		locacao = new LocacaoDiaria(0, instanteLocacao, null, cliente, carro, diasPrevistos); // Criando o objeto locacao diária
		break;
	case 2:
		// Locação de longo período
		System.out.print("Digite a porcentagem de desconto no valor da diária: ");
		double porcentagemDesconto = sc.nextDouble();
		sc.nextLine(); // Consumindo a quebra de linha
		locacao = new LocacaoLongoPeriodo(0, instanteLocacao, null); // Criando o objeto locacao de longo período
		break;
	default:
		// Opção inválida
		System.out.println("Opção inválida. Tente novamente.");
		return; // Encerrando o método
	}
	locacoes.add(locacao); // Adicionando a locação à lista de locações
	System.out.println("Locação realizada com sucesso!");
}

	// Método que imprime as opções do menu e retorna a escolha do usuário
	public static int menu(Scanner sc) {
		System.out.println("Bem-vindo ao sistema da locadora de carros!");
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Cadastrar carro");
		System.out.println("3 - Realizar locação");
		System.out.println("4 - Devolver carro");
		System.out.println("5 - Listar clientes");
		System.out.println("6 - Listar carros");
		System.out.println("7 - Listar locações");
		System.out.println("0 - Sair");
		System.out.print("Digite a sua opção: ");
		int opcao = sc.nextInt();
		sc.nextLine(); // Consumindo a quebra de linha
		return opcao;
	}
	
	// Método que pede os dados do cliente e cria um objeto da classe Cliente
	public static void cadastrarCliente(Scanner sc, List<Cliente> clientes) {
		System.out.println("Cadastrando cliente...");
		System.out.print("Digite o CPF do cliente: ");
		String cpf = sc.nextLine();
		System.out.print("Digite o nome do cliente: ");
		String nome = sc.nextLine();
		System.out.print("Digite o email do cliente: ");
		String email = sc.nextLine();
		Cliente cliente = new Cliente(cpf, nome, email);
		System.out.print("Digite a quantidade de telefones do cliente: ");
		int qtd = sc.nextInt();
		sc.nextLine(); // Consumindo a quebra de linha
		for (int i = 0; i < qtd; i++) {
			System.out.print("Digite o número do telefone " + (i+1) + ": ");
			String numero = sc.nextLine();
			Telefone telefone = new Telefone(numero);
			cliente.addTelefone(telefone);
		}
		clientes.add(cliente);
		System.out.println("Cliente cadastrado com sucesso!");
	}
	
	// Método que pede os dados do carro e cria um objeto da classe Carro
	public static void cadastrarCarro(Scanner sc, List<Carro> carros, Categoria economica, Categoria intermediaria, Categoria executiva, Categoria luxo) {
	System.out.println("Cadastrando carro...");
	System.out.print("Digite o modelo do carro: ");
	String modelo = sc.nextLine();
	System.out.print("Digite a placa do carro: ");
	String placa = sc.nextLine();
	System.out.print("Digite a cor do carro: ");
	String cor = sc.nextLine();
	Cor c = Cor.valueOf(cor.toUpperCase()); // Convertendo a string em um enum
	System.out.print("Disgite o ano do carro: ");
	int ano = sc.nextInt();
	sc.nextLine(); // Consumindo a quebra de linha
	System.out.print("Digite a data de aquisição do carro (no formato yyyy-MM-dd): ");
	String data = sc.nextLine();
	LocalDate dataAquisicao = LocalDate.parse(data); // Convertendo a string em uma data
	System.out.print("Digite a categoria do carro (1 - Econômica, 2 - Intermediária, 3 - Executiva, 4 - Luxo): ");
	int cat = sc.nextInt();
	sc.nextLine(); // Consumindo a quebra de linha
	Categoria categoria = null; // Inicializando a variável categoria
	switch (cat) { // Verificando a opção escolhida pelo usuário
	case 1:
		// Econômica
		categoria = economica;
		break;
	case 2:
		// Intermediária
		categoria = intermediaria;
		break;
	case 3:
		// Executiva
		categoria = executiva;
		break;
	case 4:
		// Luxo
		categoria = luxo;
		break;
	default:
		// Opção inválida
		System.out.println("Opção inválida. Tente novamente.");
		break;
	}
	Carro carro = new Carro(modelo, placa, c, ano, dataAquisicao); // Criando o objeto carro
	carro.setCategoria(categoria); // Atribuindo a categoria ao carro
	carros.add(carro); // Adicionando o carro à lista de carros
	System.out.println("Carro cadastrado com sucesso!");
}
}

