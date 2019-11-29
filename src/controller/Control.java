package controller;

import org.mockito.exceptions.verification.WantedButNotInvoked;

import model.Fight;
import model.partsNames;
import model.Part;
import view.Console;

public class Control {
	
	statuses status;
	
	public enum statuses{
		mainMenu, action, ready
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
			String userInput = con.getInput();
			if(con.wantsToPlay(userInput)){
				status = statuses.action;
			}
			if (con.wantsToQuit(userInput)) {
				game.quit();
			}
		}
		
		if(status.equals(statuses.action)) {
			con.renew(game.getPlayer(), game.getEnemy());
			con.showFirstPartToBlock();
			String userInput = con.getInput();
			partsNames firstPartToBlock = null;
			
			while(firstPartToBlock==null) {
				try {
					firstPartToBlock = con.partToDefend(userInput);
				}
				catch(RuntimeException e) {
					System.err.println("Wrong Input! Repeat!");
					userInput = con.getInput();
				}
			}
			con.showSecondPartToBlock();
			userInput = con.getInput();
			
			partsNames secondPartToBlock=null;
			
			while(secondPartToBlock==null) {
				try {
					secondPartToBlock = con.partToDefend(userInput);
				}
				catch(RuntimeException e) {
					System.err.println("Wrong Input! Repeat!");
					userInput = con.getInput();
				}
			}
			
			game.setBlockWarrior(firstPartToBlock, secondPartToBlock);
			game.setBlockEnemy();
			game.atack();
			game.defend();
			if (game.isPlayerWin()) {
				con.renew(game.getPlayer(), game.getEnemy());
				con.showWonScreen();
			}
			else if (game.isGameOver()) {
				con.renew(game.getPlayer(), game.getEnemy());
				con.showLostScreen();
			}
		}
		
	}

}
