package testes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramII {
    public static void main(String[] args) {
        Scanner sc = null;
        PrintWriter pw = null;

        try {
            // Leitura do arquivo de entrada
            sc = new Scanner(new File("alunos.txt"));
            // Criação do arquivo de saída
            pw = new PrintWriter(new File("output.txt"));

            Aluno a;
            var alunos = new ArrayList<Aluno>();

            // Processamento das linhas do arquivo de entrada
            while (sc.hasNext()) {
            	String line = sc.nextLine();
            	String[] campos = line.split(",");
            	String dataString = campos[2].trim();
                Integer id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                LocalDate data = LocalDate.parse(dataString);
                a = new Aluno(id, nome, data);
                alunos.add(a);

                // Escrever informações no arquivo de saída
                pw.println("ID: " + a.getId() + ", Nome: " + a.getName() + ", Nascimento: " + a.getNascimento());
            }
            System.out.println(alunos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Certifique-se de fechar os recursos corretamente no bloco finally
            if (sc != null) {
                sc.close();
            }
            if (pw != null) {
                pw.close();
            }
        }
    }
}

