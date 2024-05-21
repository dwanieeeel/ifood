package desafio_viii;

import java.util.Random;
import java.util.Scanner;

public class CampoMinado {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de linhas e colunas do campo minado:");
        int linhas = scanner.nextInt();
        int colunas = scanner.nextInt();
        System.out.println("Agora, digite a quantidade de bombas que o campo terá:");
        int nmr = scanner.nextInt();

        int[][] campoMinado = criarCampoMinado(linhas, colunas, nmr);
        calcularAdjacentes(campoMinado);
        imprimirCampoMinado(campoMinado, false);

        jogar(scanner, campoMinado);

        System.out.println("Fim do jogo.");
        scanner.close();
    }

    public static int[][] criarCampoMinado(int linhas, int colunas, int nmrdeMinas) {
        int[][] campoMinado = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                campoMinado[i][j] = 0;
            }
        }

        int minasColocadas = 0;
        while (minasColocadas < nmrdeMinas) {
            int linhaAleatoria = random.nextInt(linhas);
            int colunaAleatoria = random.nextInt(colunas);

            if (campoMinado[linhaAleatoria][colunaAleatoria] != -1) {
                campoMinado[linhaAleatoria][colunaAleatoria] = -1;
                minasColocadas++;
            }
        }

        return campoMinado;
    }

    public static void calcularAdjacentes(int[][] campoMinado) {
        int linhas = campoMinado.length;
        int colunas = campoMinado[0].length;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (campoMinado[i][j] == -1) {
                    continue;
                }

                int minasAdjacentes = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int ni = i + x;
                        int nj = j + y;
                        if (ni >= 0 && ni < linhas && nj >= 0 && nj < colunas && campoMinado[ni][nj] == -1) {
                            minasAdjacentes++;
                        }
                    }
                }
                campoMinado[i][j] = minasAdjacentes;
            }
        }
    }

    public static void imprimirCampoMinado(int[][] campoMinado, boolean revelar) {
        System.out.print("  ");
        for (int i = 0; i < campoMinado[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < campoMinado.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < campoMinado[i].length; j++) {
                if (revelar || campoMinado[i][j] < 0) {
                    System.out.print(formatarCelula(campoMinado[i][j]) + " ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }

    private static String formatarCelula(int valorCelula) {
        if (valorCelula == -1) {
            return " "; // Mina
        } else if (valorCelula == -2) {
            return " "; // Célula revelada vazia
        } else {
            return String.valueOf(valorCelula); // Número de minas adjacentes
        }
    }

    public static void jogar(Scanner scanner, int[][] campoMinado) {
        boolean[][] revelado = new boolean[campoMinado.length][campoMinado[0].length];

        while (true) {
            System.out.println("Digite as coordenadas de uma célula (linha, coluna):");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (linha < 0 || linha >= campoMinado.length || coluna < 0 || coluna >= campoMinado[0].length) {
                System.out.println("Coordenadas inválidas. Tente novamente.");
                continue;
            }

            if (campoMinado[linha][coluna] == -1) {
                System.out.println("Você encontrou uma mina! Fim do jogo.");
                imprimirCampoMinado(campoMinado, true);
                break;
            }

            revelarCelulasAdjacentes(campoMinado, revelado, linha, coluna);
            imprimirCampoMinado(campoMinado, true);

            if (verificarVitoria(campoMinado, revelado)) {
                System.out.println("Parabéns! Você revelou todas as células sem minas.");
                break;
            }
        }
    }

    private static void revelarCelulasAdjacentes(int[][] campoMinado, boolean[][] revelado, int linha, int coluna) {
        if (linha < 0 || linha >= campoMinado.length || coluna < 0 || coluna >= campoMinado[0].length) {
            return;
        }

        if (revelado[linha][coluna] || campoMinado[linha][coluna] == -1) {
            return;
        }

        revelado[linha][coluna] = true;

        if (campoMinado[linha][coluna] == 0) {
            campoMinado[linha][coluna] = -2; // Marcar célula como revelada

            // Recursivamente revelar células adjacentes
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        revelarCelulasAdjacentes(campoMinado, revelado, linha + i, coluna + j);
                    }
                }
            }
        }
    }

    private static boolean verificarVitoria(int[][] campoMinado, boolean[][] revelado) {
        for (int i = 0; i < campoMinado.length; i++) {
            for (int j = 0; j < campoMinado[i].length; j++) {
                if (campoMinado[i][j] != -1 && !revelado[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

