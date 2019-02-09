package uk.gergely.kiss.game.service.wordgame.impl.userdefined;
/** RUles for defining UserDefinedWordGame
 * 
 * @author kiss-
 *
 */
public class UserDefinedWordGameRules {

	private int constraing_1;
	private int constraing_2;

	private String keywordX;
	private String keywordY;

	public UserDefinedWordGameRules(int constraing_1, String keywordX, int constraing_2, String keywordY)
			throws Exception {

		this.constraing_1 = constraing_1;
		this.keywordX = keywordX;
		this.constraing_2 = constraing_2;
		this.keywordY = keywordY;
	}

	/**
	 * @return the constraing_1
	 */
	public int getConstraing_1() {
		return constraing_1;
	}

	/**
	 * @param constraing_1 the constraing_1 to set
	 */
	public void setConstraing_1(int constraing_1) {
		this.constraing_1 = constraing_1;
	}

	/**
	 * @return the constraing_2
	 */
	public int getConstraing_2() {
		return constraing_2;
	}

	/**
	 * @param constraing_2 the constraing_2 to set
	 */
	public void setConstraing_2(int constraing_2) {
		this.constraing_2 = constraing_2;
	}

	/**
	 * @return the keywordX
	 */
	public String getKeywordX() {
		return keywordX;
	}

	/**
	 * @param keywordX the keywordX to set
	 */
	public void setKeywordX(String keywordX) {
		this.keywordX = keywordX;
	}

	/**
	 * @return the keywordY
	 */
	public String getKeywordY() {
		return keywordY;
	}

	/**
	 * @param keywordY the keywordY to set
	 */
	public void setKeywordY(String keywordY) {
		this.keywordY = keywordY;
	}

}
