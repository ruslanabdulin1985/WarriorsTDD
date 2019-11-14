package model;

public class Part {
	
	private int health;

	public Part(int h) {
		this.health = h;
	}
	
	public boolean hit(int power) {
		return false;
	}
	
	public int getHealth() {
		return 0;
	}

}
