package uk.gergely.kiss.utils;

import uk.gergely.kiss.game.service.wordgame.impl.userdefined.UserDefinedWordGameRules;

/**
 *  Validator for the game rules ensuring there is 0 divider in the game.
 * 
 * @author kiss-
 *
 */
public class GameRuleValidator {
	private static final String ERROR_MSG = "Constraint value cannot be 0 ";

	public static void validate(UserDefinedWordGameRules rules) throws Exception {
		if (rules.getConstraing_1() == 0 || rules.getConstraing_2() == 0) {
			throw new Exception(ERROR_MSG);
		}
	}
}
