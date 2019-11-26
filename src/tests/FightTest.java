package tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
		
		verify(enemy, atLeast(1)).hit(10);
		verify(enemy, atMost(1)).hit(10);
	}
	
	void deffendTest() {	
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		Fight sut = new Fight(warrior, enemy);
		sut.defend();
		
		verify(warrior, atLeast(1)).hit(10);
		verify(warrior, atMost(1)).hit(10);
	}
	
	void setBlockTest() {
		Part somePart1 = mock(Part.class);
		Part somePart2 = mock(Part.class);
		
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		Fight sut = new Fight(warrior, enemy);
		sut.setBlockWarrior();
		
		verify(warrior, atLeast(1)).block(somePart1, somePart2);
		verify(warrior, atMost(1)).block(somePart1, somePart2);
	
		sut.setBlockEnemy();

		verify(enemy, atLeast(1)).block(somePart1, somePart2);
		verify(enemy, atMost(1)).block(somePart1, somePart2);
	}
	
}
