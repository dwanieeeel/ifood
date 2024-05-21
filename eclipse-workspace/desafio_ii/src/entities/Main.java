package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Account> contas = new ArrayList<>();
        
        exibirMenu();

        int opcao;
        do {
        	System.out.println("Oque deseja fazer?");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite uma senha (use apenas numeros): ");
                    int senha = sc.nextInt();
                    System.out.println("Digite seu saldo: ");
                    double saldo = sc.nextDouble();
                    System.out.println("Conta criada com sucesso!");
                    Account conta = new Account(senha, saldo);
                    contas.add(conta);
                    System.out.println(conta);
                    break;

                case 2:
                    System.out.println("Digite a senha da conta: ");
                    int senhaSaque = sc.nextInt();
                    boolean senhaCorretaSaque = false;
                    for (Account account : contas) {
                        if (account.getPassword() == senhaSaque) {
                            senhaCorretaSaque = true;
                            System.out.println("Digite o valor que deseja sacar: ");
                            double valorSaque = sc.nextDouble();
                            account.saque(valorSaque);
                        }
                    }
                    if (!senhaCorretaSaque) {
                        System.out.println("Senha incorreta!");
                    }
                    break;

                case 3:
                    System.out.println("Digite a senha da conta: ");
                    int senhaDeposito = sc.nextInt();
                    boolean senhaCorreta = false;
                    for (Account account : contas) {
                        if (account.getPassword() == senhaDeposito) {
                            senhaCorreta = true;
                            System.out.println("Digite o valor que deseja depositar: ");
                            double valorDeposito = sc.nextDouble();
                            account.deposito(valorDeposito);
                            System.out.println("Depósito realizado com sucesso.");
                        }
                    }
                    if (!senhaCorreta) {
                        System.out.println("Senha incorreta!");
                    }
                    break;

                case 4:
                    System.out.println("Digite a senha da conta: ");
                    int senhaVerificarSaldo = sc.nextInt();
                    senhaCorreta = false;
                    for (Account account : contas) {
                        if (account.getPassword() == senhaVerificarSaldo) {
                            senhaCorreta = true;
                            System.out.println("Seu saldo é: " + account.getBalance());
                        }
                    }
                    if (!senhaCorreta) {
                        System.out.println("Senha incorreta!");
                    }
                    break;
                    
                case 5:
                	System.out.println("Digite a senha da conta destinataria: ");
                	int senha1 = sc.nextInt();
                	System.out.println("Agora, digite a senha da conta que voce vai retirar: ");
                	int senha2 = sc.nextInt();
                	senhaCorreta = false;
                	
                	for (Account account : contas) {
						if (account.getPassword() == senha1) {
							for (Account account2 : contas) {
								if (account2.getPassword()==senha2) {
									senhaCorreta = true;
									System.out.println("Quantia disponivel: " + account2.getBalance() + "\nQuanto deseja retirar?");
									double transferencia = sc.nextDouble();
									account2.saque(transferencia);
									account.deposito(transferencia);
								}
							}
						}
					}
                	 if (!senhaCorreta) {
                         System.out.println("Senha incorreta!");
                     }
                	 break;
       
                case 6:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (opcao != 6);
        sc.close();
    }

private static void exibirMenu() {
    System.out.println("BANCO CLUBE DE PROGRAMACAO");
    System.out.println("1. Criar conta \n2. Realizar um saque \n3. Realizar um deposito \n4. Verificar Saldo \n5. Transferir fundos \n6. Sair");
}
}