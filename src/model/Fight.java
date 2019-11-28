package model;
import model.partsNames;

public class Fight {
	
	Warrior player;
	Warrior enemy; 

	public Fight(Warrior p_warrior, Warrior e_warrior) {
		this.player = p_warrior;
		this.enemy = e_warrior;
	}

	public void defend() {
		this.enemy.strike(this.player, 5);
	}

	public void atack() {
		this.player.strike(enemy, 5);
	}

	public void setBlockWarrior(partsNames part1, partsNames part2) {
		Part partfake1 = new Part(20);
		Part partfake2 = new Part(20);
		this.player.block(partfake1, partfake2);
	}
	
	public void setBlockEnemy() {
		this.enemy.block(enemy.getRandomPart(), enemy.getRandomPart());
	}

	public boolean isGameOver() {
		return (this.enemy.isDead() || this.player.isDead());
	}

	public boolean isPlayerWin() {
		return (this.enemy.isDead() && !this.player.isDead());
	}

	public void quit() {
		
	}

	public Warrior getPlayer() {
		return this.player;
	}

	public Warrior getEnemy() {
		return this.enemy;
	}

}
