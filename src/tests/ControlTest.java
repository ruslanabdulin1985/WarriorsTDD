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
import model.Part;
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
	
	@Test
	void whenStatusActionThenAttack() {
		Part somePart = mock(Part.class);
		Part[] partsToReturn = {somePart, somePart};
		Fight game = mock(Fight.class);
		Console con = mock(Console.class);
		Control sut = new Control();
		when(con.getDefendParts()).thenReturn(partsToReturn);

		sut.setStatus(statuses.action);
		sut.run(game, con);
		
		verify(game).atack();
	}
	
	@Test
	void whenStatusActionThenDefend() {
		Part somePart = mock(Part.class);
		Part[] partsToReturn = {somePart, somePart};
		Fight game = mock(Fight.class);
		Console con = mock(Console.class);
		Control sut = new Control();
		when(con.getDefendParts()).thenReturn(partsToReturn);
		sut.setStatus(statuses.action);
		sut.run(game, con);
		
		verify(game).defend();
	}
	
	@Test
	void whenStatusActionThenEnemyDefend() {
		Part somePart = mock(Part.class);
		Part[] partsToReturn = {somePart, somePart};
		Fight game = mock(Fight.class);
		Console con = mock(Console.class);
		Control sut = new Control();
		when(con.getDefendParts()).thenReturn(partsToReturn);
		
		sut.setStatus(statuses.action);
		sut.run(game, con);
		
		verify(game).setBlockEnemy();
	}
	
	@Test
	void whenStatusActionAndDefendPartsSetThenDefend() {
		Part somePart = mock(Part.class);
		Part[] partsToReturn = {somePart, somePart};
		Fight game = mock(Fight.class);
		Console con = mock(Console.class);
		when(con.getDefendParts()).thenReturn(partsToReturn);
		Control sut = new Control();
		
		sut.setStatus(statuses.action);
		sut.run(game, con);
		
		verify(game).setBlockWarrior(somePart, somePart);
	}
	
	@Test
	void whenWantsToQuitThenQuit() {
		Fight game = mock(Fight.class);
		Console con = mock(Console.class);
		when(con.wantsToQuit()).thenReturn(true);
		Control sut = new Control();
		
		sut.run(game, con);
		sut.setStatus(statuses.action);
		
		verify(game).quit();
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
