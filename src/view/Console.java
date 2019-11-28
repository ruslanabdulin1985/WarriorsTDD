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
		
	}

	public void showMainMenu() {
		System.out.println("WELCOME");
		System.out.println("");
		System.out.println("Enter p to Play");
	}

	public partsNames partToDefend(String input) {
		if (input.equals("1"))
			return partsNames.head;
		if (input.equals("2"))
			return partsNames.body;
		if (input.equals("3"))
			return partsNames.LeftLeg;
		if (input.equals("4"))
			return partsNames.RightLeg;
		if (input.equals("5"))
			return partsNames.LeftArm;
		if (input.equals("6"))
			return partsNames.RightArm;
		else
			throw new RuntimeException("ERROR");
	}

}
