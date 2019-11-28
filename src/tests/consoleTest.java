package tests;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import model.partsNames;
import view.Console;

public class consoleTest {
	
	@Test
	void WhenWantsToQuitThenTrue() {
		Console sut = new Console();
		String mockInput = "q";
		boolean actual = sut.wantsToQuit(mockInput);
		assertTrue(actual);
	}
	
	@Test
	void WhenDontWantToQuitThenFalse() {
		Console sut = new Console();
		String mockInput = "f";
		boolean actual = sut.wantsToQuit(mockInput);
		assertFalse(actual);
	}
	
	@Test
	void WhenWantsToPlayThenTrue() {
		Console sut = new Console();
		String mockInput = "p";
		boolean actual = sut.wantsToPlay(mockInput);
		assertTrue(actual);
	}
	
	@Test
	void WhenDontWantToPlayThenFalse() {
		Console sut = new Console();
		String mockInput = "f";
		boolean actual = sut.wantsToQuit(mockInput);
		assertFalse(actual);
	}
	
	
	@Test
	void WhenWantsToDefendHeadThen1() {
		Console sut = new Console();
		String mockInput = "1";
		partsNames expected = partsNames.head;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	@Test
	void WhenWantsToDefendBodyThen2() {
		Console sut = new Console();
		String mockInput = "2";
		partsNames expected = partsNames.body;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	
	@Test
	void WhenWantsToDefendLLegThen3() {
		Console sut = new Console();
		String mockInput = "3";
		partsNames expected = partsNames.LeftLeg;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	@Test
	void WhenWantsToDefendRLegThen4() {
		Console sut = new Console();
		String mockInput = "4";
		partsNames expected = partsNames.RightLeg;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	@Test
	void WhenWantsToDefendLArmThen5() {
		Console sut = new Console();
		String mockInput = "5";
		partsNames expected = partsNames.LeftArm;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	@Test
	void WhenWantsToDefendRArmThen6() {
		Console sut = new Console();
		String mockInput = "6";
		partsNames expected = partsNames.RightArm;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
}
