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
		Part pt1 = partToName(part1, player);
		Part pt2 = partToName(part2, player);
		this.player.block(pt1, pt2);
	}
	
	private Part partToName(partsNames pn, Warrior wr) {
	if (pn.equals(partsNames.head))
		return wr.getPartHead();
	if (pn.equals(partsNames.body))
		return wr.getPartBody();
	if (pn.equals(partsNames.LeftArm))
		return wr.getPartLArm();
	if (pn.equals(partsNames.RightArm))
		return wr.getPartRArm();
	if (pn.equals(partsNames.LeftLeg))
		return wr.getPartLLeg();
	if (pn.equals(partsNames.RightLeg))
		return wr.getPartRLeg();
	else
		throw new RuntimeException("Error");
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
		System.exit(-10);
	}

	public Warrior getPlayer() {
		return this.player;
	}

	public Warrior getEnemy() {
		return this.enemy;
	}

}
