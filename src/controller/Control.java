package controller;

import model.Fight;
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
		if (status.equals(statuses.mainMenu) && con.wantsToPlay()) {
			this.status = statuses.action;
			
		}
		
		else if(status.equals(statuses.action)) {
			Part[] partsToBlock = con.getDefendParts();
			
			game.setBlockWarrior(partsToBlock[0], partsToBlock[1]);
			game.setBlockEnemy();
			
			game.atack();
			game.defend();
		}
		
	}

}
