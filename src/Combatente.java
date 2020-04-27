import java.util.Random;

public abstract class Combatente {
	protected int vida;
	protected int ataqueMin;
	protected int ataqueMax;
	protected String nome;

	public Combatente(int vida, int ataqueMin, int ataqueMax, String nome) {
		this.vida = vida;
		this.ataqueMin = ataqueMin;
		this.ataqueMax = ataqueMax;
		this.nome = nome;
	}

	public boolean isAlive() {
		return this.vida > 0;
	}

	public void receberDano(int ataque) {
		if (ataque >= vida) {
			vida = 0;
		} else {
			vida -= ataque;
		}
	}

	public int getVida() {
		return this.vida;
	}

	public String getNome() {
		return this.nome;
	}

	public int getAtaque() {
		Random rand = new Random();
		int ataque = rand.nextInt(this.ataqueMax) + 1;
		if (ataque <= this.ataqueMin) {
			return ataque = this.ataqueMin;
		} else {
			return ataque;
		}
	}
}
