package partes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
        Scanner sc = null;
        PrintWriter pw = null;

        try {
            sc = new Scanner(new File("products.txt"));
            pw = new PrintWriter(new File("products.txt"));

            Produto a;
            var products = new ArrayList<Produto>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] campos = line.split(",");
                String nome = campos[0];
                Integer quantity = Integer.parseInt(campos[1]);
                Double price = Double.parseDouble(campos[2]);

                a = new Produto(nome, quantity, price);
                products.add(a);
            }

            System.out.println("Produtos disponíveis:");
            for (Produto produto : products) {
                System.out.println(produto);
            }

            Scanner input = new Scanner(System.in);
            int opcao;
                
                do {
                      System.out.println("\nEscolha uma opção:");
                      System.out.println("0. Para sair");
                      System.out.println("1. Comprar algo");
                      System.out.println("2. Repor Algo");

                      // Verifica se há um próximo inteiro antes de chamar nextInt()
                      opcao = input.nextInt();
                	switch (opcao) {
                    case 1:
                        System.out.println("Você escolheu comprar algo.");
                        System.out.println("Produtos disponíveis para compra:");
                        for (Produto produto : products) {
                            System.out.println(produto.getName());
                        }
                        System.out.println("Qual deseja comprar? ");
                        String nome_do_produto = input.next(); 
                        input.nextLine();
                        
                        boolean encontrado = false;
                        for (Produto produto : products) {
                            if (nome_do_produto.equalsIgnoreCase(produto.getName())) {
                                encontrado = true;
                                System.out.println("Quantos deseja?");
                                int qunt = input.nextInt();
                                if (qunt <= produto.getQuantity()) {
                                    produto.setQuantity(produto.getQuantity() - qunt);
                                    double precoTotal = produto.getPrice() * qunt;
                                    System.out.printf("Compra aprovada no preço de: %.2f\n", precoTotal);
                                    System.out.println("Quantidade restante: " + produto.getQuantity());
                                } else {
                                    System.out.println("Quantidade insuficiente em estoque.");
                                }
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Produto não encontrado.");
                        }
                        break;
                    case 2:
                        System.out.println("Você escolheu repor algo.");
                        for (Produto produto : products) {
                        	System.out.printf("Quantidade restante de %s: %d \n", produto.getName(), produto.getQuantity());
						}
                        System.out.println("Qual deseja repor? ");
                        String nome_do_produto_para_repor = input.next(); 
                        input.nextLine();
                        
                        boolean reposicao = false;
                        for (Produto produto : products) {
                            if (nome_do_produto_para_repor.equalsIgnoreCase(produto.getName())) {
                                reposicao = true;
                                System.out.println("Deseja repor quantos?");
                                int qunt = input.nextInt();
                                produto.setQuantity(produto.getQuantity()+qunt);
                            }
                            }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (opcao!= 0);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo 'products.txt' não encontrado.");
            e.printStackTrace();
        } finally {
            // Certifique-se de fechar o Scanner
            if (sc != null) {
                sc.close();
            }
        }
    }
}
