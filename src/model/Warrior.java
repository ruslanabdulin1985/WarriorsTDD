package model;

import java.util.Random;

public class Warrior implements Character {
	
	boolean allive;
	
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
	this.allive = checkIfAllive();
	}
	
	private boolean checkIfAllive() {
		boolean toReturn = true;
		Part [] parts = {head, body, leftArm, leftLeg, rightArm, rightLeg};
		for (Part p : parts) {
			if (p.getHealth()==0)
				toReturn = false;
		}
		return toReturn;
	}
	
	@Override
	public boolean hit(int damage) {
		Random rnd = new Random();
		Part [] parts = {head, body, leftArm, leftLeg, rightArm, rightLeg};
		parts[rnd.nextInt(6)].hit(damage);
		this.allive = checkIfAllive();
		return true;
	}

	@Override
	public boolean strike(Character c, int damage) {
		c.hit(damage);
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

	public boolean isDead() {
		return !allive;
	}

	public void block(Part part1, Part part2) {
		part1.setBlock();
		part2.setBlock();
	}
	
}
