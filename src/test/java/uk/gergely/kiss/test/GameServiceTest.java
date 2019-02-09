package uk.gergely.kiss.test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import uk.gergely.kiss.game.GameConstants;
import uk.gergely.kiss.game.service.WordGame;
import uk.gergely.kiss.game.service.wordgame.impl.FizzBuzzWordGameImpl;
import uk.gergely.kiss.game.service.wordgame.impl.FozzBozzWordGameImpl;
import uk.gergely.kiss.game.service.wordgame.impl.IntegerStringRepresenter;
import uk.gergely.kiss.game.service.wordgame.impl.userdefined.UserDefinedWordGame;
import uk.gergely.kiss.game.service.wordgame.impl.userdefined.UserDefinedWordGameRules;
import uk.gergely.kiss.utils.GameRuleValidator;

public class GameServiceTest {
	public static final int EXAMPLE_TEST_INPUT_14 = 14;

	public static final int EXAMPLE_TEST_INPUT_15 = 15;
	public static final int EXAMPLE_TEST_INPUT_3 = 3;
	public static final int EXAMPLE_TEST_INPUT_5 = 5;
	public static final int EXAMPLE_TEST_INPUT_0 = 0;
	public static final int EXAMPLE_TEST_INPUT_122 = 122;
	public static final int EXAMPLE_TEST_INPUT_13 = 13;

	public static final String EXAMPLE_TEST_OUTPUT_14 = "14";
	public static final String EXAMPLE_TEST_OUTPUT_15 = "15";
	public static final String EXAMPLE_TEST_OUTPUT_3 = "3";
	public static final String EXAMPLE_TEST_OUTPUT_5 = "5";
	public static final String EXAMPLE_TEST_OUTPUT_0 = "0";
	public static final String EXAMPLE_TEST_OUTPUT_122 = "122";
	public static final String EXAMPLE_TEST_OUTPUT_MINUS_15 = "-15";
	public static final String EXAMPLE_TEST_OUTPUT_MINUS_3 = "-3";
	public static final String EXAMPLE_TEST_OUTPUT_MINUS_5 = "-5";
	public static final String EXAMPLE_TEST_OUTPUT_MINUS_122 = "-122";
	public static final String EXAMPLE_TEST_OUTPUT_13 = "13";

	public static final int TEST_CONSTRAIN_0 = 0;
	public static final int TEST_CONSTRAIN_1 = 5;
	public static final String TEST_KEYWORD_X = "five!";
	public static final int TEST_CONSTRAIN_2 = 2;
	public static final String TEST_KEYWORD_Y = "Two?";
	
	WordGame wg;

	@Test
	public void integersStringRepresentationTest() {
		wg = new IntegerStringRepresenter();
		Assert.assertNotNull(wg.stringFromInteger(EXAMPLE_TEST_INPUT_14));
		Assert.assertNotSame(EXAMPLE_TEST_INPUT_14, wg.stringFromInteger(EXAMPLE_TEST_INPUT_14));
		Assert.assertEquals(EXAMPLE_TEST_OUTPUT_14, wg.stringFromInteger(EXAMPLE_TEST_INPUT_14));
		Assert.assertEquals(EXAMPLE_TEST_OUTPUT_0, wg.stringFromInteger(EXAMPLE_TEST_INPUT_0));
		Assert.assertEquals(EXAMPLE_TEST_OUTPUT_122, wg.stringFromInteger(EXAMPLE_TEST_INPUT_122));
		Assert.assertEquals(EXAMPLE_TEST_OUTPUT_5, wg.stringFromInteger(EXAMPLE_TEST_INPUT_5));
	}

	@Test
	public void FizzBuzzTest() {
		wg = new FizzBuzzWordGameImpl();
		Assert.assertNotNull(wg.stringFromInteger(EXAMPLE_TEST_INPUT_14));
		Assert.assertNotSame(EXAMPLE_TEST_INPUT_14, wg.stringFromInteger(EXAMPLE_TEST_INPUT_14));
		Assert.assertEquals(GameConstants.FIZZ_BUZZ, wg.stringFromInteger(EXAMPLE_TEST_INPUT_15));
		Assert.assertEquals(GameConstants.FIZZ, wg.stringFromInteger(EXAMPLE_TEST_INPUT_3));
		Assert.assertEquals(GameConstants.BUZZ, wg.stringFromInteger(EXAMPLE_TEST_INPUT_5));
		Assert.assertEquals(GameConstants.FIZZ_BUZZ, wg.stringFromInteger(EXAMPLE_TEST_INPUT_0));
		// negative numbers test
		Assert.assertEquals(EXAMPLE_TEST_OUTPUT_122, wg.stringFromInteger(EXAMPLE_TEST_INPUT_122));
		Assert.assertEquals(GameConstants.FIZZ_BUZZ, wg.stringFromInteger(-EXAMPLE_TEST_INPUT_15));
		Assert.assertEquals(GameConstants.FIZZ, wg.stringFromInteger(-EXAMPLE_TEST_INPUT_3));
		Assert.assertEquals(GameConstants.BUZZ, wg.stringFromInteger(-EXAMPLE_TEST_INPUT_5));
		Assert.assertEquals(EXAMPLE_TEST_OUTPUT_MINUS_122, wg.stringFromInteger(-EXAMPLE_TEST_INPUT_122));
	}

	@Test
	public void FozzBozzTest() {
		wg = new FozzBozzWordGameImpl();
		Assert.assertNotNull(wg.stringFromInteger(EXAMPLE_TEST_INPUT_14));
		Assert.assertNotSame(EXAMPLE_TEST_INPUT_14, wg.stringFromInteger(EXAMPLE_TEST_INPUT_14));
		Assert.assertEquals(GameConstants.FOZZ, wg.stringFromInteger(EXAMPLE_TEST_INPUT_15));
		Assert.assertEquals(GameConstants.BOZZ, wg.stringFromInteger(EXAMPLE_TEST_INPUT_0));
		Assert.assertEquals(GameConstants.BOZZ, wg.stringFromInteger(EXAMPLE_TEST_INPUT_122));
		// negative numbers test
		Assert.assertEquals(GameConstants.FOZZ, wg.stringFromInteger(-EXAMPLE_TEST_INPUT_15));
		Assert.assertEquals(GameConstants.FOZZ, wg.stringFromInteger(-EXAMPLE_TEST_INPUT_3));
		Assert.assertEquals(GameConstants.FOZZ, wg.stringFromInteger(-EXAMPLE_TEST_INPUT_5));
		Assert.assertEquals(GameConstants.BOZZ, wg.stringFromInteger(-EXAMPLE_TEST_INPUT_122));
	}

	@Test
	public void GameRulesValidatorTest() {
		try {
			GameRuleValidator.validate(
					new UserDefinedWordGameRules(TEST_CONSTRAIN_0, TEST_KEYWORD_X, TEST_CONSTRAIN_2, TEST_KEYWORD_Y));
			fail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UserDefinedWordGameTest() {
		UserDefinedWordGameRules rules = null;
		try {
			rules = new UserDefinedWordGameRules(TEST_CONSTRAIN_1, TEST_KEYWORD_X, TEST_CONSTRAIN_2, TEST_KEYWORD_Y);
		} catch (Exception e) {
			e.printStackTrace();
		}
		wg = new UserDefinedWordGame(rules);
		Assert.assertNotNull(wg.stringFromInteger(EXAMPLE_TEST_INPUT_14));
		Assert.assertEquals(TEST_KEYWORD_X, wg.stringFromInteger(TEST_CONSTRAIN_1));
		Assert.assertEquals(TEST_KEYWORD_Y, wg.stringFromInteger(TEST_CONSTRAIN_2));
		Assert.assertEquals(TEST_KEYWORD_X + TEST_KEYWORD_Y, wg.stringFromInteger(TEST_CONSTRAIN_1 * TEST_CONSTRAIN_2));
		Assert.assertEquals(TEST_KEYWORD_X + TEST_KEYWORD_Y, wg.stringFromInteger(EXAMPLE_TEST_INPUT_0));
		// negative numbers test
		Assert.assertEquals(TEST_KEYWORD_X, wg.stringFromInteger(-TEST_CONSTRAIN_1));
		Assert.assertEquals(TEST_KEYWORD_Y, wg.stringFromInteger(-TEST_CONSTRAIN_2));
		Assert.assertEquals(TEST_KEYWORD_X + TEST_KEYWORD_Y,
				wg.stringFromInteger(-TEST_CONSTRAIN_1 * TEST_CONSTRAIN_2));
		Assert.assertEquals(EXAMPLE_TEST_OUTPUT_13, wg.stringFromInteger(EXAMPLE_TEST_INPUT_13));
	}
}
