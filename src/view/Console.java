package view;

import java.util.Scanner;


import model.Warrior;
import model.partsNames;

public class Console {
	Scanner sc = new Scanner(System.in);
	
	public String getInput() {
		return sc.nextLine();
	}
	
	public boolean wantsToPlay(String str) {
		return str.equals("p");
	}

	public boolean wantsToQuit(String str) {
		return str.equals("q");
	}

	public partsNames[] getDefendParts() {
		partsNames parts[] = {partToDefend(getInput()), partToDefend(getInput())};
		return parts;
	}

	public void renew(Warrior player, Warrior enemy) {
		System.out.println("\t\t:::STATUS:::");
		System.out.println("");
		System.out.println("YOU\t\tENEMY");
		System.out.println("\tHEAD" );
		System.out.println(player.getHead() + "\t\t" + enemy.getHead());
		System.out.println("\tBODY" );
		System.out.println(player.getBody() + "\t\t" + enemy.getBody());
		System.out.println("\tLEFT HAND" );
		System.out.println(player.getleftArm() + "\t\t" + enemy.getleftArm());
		System.out.println("\tRIGT HAND" );
		System.out.println(player.getRightArm() + "\t\t" + enemy.getRightArm());
		System.out.println("\tLEFT LEG" );
		System.out.println(player.getleftLeg() + "\t\t" + enemy.getleftLeg());
		System.out.println("\tRIGHT LEG" );
		System.out.println(player.getRightLeg() + "\t\t" + enemy.getRightLeg());
		
	}
	
	public void showFirstPartToBlock() {
		System.out.println();
		System.out.println("Choose first part to block: ");
		showPartsMenu();
	}
	
	public void showSecondPartToBlock() {
		System.out.println("Choose second part to block: ");
		showPartsMenu();
	}
	
	private void showPartsMenu() {
		int i=0;
		for(partsNames n : partsNames.values()) {
			System.out.println("" + i + " " + n);
			i++;
		}
	}
	
	

	public void showMainMenu() {
		System.out.println("WELCOME");
		System.out.println("");
		System.out.println("Enter p to Play");
		System.out.println("Enter q to Exit");
	}

	public partsNames partToDefend(String input) {
		if (input.equals("0"))
			return partsNames.head;
		if (input.equals("1"))
			return partsNames.body;
		if (input.equals("2"))
			return partsNames.LeftLeg;
		if (input.equals("3"))
			return partsNames.RightLeg;
		if (input.equals("4"))
			return partsNames.LeftArm;
		if (input.equals("5"))
			return partsNames.RightArm;
		else
			throw new RuntimeException("ERROR");
	}
	
	public void showWonScreen() {
		System.out.println("!!!\tYou WON!\t!!!");
		
	}
	
	public void showLostScreen() {
		System.out.println("!!!\tYou LOST!\t!!!");
		
	}
	


}
