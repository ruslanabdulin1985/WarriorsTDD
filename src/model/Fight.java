package model;

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

	public void setBlockWarrior(Part part1, Part part2) {
		this.player.block(part1, part2);
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

}
