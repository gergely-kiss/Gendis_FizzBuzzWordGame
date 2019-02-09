package uk.gergely.kiss.game.service.wordgame.impl;

import uk.gergely.kiss.game.GameConstants;
import uk.gergely.kiss.game.service.WordGame;

/**
 * FizzBuzz implementation of the world game
 * 
 * @author kiss-
 *
 */
public class FizzBuzzWordGameImpl implements WordGame {

	/**
	 * {@inheritDoc}
	 */
	public String stringFromInteger(int input) {
		if (input % 3 == 0 && input % 5 == 0) {
			return GameConstants.FIZZ_BUZZ;
		} else if (input % 3 == 0) {
			return GameConstants.FIZZ;
		} else if (input % 5 == 0) {
			return GameConstants.BUZZ;
		} else {
			return String.valueOf(input);
		}
	}

}
