package model;

public class Warrior implements Character {
	
	protected Part rightLeg;
	protected Part leftLeg;
	protected Part leftArm;
	protected Part rightArm;
	protected Part body;
	protected Part head;
	
	public Warrior(Part Head, Part Body, Part RLeg, Part LLeg, Part RArm, Part LArm) {
	this.rightLeg = RLeg;
	this.leftLeg = LLeg;
	this.leftArm = LArm;
	this.rightArm = RArm;
	this.body = Body;
	this.head = Head;
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
		return this.rightLeg.getHealth();
	}

	@Override
	public int getleftLeg() {
		return this.leftLeg.getHealth();
	}

	@Override
	public int getleftArm() {
		return this.leftArm.getHealth();
	}

	@Override
	public int getRightArm() {
		return this.rightArm.getHealth();
	}

	@Override
	public int getBody() {
		return this.body.getHealth();
	}

	@Override
	public int getHead() {
		return this.head.getHealth();
	}
	
}
