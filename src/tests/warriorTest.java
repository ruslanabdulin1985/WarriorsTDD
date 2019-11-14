package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Part;
import model.Warrior;

class warriorTest {
	
	@Test
	void getRightHandTest() {
		Warrior sut = new WarriorStub();
		int actual = sut.getRightArm();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	void getLeftHandTest() {
		Warrior sut = new WarriorStub();
		int actual = sut.getleftArm();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	void getRightLegTest() {
		Warrior sut = new WarriorStub();
		int actual = sut.getRightArm();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	void getLeftLegTest() {
		Warrior sut = new WarriorStub();
		int actual = sut.getleftLeg();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	void getHeadTest() {
		Warrior sut = new WarriorStub();
		int actual = sut.getHead();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	void getBodyTest() {
		Warrior sut = new WarriorStub();
		int actual = sut.getBody();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	
	
	
	@Test
	void testHit() {
		Warrior sut = new WarriorStub();
		boolean actual = sut.hit(20);
		assertTrue(actual);
	}
	
	@Test 
	void testStrike() {
		Warrior sut = new WarriorStub();
		Warrior enemy = new WarriorStub2();
		boolean actual = sut.strike(enemy, 19);
		assertTrue(actual);
	}
	
	//inner class 
		class WarriorStub extends Warrior{

			public WarriorStub() {
				this.rightLeg = new PartStub(10);
				this.leftLeg = new PartStub(10);
				this.leftArm = new PartStub(10);
				this.rightArm = new PartStub(10);
				this.body = new PartStub(10);
				this.head = new PartStub(10);
			}
			
		}
		
		//inner class 
		class WarriorStub2 extends Warrior{
			
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
