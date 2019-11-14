package model;

public class Warrior implements Character {
	
	protected Part rightLeg;
	protected Part leftLeg;
	protected Part leftArm;
	protected Part rightArm;
	protected Part body;
	protected Part head;
	
	public Warrior() {
	this.rightLeg = new Part(20);
	this.leftLeg = new Part(20);
	this.leftArm = new Part(20);
	this.rightArm = new Part(20);
	this.body = new Part(20);
	this.head = new Part(20);
	}
	
	@Override
	public boolean hit(int damage) {
		// TODO Auto-generated method stub
		return true;
	}
	
	

	@Override
	public boolean strike(Character c, int damage) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRightLeg() {
		// TODO Auto-generated method stub
		return this.rightLeg.getHealth();
	}

	@Override
	public int getleftLeg() {
		// TODO Auto-generated method stub
		return this.leftLeg.getHealth();
	}

	@Override
	public int getleftArm() {
		// TODO Auto-generated method stub
		return this.leftArm.getHealth();
	}

	@Override
	public int getRightArm() {
		// TODO Auto-generated method stub
		return this.rightArm.getHealth();
	}

	@Override
	public int getBody() {
		// TODO Auto-generated method stub
		return this.body.getHealth();
	}

	@Override
	public int getHead() {
		// TODO Auto-generated method stub
		return this.head.getHealth();
	}
	
}
