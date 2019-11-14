package model;

public interface Character {
	
	public int getRightLeg();
	public int getleftLeg();
	public int getleftArm();
	public int getRightArm();
	public int getBody();
	public int getHead();
	
	
	public boolean hit(int damage);
	
	public boolean strike(Character c, int damage);
}
