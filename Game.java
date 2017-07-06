/**
 * Creates and simulates the game.
 * Main method is in this class
 * @author Patrick
 *
 */

public class Game 
{
	// There must be 3 bridges of each color because each bridge lets one goat of each color pass
	// There are three trolls, one for each bridge
	private static Comparator<KeyGoat> c = new Comparator<KeyGoat>();
	
	private static HeapAdaptablePriorityQueueBridge<KeyGoat,Goat> WhiteBridge = new HeapAdaptablePriorityQueueBridge<KeyGoat,Goat>(c, 1);
	private static HeapAdaptablePriorityQueueBridge<KeyGoat,Goat> BlackBridge = new HeapAdaptablePriorityQueueBridge<KeyGoat,Goat>(c, 2);
	private static HeapAdaptablePriorityQueueBridge<KeyGoat,Goat> GrayBridge = new HeapAdaptablePriorityQueueBridge<KeyGoat,Goat>(c, 3);
	
	private static Troll WT = new Troll(1);
	private static Troll BT = new Troll(2); 
	private static Troll GT = new Troll(3);
	
	//these represent the colors
	private static final int WHITE = 1;
	private static final int BLACK = 2;
	private static final int GRAY = 3;
	/**
	 *  White --> Black --> Gray
	 *  Simulates the game
	 */
	public static void run()
	{
		int time = 1;
		Goat white = new Goat(1); //create a new goat of every color
		Goat black = new Goat(2);
		Goat gray = new Goat(3);
		white.TrollToll(WT); // white and black goats both pay the trolls
		black.TrollToll(BT);
		KeyGoat kw = new KeyGoat(white,1); // creates keys for each goat
		KeyGoat kb = new KeyGoat(black,2);
		KeyGoat kg = new KeyGoat(gray,3);
		WhiteBridge.Insert(kw, white); // starts off with each color goat in its own bridge
		BlackBridge.Insert(kb, black);
		GrayBridge.Insert(kg, gray);
		
		int numWhite = 0; // number of white goats alive
		int numBlack = 0; // number of black goats alive
		int numGray = 0; // number of gray goats alive		
		while(time <= 10000)
		{
			
			Goat PlaceHolderWB = WhiteBridge.removeMin().getValue(); // removes the min of each bridge
			Goat PlaceHolderBB = BlackBridge.removeMin().getValue();
			Goat PlaceHolderGB = GrayBridge.removeMin().getValue();
			PlaceHolderWB.setPaid(false); // when entering a new bridge the goats are assumed to not have paid yet
			PlaceHolderBB.setPaid(false);
			PlaceHolderGB.setPaid(false);
			
				
				if(PlaceHolderWB.getColor() == BLACK) // if the goat is black and the next bridge it enters is black
				{
					Goat newBlack = new Goat(BLACK); // create new goat
					newBlack.TrollToll(BT);
					KeyGoat blackKey = new KeyGoat(newBlack,BLACK); // creates new goat and inserts it into the bridge
					BlackBridge.Insert(blackKey, newBlack);
					PlaceHolderWB.Increment();
					if(PlaceHolderWB.getBlackCoins() > 20) // if the goat can pay the troll it will
					{
						PlaceHolderWB.TrollToll(BT);
					}
					
					KeyGoat blackbridge = new KeyGoat(PlaceHolderWB,BLACK); // creates new key for the goat
					BlackBridge.Insert(blackbridge, PlaceHolderWB); // insert goat from white bridge into black bridge
				}
				else // goat being inserted and new bridge are different colors
				{
					KeyGoat blackbridge = new KeyGoat(PlaceHolderWB,BLACK); // creates new key for the goat
					BlackBridge.Insert(blackbridge, PlaceHolderWB); // insert goat from white bridge into black bridge
				}


					if(PlaceHolderBB.getColor() == GRAY) // if goat from black bridge is gray meaning the next bridge the goat reaches is also gray
					{
						Goat newGray = new Goat(GRAY); // creates new goat to enter the bridge
						KeyGoat graykey = new KeyGoat(newGray,GRAY); // creates new goat and inserts it into the bridge
						GrayBridge.Insert(graykey, newGray);
						PlaceHolderBB.Increment();
						KeyGoat graybridge = new KeyGoat(PlaceHolderBB,GRAY); // creates new key for the goat
						GrayBridge.Insert(graybridge, PlaceHolderBB); // insert goat from black bridge into GrayBirdge
					}
					else // goat and bridge are two different colors
					{
						KeyGoat graybridge = new KeyGoat(PlaceHolderBB,GRAY); // creates new key for the goat
						GrayBridge.Insert(graybridge, PlaceHolderBB); // insert goat from black bridge into GrayBirdge
					}
				
				if(PlaceHolderGB.getColor() == WHITE) // if goat from gray bridge is white meaning the next bridge it enters is white
				{
					Goat newWhite = new Goat(WHITE); // creates new goat
					newWhite.TrollToll(WT); // new goat pays the troll toll
					KeyGoat whiteKey = new KeyGoat(newWhite,WHITE); // creates new goat and inserts it into the bridge
					WhiteBridge.Insert(whiteKey, newWhite);
					PlaceHolderGB.Increment();
					if(PlaceHolderGB.getWhiteCoins() > 20)// if the goat can pay the troll it will
					{
						PlaceHolderGB.TrollToll(WT); //pays troll toll
					}
					
					KeyGoat whitebridge = new KeyGoat(PlaceHolderGB,WHITE); // creates new key for the goat
					WhiteBridge.Insert(whitebridge, PlaceHolderGB); // insert goat from gray bridge into the WhiteBridge
				}
				else // goat and bridge are different colors
				{
					KeyGoat whitebridge = new KeyGoat(PlaceHolderGB,WHITE); // creates new key for the goat
					WhiteBridge.Insert(whitebridge, PlaceHolderGB); // insert goat from gray bridge into the WhiteBridge
				}

			numWhite = WhiteBridge.getWhite() + BlackBridge.getWhite() + GrayBridge.getWhite(); // gets the total count of each color goat alive
			numBlack = WhiteBridge.getBlack() + BlackBridge.getBlack() + GrayBridge.getBlack();
			numGray = WhiteBridge.getGray() + BlackBridge.getGray() + GrayBridge.getGray();
			System.out.println(numWhite + " " + numBlack + " " + numGray + " " + WT.getCoins() + " " + BT.getCoins() + " " + GT.getCoins() + " " + time);
			// line above represents the output at every time unit
			time++;
		}
	}
	
	
	public static void main(String[] args) 
	{
		run();
	}
}
