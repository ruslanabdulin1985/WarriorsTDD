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
		assertEquals(actual, expected);
		verify(sharedPart, atLeastOnce()).getHealth();
	}
	
	@Test
	void getLeftHandTest() {

		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );

		int actual = sut.getleftArm();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	
	@Test
	void getRightLegTest() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getRightArm();
		int expected = 10;
		assertEquals(actual, expected);
		verify(sharedPart, atLeastOnce()).getHealth();

	}
	
	@Test
	void getLeftLegTest() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getleftLeg();
		int expected = 10;
		assertEquals(actual, expected);
		verify(sharedPart, atLeastOnce()).getHealth();

	}
	
	@Test
	void getHeadTest() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getHead();
		int expected = 10;
		assertEquals(actual, expected);
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
	void testHit() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		boolean actual = sut.hit(20);
		assertTrue(actual);
	}
	
	@Test 
	void testStrike() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		
		Warrior sut = new WarriorStub(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		Warrior enemy = new WarriorStub2(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		boolean actual = sut.strike(enemy, 19);
		assertTrue(actual);

	}
	

	//@Test
//	void  testMock() {
//    Part random = mock(Part.class);
//	}

    
//    Warrior war = new Warrior();	
//		
//	}
    
	//inner stub class 
	class WarriorStub extends Warrior{

		public WarriorStub(Part Head, Part Body, Part RLeg, Part LLeg, Part RArm, Part LArm) {
			super(Head, Body, RLeg, LLeg, RArm, LArm);
		}
		
	}
		//inner class 
	class WarriorStub2 extends Warrior{
		
		public WarriorStub2(Part Head, Part Body, Part RLeg, Part LLeg, Part RArm, Part LArm) {
			super(Head, Body, RLeg, LLeg, RArm, LArm);
		}

		public boolean Strike() {
			return true;
		}
		
		public boolean hit() {
			return true;
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
