public class Combatente {
	public int vida;
	public String nome;	
	
	public Combatente(int vida, String nome) {
		this.vida = vida;
		this.nome = nome;
	}
	public boolean isAlive() {
		return this.vida > 0;
	}
	public void receberDano(int dano) {
		 this.vida -= dano;
	}
	public int sobraVida() {
		return this.vida;
	}
	public String pegaNome() {
		return this.nome;
	}
}
