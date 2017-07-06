
public class Troll 
{
	private int Color; // 1 = White
					   // 2 = Black
					   // 3 = Gray
	
	private int Coins; // number of coins the troll currently has
	private static final int WHITE = 1;
	private static final int BLACK = 2;
	private static final int GRAY = 3;
	/**
	 * Creates a new troll of a certain color
	 *  1 = White
	 *  2 = Black
	 * 	3 = Gray
	 * Every Troll starts with 0 coins.
	 * @param color
	 */
	public Troll(int color)
	{
		Color = color;
		Coins = 0;
	}
	
	public int getColor()
	{
		return Color;
	}
	
	/**
	 * This method adds 20 coins to the troll 
	 * This method should only be called after the goat decides to pay the troll
	 * @param goat
	 */
	public void addCoins()
	{
		Coins += 20;
	}
	
	// returns the coins the troll has
	public int getCoins()
	{
		return Coins;
	}
	
}
