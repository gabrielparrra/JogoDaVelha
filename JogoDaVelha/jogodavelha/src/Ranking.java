public class Ranking {
    private int vitoriasX;
    private int vitoriasO;

    public Ranking() {
        vitoriasX = 0;
        vitoriasO = 0;
    }

    public void adicionarVitoria(char simbolo) {
        if (simbolo == 'X') {
            vitoriasX++;
        } else if (simbolo == 'O') {
            vitoriasO++;
        }
    }

    public void exibirRanking() {
        System.out.println("Ranking de Vitórias:");
        System.out.printf("Jogador X: %d vitórias%n", vitoriasX);
        System.out.printf("Jogador O: %d vitórias%n", vitoriasO);
    }
}
