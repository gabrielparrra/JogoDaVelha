import java.util.Scanner;

public class Jogador {
    private char simbolo;
    private int vitorias;

    public Jogador(char simbolo) {
        this.simbolo = simbolo;
        this.vitorias = 0;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void incrementarVitorias() {
        this.vitorias++;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int[] jogar(Scanner ler) {
        int[] p = new int[2];
        System.out.printf("Quem joga: %c%n", simbolo);
        System.out.print("Informe a linha: ");
        p[0] = ler.nextInt();
        System.out.print("Informe a coluna: ");
        p[1] = ler.nextInt();
        return p;
    }
}