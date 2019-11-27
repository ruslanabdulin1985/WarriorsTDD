package tests;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;


import controller.Control;
import controller.Control.statuses;
import model.Fight;
import model.Warrior;
import view.Console;

public class ControlTest {
	
	@Test
	void whenStateMainMenuAndWantsToPlayThenStatusEqualsChooseDefendParts() {
		Fight game = mock(Fight.class);
		Console con = mock(Console.class);
		when(con.wantsToPlay()).thenReturn(true);
		
		Control sut = new Control();
		sut.setStatus(Control.statuses.mainMenu);
		sut.run(game, con);
		
		
		Control.statuses actual = sut.getStatus();
		Control.statuses expected = Control.statuses.action;
		
		assertEquals(expected, actual);
	}
	
	@Test
	void whenControlCreatedThenStatusEqualsMainMenu() {
		Control sut = new Control();
		Control.statuses actual = sut.getStatus();
		Control.statuses expected = Control.statuses.mainMenu;
		assertEquals(expected, actual);
	}
	
	@Test
	void whenStatusSetActionThenStatusEqualsAction() {
		Control sut = new Control();
		sut.setStatus(statuses.action);
		Control.statuses actual = sut.getStatus();
		Control.statuses expected = Control.statuses.action;
		assertEquals(expected, actual);
	}
	
	
	class ControlStub extends Control{
		public ControlStub(){
			super();
		}
		
		public statuses getStatus() {
			return statuses.action;
		}
	}
}
