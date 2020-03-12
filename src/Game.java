import java.util.Random;

public class Game {

	public static void main(String[] args) {
		
		Humano personagem1 = new Humano(100, "Claudio");
		Orc personagem2 = new Orc(100, "Ghowter");
		int atacantePrimario = primeiroAtaque();
		
 
	 do{		 
			System.out.println("Humano está com " + personagem1.sobraVida() + " de vida");
			System.out.println("Orc está com " + personagem2.sobraVida() + " de vida");
			System.out.println("----------------------------");
			if(atacantePrimario == 1) {
				if(personagem1.isAlive() == true) {
					personagem2.receberDano(ataque());
				}
				if(personagem2.isAlive() == true){
					personagem1.receberDano(ataque());
				}
			} else {
				if(personagem2.isAlive() == true) {
					personagem1.receberDano(ataque());
				}
				if(personagem1.isAlive() == true){
					personagem2.receberDano(ataque());
				}
			}			
		 	
	}while(personagem1.sobraVida() > 0 && personagem2.sobraVida() > 0);
	 
	 System.out.println(atacantePrimario);
	 
 	if(personagem1.vida > 0) {
			System.out.println(personagem1.pegaNome() + " ganhou com " + personagem1.sobraVida() + " de vida");
			System.out.println(personagem2.pegaNome() + " perdeu com " + personagem2.sobraVida() + " de vida");

		} else {
			System.out.println(personagem2.pegaNome() + " ganhou com " + personagem2.sobraVida() + " de vida");
			System.out.println(personagem1.pegaNome() + " perdeu com " + personagem1.sobraVida() + " de vida");
		}
	}
		
	public static int ataque () {
	Random rand = new Random(); 
	int ataque = rand.nextInt(10) + 1;
	return ataque;
	}
	
	public static int primeiroAtaque() {
		Random rand = new Random(); 
		int ataque = rand.nextInt(2) + 1;
		return ataque;
	}

}
