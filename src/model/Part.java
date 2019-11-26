package model;

public class Part {
	boolean blocked = false;
	private int health;

	public Part(int h) {
		this.health = h;
	}
	
	public boolean hit(int power) {
		if (power<this.health && !blocked) {
			this.health -= power;
			return true;
		}
		else if (power>=this.health && !blocked) {
			this.health = 0;
			return true;
		}
		
		else {
			return false;
		}	
	}
	
	public int getHealth() {
		return this.health;
	}

	public void setBlock() {
		this.blocked = true;
	}
	

}
