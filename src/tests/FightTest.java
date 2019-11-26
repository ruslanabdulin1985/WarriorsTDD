package tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.sound.sampled.AudioFileFormat.Type;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.AtMost;

import model.Fight;
import model.Part;
import model.Warrior;



public class FightTest {
	
	
	@Test
	void attackTest() {
		Part sharedPart = mock(Part.class);
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		Fight sut = new Fight(warrior, enemy);
		sut.atack();
		
		verify(warrior, atLeast(1)).strike(enemy, 5);
		verify(warrior, atMost(1)).strike(enemy, 5);
	}
	
	@Test
	void deffendTest() {	
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		Fight sut = new Fight(warrior, enemy);
		sut.defend();
		
		verify(enemy, atLeast(1)).strike(warrior, 5);
		verify(enemy, atMost(1)).strike(warrior, 5);
	}
	
	@Test
	void setBlockTestPlayer() {
		Part somePart1 = mock(Part.class);
		Part somePart2 = mock(Part.class);
		
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		Fight sut = new Fight(warrior, enemy);
		sut.setBlockWarrior(somePart1, somePart2);
		
		verify(warrior, atLeast(1)).block(somePart1, somePart2);
		verify(warrior, atMost(1)).block(somePart1, somePart2);
	
//		sut.setBlockEnemy();
//
//		verify(enemy, atLeast(1)).block(somePart1, somePart2);
//		verify(enemy, atMost(1)).block(somePart1, somePart2);
	}
	
	@Test
	void setBlockTestEnemy() {
		Part somePart1 = mock(Part.class);
		Part somePart2 = mock(Part.class);
		
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		when(enemy.getRandomPart()).thenReturn(somePart1);
		
		Fight sut = new Fight(warrior, enemy);
		sut.setBlockEnemy();

		verify(enemy, atLeast(1)).block(somePart1, somePart1);
		verify(enemy, atMost(1)).block(somePart1, somePart1);
	
	}
}
