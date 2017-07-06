/**
 * Comparator contains a compare method that compares the keys
 * @author Patrick
 *
 * @param <K>
 */
public class Comparator<K> 
{
	private static final int WHITE = 1;
	private static final int BLACK = 2;
	private static final int GRAY =3;
	
	public Comparator()
	{
		
	}

	/**
	 * The parameter must be a GoatKey
	 * If a has higher priority than b return 1
	 * if b has higher priority than a return -1
	 * if and and b are equal return 0
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int Compare1(K a, K b) throws IllegalArgumentException
	{
		if(a instanceof KeyGoat && b instanceof KeyGoat) // key must be an instance of KeyGoat
		{
			int Color = ((KeyGoat) a).getColor(); //gets color the the bridge
			
			if(((KeyGoat) a).hasPaid()) // a has paid the troll toll
			{
				if(((KeyGoat) b).hasPaid()) // a and b have both paid the troll toll
				{
					if(Color == WHITE)
					{
						if(((KeyGoat) a).getWhiteCoins() > ((KeyGoat) b).getWhiteCoins()) // a has more white coins and both have paid
						{
							return -1;
						}
						else if(((KeyGoat) b).getWhiteCoins() > ((KeyGoat) a).getWhiteCoins()) // b as more white coins and both have paid
						{
							return 1;
						}
						else // both have the same coins for the white bridge and have paid
						{
							return 0;
						}
					}
					else if(Color == BLACK)
					{
						if(((KeyGoat) a).getBlackCoins() > ((KeyGoat) b).getBlackCoins()) // a has more black coins and both have paid
						{
							return -1;
						}
						else if(((KeyGoat) b).getBlackCoins() > ((KeyGoat) a).getBlackCoins()) // b as more black coins and both have paid
						{
							return 1;
						}
						else // both have the same coins for the black bridge and have paid
						{
							return 0;
						}
					}
					else // Color of the bridge is gray
					{
						if(((KeyGoat) a).getGrayCoins() > ((KeyGoat) b).getGrayCoins()) // a has more gray coins and both have paid
						{
							return -1;
						}
						else if(((KeyGoat) b).getGrayCoins() > ((KeyGoat) a).getGrayCoins()) // b as more gray coins and both have paid
						{
							return 1;
						}
						else // both have the same coins for the gray bridge and have paid
						{
							return 0;
						}
					}
						
				}
				else // a has paid the troll toll but b has not
				{
					return 1;
				}
			}
			else if( ((KeyGoat) b).hasPaid()) // b has paid the troll toll but a has not
			{
				return -1;
			}
			else // neither have paid the troll toll
			{
				if(Color == WHITE)
				{
					if(((KeyGoat) a).getWhiteCoins() > ((KeyGoat) b).getWhiteCoins()) // a has more white coins
					{
						return 1;
					}
					else if(((KeyGoat) b).getWhiteCoins() > ((KeyGoat) a).getWhiteCoins()) // b as more white coins
					{
						return -1;
					}
					else // both have the same coins for the white bridge
					{
						return 0;
					}
				}
				else if(Color == BLACK)
				{
					if(((KeyGoat) a).getBlackCoins() > ((KeyGoat) b).getBlackCoins()) // a has more black coins
					{
						return 1;
					}
					else if(((KeyGoat) b).getBlackCoins() > ((KeyGoat) a).getBlackCoins()) // b as more black coins
					{
						return -1;
					}
					else // both have the same coins for the black bridge 
					{
						return 0;
					}
				}
				else // Color of the bridge is gray
				{
					if(((KeyGoat) a).getGrayCoins() > ((KeyGoat) b).getGrayCoins()) // a has more gray coins
					{
						return 1;
					}
					else if(((KeyGoat) b).getGrayCoins() > ((KeyGoat) a).getGrayCoins()) // b as more gray coins
					{
						return -1;
					}
					else // both have the same coins for the gray bridge
					{
						return 0;
					}
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("The key must be an instance of KeyGoat for this comparator");
		}
	}
}
		
		
