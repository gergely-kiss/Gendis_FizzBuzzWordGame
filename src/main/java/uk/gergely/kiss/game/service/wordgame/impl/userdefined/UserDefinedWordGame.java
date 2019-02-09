package uk.gergely.kiss.game.service.wordgame.impl.userdefined;

import uk.gergely.kiss.game.service.WordGame;

public class UserDefinedWordGame implements WordGame {

	private UserDefinedWordGameRules rules;
	/** Constructor to enforce the rule definition of the game
	 * 
	 * @param rules
	 */
	public UserDefinedWordGame(UserDefinedWordGameRules rules) {
		this.rules = rules;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String stringFromInteger(int input) {
		if (input % rules.getConstraing_1() == 0 && input % rules.getConstraing_2() == 0) {
			return rules.getKeywordX() + rules.getKeywordY();
		} else if (input % rules.getConstraing_1() == 0) {
			return rules.getKeywordX();
		} else if (input % rules.getConstraing_2() == 0) {
			return rules.getKeywordY();
		} else {
			return String.valueOf(input);
		}
	}

}
