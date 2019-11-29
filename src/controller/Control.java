package controller;

import model.Fight;
import model.partsNames;
import model.Part;
import view.Console;

public class Control {
	
	statuses status;
	
	public enum statuses{
		mainMenu, action, 
	}
	
	
	public Control() {
		status = statuses.mainMenu;
	}

	public void setStatus(statuses st) {
		
		this.status = st;
		
	}

	public statuses getStatus() {
		return this.status;
	}

	public void run(Fight game, Console con) {
		
		if (status.equals(statuses.mainMenu)) {
			con.showMainMenu();
			this.status = statuses.action;
		}
		
		String userInput = con.getInput();
		System.out.println(status);
		
		if (con.wantsToQuit(userInput)) {
			game.quit();
		}
		
		else if(status.equals(statuses.action)) {
			con.renew(game.getPlayer(), game.getEnemy());
			con.showFirstPartToBlock();
			partsNames firstPartToBlock = con.getPartNameToBlock(userInput);
			con.showSecondPartToBlock();
			game.setBlockWarrior(partsNames.body, partsNames.head);
			game.setBlockEnemy();
			game.atack();
			game.defend();
		}
		
	}

}
