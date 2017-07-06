
public class Goat 
{
	private int WhiteCoins;
	private int BlackCoins;
	private int GrayCoins;
	private boolean paidTrollToll = false;
	private int Color;    // 1 = White
						  // 2 = Black
						  // 3 = Gray
	
	
	private static final int WHITE = 1;
	private static final int BLACK = 2;
	private static final int GRAY = 3;
	/**
	 * Creates a new goat starting with 100 coins of each color.
	 * The parameter must be an integer between 1 and 3
	 * 1 = White
	 * 2 = Black
	 * 3 = Gray
	 * @param color
	 */
	public Goat(int color)
	{
		WhiteCoins = 100;
		BlackCoins = 100;
		GrayCoins = 100;
		Color = color;

	}
	/**
	 * Subtracts 20 coins from the color specified by the parameter
	 * The color should be the color of the troll
	 * This is a simulation and does not actually give the troll the coins
	 * This method should only be called within the payTrollToll method
	 * @param color
	 */
	public void TrollToll(Troll troll)
	{
		int color = troll.getColor();
		
		if(color == WHITE)
		{
			WhiteCoins -= 20;
			troll.addCoins();
			paidTrollToll = true;
			
		}
		else if(color == BLACK)
		{
			BlackCoins -= 20;
			troll.addCoins();
			paidTrollToll = true;
		}
		else if(color == GRAY)
		{
			GrayCoins -= 20;
			troll.addCoins();
			paidTrollToll = true;
		}
		else
		{
			System.out.println("Wrong Color");
		}
	}
	/**
	 * every time unit coins of each color for every goat is decreased by 1
	 */
	public void decrement()
	{
		WhiteCoins--;
		BlackCoins--;
		GrayCoins--;
	}
	
	public int getColor() // returns the color of the goat
	{
		return Color;
	}
	
	public int getWhiteCoins()
	{
		return WhiteCoins;
	}
	
	public int getBlackCoins()
	{
		return BlackCoins;
	}
	
	public int getGrayCoins()
	{
		return GrayCoins;
	}
	
	// tells whether the goat has paid the troll toll
	public boolean hasPaid()
	{
		return paidTrollToll;
	}
	// Used in the TrollToll method to pay the troll
	public void setPaid(boolean paidToll)
	{
		paidTrollToll = paidToll;
	}
	/**
	 * Any time a goat of a certain color returns to its colors bridge it receives 100 coins of each color
	 */
	public void Increment()
	{
		BlackCoins += 100;
		WhiteCoins += 100;
		GrayCoins += 100;
	}
	
	
}
