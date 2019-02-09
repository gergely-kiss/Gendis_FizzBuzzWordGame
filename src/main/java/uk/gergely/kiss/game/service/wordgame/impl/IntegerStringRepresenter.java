package uk.gergely.kiss.game.service.wordgame.impl;

import uk.gergely.kiss.game.service.WordGame;

public class IntegerStringRepresenter implements WordGame {
	/**
	 * {@inheritDoc}
	 */
	public String stringFromInteger(int input) {
		return String.valueOf(input);
	}

}
