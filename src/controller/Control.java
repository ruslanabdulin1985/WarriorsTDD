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
		
		con.showMainMenu();
		String userInput = con.getInput();
		
		if (con.wantsToQuit("q")) {
			game.quit();
		}
		
		else if (status.equals(statuses.mainMenu)) {
			con.showMainMenu();
			this.status = statuses.action;
		}
		
		else if(status.equals(statuses.action)) {
			
			game.setBlockWarrior(partsNames.body, partsNames.head);
			game.setBlockEnemy();
			
			game.atack();
			game.defend();
			con.renew(game.getPlayer(), game.getEnemy());
		}
		
	}

}
