package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Part;
import model.Warrior;

import static org.mockito.Mockito.*;

class warriorTest {
   
	@Test
	void whenGetPartRightHandThanReturnRightHand() {
		Part sharedPart = mock(Part.class);
		Part sharedPartTarget = mock(Part.class);
	
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPartTarget,sharedPart );
		
		Part actual = sut.getPartRArm();
		Part expected = sharedPartTarget;
		assertEquals(expected, actual);
	}
	
	@Test
	void whenGetPartLeftHandThanReturnLeftHand() {
		Part sharedPart = mock(Part.class);
		Part sharedPartTarget = mock(Part.class);
	
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart, sharedPartTarget );
		
		Part actual = sut.getPartLArm();
		Part expected = sharedPartTarget;
		assertEquals(expected, actual);
	}
	
	@Test
	void whenGetPartLeftLegThanReturnLeftLeg() {
		Part sharedPart = mock(Part.class);
		Part sharedPartTarget = mock(Part.class);
	
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPartTarget, sharedPart, sharedPart );
		
		Part actual = sut.getPartLLeg();
		Part expected = sharedPartTarget;
		assertEquals(expected, actual);
	}
	
	@Test
	void whenGetPartRightLegThanReturnRightLeg() {
		Part sharedPart = mock(Part.class);
		Part sharedPartTarget = mock(Part.class);
	
		Warrior sut = new Warrior(sharedPart, sharedPart,sharedPartTarget, sharedPart,  sharedPart, sharedPart );
		
		Part actual = sut.getPartRLeg();
		Part expected = sharedPartTarget;
		assertEquals(expected, actual);
	}
	
	@Test
	void whenGetPartBodyThanReturnBody() {
		Part sharedPart = mock(Part.class);
		Part sharedPartTarget = mock(Part.class);
	
		Warrior sut = new Warrior(sharedPart,sharedPartTarget, sharedPart,  sharedPart,  sharedPart, sharedPart );
		
		Part actual = sut.getPartBody();
		Part expected = sharedPartTarget;
		assertEquals(expected, actual);
	}
	
	@Test
	void whenGetPartHeadThanReturnHead() {
		Part sharedPart = mock(Part.class);
		Part sharedPartTarget = mock(Part.class);
	
		Warrior sut = new Warrior(sharedPart,sharedPartTarget, sharedPart,  sharedPart,  sharedPart, sharedPart );
		
		Part actual = sut.getPartHead();
		Part expected = sharedPartTarget;
		assertEquals(expected, actual);
	}
	
    
	@Test
	void whenGetRightHandThanReturn10() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		
		int actual = sut.getRightArm();
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	@Test
	void whenGetLeftHandThanReturn10() {

		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );

		int actual = sut.getleftArm();
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	
	@Test
	void whenGetRightLegThanReturn10() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getRightArm();
		int expected = 10;
		assertEquals(expected, actual);

	}
	
	@Test
	void whenGetLeftLegThanReturn10() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getleftLeg();
		int expected = 10;
		assertEquals(expected, actual);

	}
	
	@Test
	void whenGetHeadThenReturns10() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getHead();
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	@Test
	void whenGetBodyThenReturns10() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		int actual = sut.getBody();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	void whenBlockedSetBlockIsRun() {
		Part sharedPart1 = mock(Part.class);
		Part sharedPart2 = mock(Part.class);
		
		Warrior sut = new Warrior(sharedPart1, sharedPart2, sharedPart1, sharedPart2, sharedPart1,sharedPart2 );
		sut.block(sharedPart1, sharedPart2);
		sut.hit(10);
		
		verify(sharedPart1).setBlock();
	}
	
	@Test
	void whenHitAllBlocksCanceled() {
		Part sharedPart = mock(Part.class);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart );
		sut.block(sharedPart, sharedPart);
		sut.hit(10);
		
		verify(sharedPart, atLeast(6)).cancelBlock();
	}
	
	
	@Test
	void whenHitThenReturnTrue() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		boolean actual = sut.hit(20);
		assertTrue(actual);
	}
	
	@Test 
	void whenHitThanHeadIsHit() {
		
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(3);	
		Warrior sut = new Warrior(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);

		sut.hit(7);
		int expected = 3;
		int actual = sut.getHead();
		assertEquals(expected, actual);
	}
	
	@Test 
	void whenIsDeadThenReturnsTrue() {
		Part sharedPart = mock(Part.class);
		Part deadPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		when(deadPart.getHealth()).thenReturn(0);
		
		Warrior sut = new WarriorStub(sharedPart, deadPart, sharedPart, sharedPart, sharedPart,sharedPart);
		boolean actual = sut.isDead();
		assertTrue(actual);
	}
	
	@Test 
	void whenAlliveThenReturnsFalse() {
		Part sharedPart = mock(Part.class);
		when(sharedPart.getHealth()).thenReturn(10);
		
		Warrior sut = new WarriorStub(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		boolean actual = sut.isDead();
		assertFalse(actual);
	}
	
	@Test 
	void whenStrikeThanHit() {
		Part sharedPart = mock(Part.class);
		Part enemyPart = mock(Part.class);
		when(enemyPart.getHealth()).thenReturn(10);
		
		Warrior sut = new WarriorStub(sharedPart, sharedPart, sharedPart, sharedPart, sharedPart,sharedPart);
		Warrior enemy = new Warrior(enemyPart, enemyPart, enemyPart, enemyPart, enemyPart,enemyPart);
		boolean actual = sut.strike(enemy, 19);
		assertTrue(actual);
		verify(enemyPart).hit(19);
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
