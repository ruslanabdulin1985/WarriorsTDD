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
		return false;
	}

	public boolean wantsToQuit(String str) {
		return false;
	}

	public partsNames[] getDefendParts() {
		partsNames parts[] = {partsNames.head, partsNames.body};
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

}
