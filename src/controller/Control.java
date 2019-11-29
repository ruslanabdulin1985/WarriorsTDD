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
			partsNames firstPartToBlock = con.getPartNameToBlock(userInput);
			con.showSecondPartToBlock();
			userInput = con.getInput();
			partsNames secondPartToBlock = con.getPartNameToBlock(userInput);
			
			game.setBlockWarrior(firstPartToBlock, secondPartToBlock);
			game.setBlockEnemy();
			game.atack();
			game.defend();
			if (game.isPlayerWin())
				con.showWonScreen();
			else if (game.isGameOver())
				con.showLostScreen();
		}
		
	}

}
