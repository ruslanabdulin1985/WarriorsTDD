package tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.AtMost;

import model.Fight;
import model.Part;
import model.Warrior;
import model.partsNames;



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
		when(warrior.getPartBody()).thenReturn(somePart1);
		when(warrior.getPartHead()).thenReturn(somePart2);
		
		Fight sut = new Fight(warrior, enemy);
		sut.setBlockWarrior(partsNames.body, partsNames.head);
		
		verify(warrior).block(somePart1, somePart2);

	}

	@Test
	void whenSetBlockArmsPlayerBlockIsExectuedOnce() {
		Part somePart1 = mock(Part.class);
		Part somePart2 = mock(Part.class);

		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		when(warrior.getPartLArm()).thenReturn(somePart1);
		when(warrior.getPartRArm()).thenReturn(somePart2);

		Fight sut = new Fight(warrior, enemy);
		sut.setBlockWarrior(partsNames.LeftArm, partsNames.RightArm);

		verify(warrior).block(somePart1, somePart2);

	}

	@Test
	void whenSetBlockLegsPlayerBlockIsExectuedOnce() {
		Part somePart1 = mock(Part.class);
		Part somePart2 = mock(Part.class);

		Warrior enemy = mock(Warrior.class);
		Warrior warrior = mock(Warrior.class);
		when(warrior.getPartLLeg()).thenReturn(somePart1);
		when(warrior.getPartRLeg()).thenReturn(somePart2);

		Fight sut = new Fight(warrior, enemy);
		sut.setBlockWarrior(partsNames.LeftLeg, partsNames.RightLeg);

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
