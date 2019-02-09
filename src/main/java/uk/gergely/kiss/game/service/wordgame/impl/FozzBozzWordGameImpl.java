package uk.gergely.kiss.game.service.wordgame.impl;

import uk.gergely.kiss.game.GameConstants;
import uk.gergely.kiss.game.service.WordGame;

/**
 * FozzBozz implementation of the world game
 * 
 * @author kiss-
 *
 */
public class FozzBozzWordGameImpl implements WordGame {
	/**
	 * {@inheritDoc}
	 */
	public String stringFromInteger(int input) {
		if (input % 2 == 0) {
			return GameConstants.BOZZ;
		} else {
			return GameConstants.FOZZ;
		}
	}
}
