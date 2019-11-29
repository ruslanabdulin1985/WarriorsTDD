package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
	void WhenUserInputIs1ThenPartNameToBlockIsBody() {
		Console sut = new Console();
		String mockInput = "1";
		partsNames expeced = partsNames.body;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expeced, actual);
	}
	
	@Test
	void WhenUserInputIs2ThenPartNameToBlockIsLLeg() {
		Console sut = new Console();
		String mockInput = "2";
		partsNames expeced = partsNames.LeftLeg;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expeced, actual);
	}
	
	@Test
	void WhenUserInputIs3ThenPartNameToBlockIsRLeg() {
		Console sut = new Console();
		String mockInput = "3";
		partsNames expeced = partsNames.RightLeg;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expeced, actual);
	}
	
	@Test
	void WhenUserInputIs4ThenPartNameToBlockIsLArm() {
		Console sut = new Console();
		String mockInput = "4";
		partsNames expeced = partsNames.LeftArm;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expeced, actual);
	}
	
	@Test
	void WhenUserInputIs5ThenPartNameToBlockIsRArm() {
		Console sut = new Console();
		String mockInput = "5";
		partsNames expeced = partsNames.RightArm;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expeced, actual);
	}
	
	@Test
	void WhenUserInputIsRandomStringThenReturnRuntimeException() {
		Console sut = new Console();
		String mockInput = "RandomString";
	
		 assertThrows(RuntimeException.class, () -> {
		        sut.partToDefend(mockInput);
		    });
	}

	@Test
	void WhenUserInputIs1ThenPartNameToBlockIsHead() {
		Console sut = new Console();
		String mockInput = "0";
		partsNames expeced = partsNames.head;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expeced, actual);
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
	void WhenWantsToDefendHeadThen0() {
		Console sut = new Console();
		String mockInput = "0";
		partsNames expected = partsNames.head;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	@Test
	void WhenWantsToDefendBodyThen1() {
		Console sut = new Console();
		String mockInput = "1";
		partsNames expected = partsNames.body;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	
	@Test
	void WhenWantsToDefendLLegThen2() {
		Console sut = new Console();
		String mockInput = "2";
		partsNames expected = partsNames.LeftLeg;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	@Test
	void WhenWantsToDefendRLegThen3() {
		Console sut = new Console();
		String mockInput = "3";
		partsNames expected = partsNames.RightLeg;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	@Test
	void WhenWantsToDefendLArmThen4() {
		Console sut = new Console();
		String mockInput = "4";
		partsNames expected = partsNames.LeftArm;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
	@Test
	void WhenWantsToDefendRArmThen5() {
		Console sut = new Console();
		String mockInput = "5";
		partsNames expected = partsNames.RightArm;
		partsNames actual = sut.partToDefend(mockInput);
		assertEquals(expected, actual);
	}
	
}
