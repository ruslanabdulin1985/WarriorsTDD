package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Part;
import model.Warrior;

import static org.mockito.Mockito.*;

class warriorTest {
   
    
	@Test
	void getRightHandTest() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		
		int actual = sut.getRightArm();
		int expected = 10;
		assertEquals(expected, actual);
		verify(sharedPart, atLeastOnce()).getHealth();
	}
	
	@Test
	void getLeftHandTest() {

		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );

		int actual = sut.getleftArm();
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	
	@Test
	void getRightLegTest() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getRightArm();
		int expected = 10;
		assertEquals(expected, actual);
		verify(sharedPart, atLeastOnce()).getHealth();

	}
	
	@Test
	void getLeftLegTest() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getleftLeg();
		int expected = 10;
		assertEquals(expected, actual);
		verify(sharedPart, atLeastOnce()).getHealth();

	}
	
	@Test
	void getHeadTest() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getHead();
		int expected = 10;
		assertEquals(expected, actual);
		verify(sharedPart, atLeastOnce()).getHealth();
	}
	
	@Test
	void getBodyTest() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getBody();
		int expected = 10;
		assertEquals(actual, expected);
		verify(sharedPart, atLeastOnce()).getHealth();
	}
	
	
	@Test
	void testHitFact() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		boolean actual = sut.hit(20);
		assertTrue(actual);
	}
	
	@Test 
	void testHitDamage() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(3);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);

		sut.hit(7);
		int expected = 3;
		int actual = sut.getHead();
		assertEquals(expected, actual);
		verify(sharedPart, atLeastOnce()).getHealth();
	}
	
	@Test 
	void testIfDead() {
		Part sharedPart = mock(Part.class);
		Part deadPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		when(deadPart.getHealth()).thenReturn(0);
		
		Warrior sut = new WarriorStub(sharedPart, deadPart, sharedPart, sharedPart, sharedPart,sharedPart);
		boolean actual = sut.isDead();
		assertTrue(actual);
		verify(deadPart, atLeastOnce()).getHealth();
	}
	
	@Test 
	void testIfAllive() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new WarriorStub(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		boolean actual = sut.isDead();
		assertFalse(actual);
		verify(sharedPart, atLeastOnce()).getHealth();
	}
	
	
	
	
	@Test 
	void testStrike() {
		Part sharedPart = mock(Part.class);
		Part enemyPart = mock(Part.class);
		when(enemyPart.getHealth()).thenReturn(10);
		
		Warrior sut = new WarriorStub(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		Warrior enemy = new Warrior(enemyPart, enemyPart, enemyPart, enemyPart, enemyPart,enemyPart);
		boolean actual = sut.strike(enemy, 19);
		assertTrue(actual);
		verify(enemyPart, atLeastOnce()).hit(19);
		
	}
    
	//inner stub class 
	class WarriorStub extends Warrior{

		public WarriorStub(Part Head, Part Body, Part RLeg, Part LLeg, Part RArm, Part LArm) {
			super(Head, Body, RLeg, LLeg, RArm, LArm);
		}
		
	}
		//inner class 
	class WarriorStubTrue extends Warrior{
		
		public WarriorStubTrue(Part Head, Part Body, Part RLeg, Part LLeg, Part RArm, Part LArm) {
			super(Head, Body, RLeg, LLeg, RArm, LArm);
		}

		public boolean Strike() {
			return true;
		}
		
		public boolean hit(int a) {
			return true;
		}
	}
	

	//inner class 
	class WarriorStubHit extends Warrior{
		
		public WarriorStubHit(Part Head, Part Body, Part RLeg, Part LLeg, Part RArm, Part LArm) {
			super(Head, Body, RLeg, LLeg, RArm, LArm);
		}
		
	}
	
	
	
	//inner class 
	class PartStub extends Part{

		public PartStub(int h) {
			super(h);
		}
		
		
		public int getHealth() {
			return 10;
		}
	}

}
