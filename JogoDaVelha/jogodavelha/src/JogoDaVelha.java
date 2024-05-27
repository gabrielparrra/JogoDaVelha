import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogadorX = new Jogador('X');
        Jogador jogadorO = new Jogador('O');
        Jogador jogadorAtual = jogadorX;
        boolean game = true;
        String vitoria = "";
        Ranking ranking = new Ranking();
        int menu = 0;

            do{
                System.out.println("1. Jogar");
                System.out.println("2. Exibir ranking");
                System.out.println("0. Sair");
                System.out.println("-------------");
                menu = ler.nextInt();

                if(menu==1){

                    while (game) {
                        tabuleiro.desenhaJogo();
                        vitoria = tabuleiro.verificaVitoria();
            
                        if (!vitoria.equals("")) {
                            System.out.printf("Jogador %s venceu%n", vitoria);
                            ranking.adicionarVitoria(jogadorAtual.getSimbolo());
                            break;
                        }
            
                        try {
                            int[] jogada = jogadorAtual.jogar(ler);
                            if (tabuleiro.verificarJogada(jogada, jogadorAtual.getSimbolo())) {
                                // Verifica a vitória novamente após a jogada válida
                                vitoria = tabuleiro.verificaVitoria();
                                if (!vitoria.equals("")) {
                                    System.out.printf("Jogador %s venceu%n", vitoria);
                                    ranking.adicionarVitoria(jogadorAtual.getSimbolo());
                                    break;
                                }
                                jogadorAtual = (jogadorAtual == jogadorX) ? jogadorO : jogadorX;
                            } else {
                                System.out.println("Jogada inválida! Tente novamente.");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro na jogada! Tente novamente.");
                            ler.next(); // Limpa a entrada inválida
                        }
                    }

                    System.out.println("Fim de jogo");

                    tabuleiro = new Tabuleiro();
                    jogadorAtual = jogadorX;
                    game = true;
                    
                    
                }

                else if(menu==2){
                    ranking.exibirRanking();
                }
            }while(menu!=0);
    }

}