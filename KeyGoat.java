/**
 * Creates the key used for each entry
 * @author Patrick
 *
 */
public class KeyGoat 
{
	private int Color; // represents the color of the bridge
	private int WhiteCoins;
	private int BlackCoins;
	private int GrayCoins;
	private boolean hasPaid;
	
	public KeyGoat(Goat g, int color)
	{
		WhiteCoins = g.getWhiteCoins();
		BlackCoins = g.getBlackCoins();
		GrayCoins = g.getGrayCoins();
		hasPaid = g.hasPaid();
		Color = color;
	}
	
	
	// basic getter methods
	// these methods are used by the comparator to compare each key.
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
	
	public boolean hasPaid()
	{
		return hasPaid;
	}
	public int getColor()
	{
		return Color;
	}
	
}
