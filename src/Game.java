import java.util.*;

public class Game {

	public static void main(String[] args) {
		System.out.println(
				"Jogo de turno aleatorio. Escolha 3 personagens para seu time, o jogo possui dois jogadores :D");
		System.out.println("Digite quantas cartas deseja ter em jogo para cada um");
		Scanner input = new Scanner(System.in);
		int qtdCartas = input.nextInt();
		System.out.println(
				"Digite 1 para Humano, 2 para Orc ou 3 para Dragão, aperte Enter para confirmar a escolha. Você pode escolher quantos quiser de cada.");
		System.out.println("Jogador 1, escolha: ");
		ArrayList<Combatente> cartas1 = criaDeck(qtdCartas);
		System.out.println("Jogador 2, escolha: ");
		ArrayList<Combatente> cartas2 = criaDeck(qtdCartas);
		System.out.println("A batalha começa!!!!");

		while (!cartas1.isEmpty() && !cartas2.isEmpty()) {

			for (int i = 0; i <= qtdCartas; i++) {
				int atacantePrimario = primeiroAtaque();
				Combatente personagem1 = null;
				Combatente personagem2 = null;
				if (i < cartas1.size()) {
					personagem1 = cartas1.get(i);
				}

				if (i < cartas2.size()) {
					personagem2 = cartas2.get(i);
				}

				if (personagem1 != null && personagem2 != null) {

					if (atacantePrimario == 1) {
						int dano = personagem1.getAtaque();
						personagem2.receberDano(dano);

						System.out.println("Posição " + i + ":" + " O " + personagem1.getNome()
								+ " do jogador 1 atacou com " + dano + " de dano o " + personagem2.getNome()
								+ " do jogador 2" + ", sobrando " + personagem2.getVida() + " de vida");

					} else {
						int dano = personagem2.getAtaque();
						personagem1.receberDano(dano);

						System.out.println("Posição " + i + ":" + " O " + personagem2.getNome()
								+ " do jogador 2 atacou com " + dano + " de dano o " + personagem1.getNome()
								+ " do jogador 1" + ", sobrando " + personagem1.getVida() + " de vida");
					}
					System.out.println("-----------------------------------------------------------------------------------------------------------");
				}
			}
			limpaMortos(cartas1);
			limpaMortos(cartas2);
		}
		if (!cartas1.isEmpty()) {
			System.out.println("Jogador 1 Venceu!!!!");
		} else {
			System.out.println("Jogador 2 Venceu!!!!");
		}
	}

	private static ArrayList<Combatente> limpaMortos(ArrayList<Combatente> cartas) {
		for (int i = cartas.size() - 1; i >= 0; i--) {

			if (!cartas.get(i).isAlive()) {
				cartas.remove(i);
			}
		}

		return cartas;
	}

	private static ArrayList<Combatente> criaDeck(int qtdCartas) {
		ArrayList<Combatente> cartas = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < qtdCartas; i++) {
			int escolha = input.nextInt();
			switch (escolha) {
			case 1:
				Humano humano = new Humano();
				cartas.add(humano);
				break;
			case 2:
				Orc orc = new Orc();
				cartas.add(orc);
				break;
			case 3:
				Dragao dragao = new Dragao();
				cartas.add(dragao);
				break;

			default:
				System.out.println("Escolha inválida, escolha novamente!");
				i--;
				break;

			}

		}
		return cartas;
	}

	public static int primeiroAtaque() {
		Random rand = new Random();
		int sorte = rand.nextInt(2) + 1;
		return sorte;
	}

}
