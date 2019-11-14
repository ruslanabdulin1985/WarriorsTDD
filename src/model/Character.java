package model;

public interface Character {
	public boolean hit(int damage);
	
	public boolean strike(Character c, int damage);
}
