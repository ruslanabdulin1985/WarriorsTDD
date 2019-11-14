package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Part;

class partTest {

	@Test
	void testGetHealth() {
	Part p = new Part(20);
	int expected = 20;
	int actual = p.getHealth();
	
	assertEquals(expected, actual);
	}
	
	@Test
	void testPartConstructor() {
		Part p = new Part(10);
		int expected = 10;
		int actual = p.getHealth();
		
		assertEquals(expected, actual);
	}
		
	@Test
	void testHit() {
		Part p = new Part(20);
		p.hit(12);
		int expected = 8;
		int actual = p.getHealth();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testHitOverkill() {
		Part p = new Part(20);
		p.hit(22);
		int expected = 0;
		int actual = p.getHealth();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testBlocked() {
		Part p = new Part(20);
		p.hit(10);
		int expected = 20;
		int actual = p.getHealth();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testBlockCanceled() {
		Part p = new Part(20);
		p.hit(10);
		p.hit(10);
		int expected = 10;
		int actual = p.getHealth();
		
		assertEquals(expected, actual);
	}
	
	

}