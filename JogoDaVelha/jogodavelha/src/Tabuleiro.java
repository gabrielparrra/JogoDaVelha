public class Tabuleiro {
    private Campo[][] velha;

    public Tabuleiro() {
        velha = new Campo[3][3];
        iniciarJogo();
    }

    public void iniciarJogo() {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                velha[l][c] = new Campo();
            }
        }
    }

    public void desenhaJogo() {
        System.out.println("  0   1   2");
        for (int l = 0; l < 3; l++) {
            System.out.printf("%d %c | %c | %c %n", l, velha[l][0].getSimbolo(), velha[l][1].getSimbolo(), velha[l][2].getSimbolo());
            if (l < 2) {
                System.out.println("------------");
            }
        }
    }

    public boolean verificarJogada(int[] p, char simboloAtual) {
        if (velha[p[0]][p[1]].getSimbolo() == ' ') {
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            return false;
        }
    }

    public String verificaVitoria() {
        // Verifica as linhas
        for (int i = 0; i < 3; i++) {
            if (velha[i][0].getSimbolo() == velha[i][1].getSimbolo() && velha[i][1].getSimbolo() == velha[i][2].getSimbolo() && velha[i][0].getSimbolo() != ' ') {
                return String.valueOf(velha[i][0].getSimbolo());
            }
        }

        // Verifica as colunas
        for (int i = 0; i < 3; i++) {
            if (velha[0][i].getSimbolo() == velha[1][i].getSimbolo() && velha[1][i].getSimbolo() == velha[2][i].getSimbolo() && velha[0][i].getSimbolo() != ' ') {
                return String.valueOf(velha[0][i].getSimbolo());
            }
        }

        // Verifica a diagonal principal
        if (velha[0][0].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][2].getSimbolo() && velha[0][0].getSimbolo() != ' ') {
            return String.valueOf(velha[0][0].getSimbolo());
        }

        // Verifica a diagonal secundária
        if (velha[0][2].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][0].getSimbolo() && velha[0][2].getSimbolo() != ' ') {
            return String.valueOf(velha[0][2].getSimbolo());
        }

        // Se nenhuma condição de vitória for encontrada, retorna string vazia
        return "";
    }
}