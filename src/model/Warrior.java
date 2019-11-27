package model;

import java.util.Random;

public class Warrior{
	
	boolean allive;
	Part [] parts;
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
	Part[] ToBeparts = {head, body, leftArm, leftLeg, rightArm, rightLeg};
	parts = ToBeparts;
	this.allive = checkIfAllive();
	}
	
	private boolean checkIfAllive() {
		boolean toReturn = true;
		for (Part p : parts) {
			if (p.getHealth()==0)
				toReturn = false;
		}
		return toReturn;
	}
	
	public Part getRandomPart() {
		Random rnd = new Random();
		return parts[rnd.nextInt(6)];
	}
	

	public boolean hit(int damage) {
		getRandomPart().hit(damage);
		this.allive = checkIfAllive();
		cacelBlock();
		return true;
		
	}

	private void cacelBlock() {
		for (Part p : parts)
			p.cancelBlock();
	}

	
	public boolean strike(Warrior c, int damage) {
		c.hit(damage);
		return true;
	}

	
	public int getRightLeg() {
		return this.rightLeg.getHealth();
	}

	
	public int getleftLeg() {
		return this.leftLeg.getHealth();
	}

	
	public int getleftArm() {
		return this.leftArm.getHealth();
	}

	
	public int getRightArm() {
		return this.rightArm.getHealth();
	}

	
	public int getBody() {
		return this.body.getHealth();
	}

	
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
