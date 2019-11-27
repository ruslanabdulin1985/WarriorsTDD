package tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.AtMost;

import model.Fight;
import model.Part;
import model.Warrior;



public class FightTest {
	
	
	@Test
	void whenAttackWariorStrikeIsExecutedOnce() {
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		Fight sut = new Fight(warrior, enemy);
		sut.atack();
		
		verify(warrior).strike(enemy, 5);
	}
	
	@Test
	void whenDeffendEnemyStrikeIsExecutedOnce() {	
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		Fight sut = new Fight(warrior, enemy);
		sut.defend();
		
		verify(enemy).strike(warrior, 5);

	}
	
	@Test
	void whenSetBlockPlayerBlockIsExectuedOnce() {
		Part somePart1 = mock(Part.class);
		Part somePart2 = mock(Part.class);
		
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		Fight sut = new Fight(warrior, enemy);
		sut.setBlockWarrior(somePart1, somePart2);
		
		verify(warrior).block(somePart1, somePart2);

	}
	
	@Test
	void whenSetBlockEnemyBlocIsExecutedOnce() {
		Part somePart1 = mock(Part.class);
		
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		when(enemy.getRandomPart()).thenReturn(somePart1);
		
		Fight sut = new Fight(warrior, enemy);
		sut.setBlockEnemy();

		verify(enemy).block(somePart1, somePart1);
	}
	
	@Test
	void whenPlayerIsDeadThenGameOverReturnsTrue() {
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		when(warrior.isDead()).thenReturn(true);
		
		Fight sut = new Fight(warrior, enemy);
		
		boolean actual = sut.isGameOver();
		
		assertTrue(actual);
	}
	
	
	@Test
	void whenEnemyIsDeadThenIsGameOverReturnTrue() {
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		when(enemy.isDead()).thenReturn(true);
		
		Fight sut = new Fight(warrior, enemy);
		
		boolean actual = sut.isGameOver();
		
		assertTrue(actual);
	}
	
	@Test
	void whenEnemyIsAliveAndPlayerIsAlliveThenIsGameOverReturnFalse() {
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		when(enemy.isDead()).thenReturn(false);
		when(warrior.isDead()).thenReturn(false);
		
		Fight sut = new Fight(warrior, enemy);
		
		boolean actual = sut.isGameOver();
		
		assertFalse(actual);
	}
	
	@Test
	void whenPlayerIsDeadThenIsPlayerWinReturnsFalse() {
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		when(warrior.isDead()).thenReturn(true);
		
		Fight sut = new Fight(warrior, enemy);
		
		boolean actual = sut.isPlayerWin();
		
		assertFalse(actual);
	}

	
	@Test
	void whenPlayerIsAlliveAndEnemyIsDeadThenIsPlayerWinReturnsTrue() {
		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		
		when(warrior.isDead()).thenReturn(false);
		when(enemy.isDead()).thenReturn(true);
		
		Fight sut = new Fight(warrior, enemy);
		
		boolean actual = sut.isPlayerWin();
		
		assertTrue(actual);
	}
}
