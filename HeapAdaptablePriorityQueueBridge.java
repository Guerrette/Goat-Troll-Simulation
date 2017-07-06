import java.util.Iterator;

/**
 * Taken directly from the book with a few changes to the removemin and insert methods
 * @author Patrick Guerrette
 *
 * @param <K>
 * @param <V>
 */
public class HeapAdaptablePriorityQueueBridge<K,V> extends HeapPriorityQueue<K,V>
{
	protected static class AdaptablePQEntryB<K,V> extends PQEntry<K,V>
	{
		private int index;
		public AdaptablePQEntryB(K key, V value, int j) 
		{
			super(key, value);
			index = j;
		}
		public int getIndex()
		{
			return index;
		}
		public void setIndex(int j)
		{
			index = j;
		}
		
	} /////////////////////End of nested  AdaptablePQEntry//////////////////////////////////////
	
	int numWhite = 0; // represents the number of each color goat currently in the bridge
	int numBlack = 0;
	int numGray = 0;
	private final int Color;
	private static final int WHITE = 1;
	private static final int BLACK = 2;
	private static final int GRAY = 3;
	public HeapAdaptablePriorityQueueBridge(Comparator<K> c, int color) 
	{
		super(c, color);
		Color = color;
		
	}
	/**
	 * Validates entry to make sure its location aware
	 * @param entry
	 * @return
	 * @throws IllegalArgumentException
	 */
	protected AdaptablePQEntryB<K,V> validate(Entry<K,V> entry) throws IllegalArgumentException
	{
		if(!(entry instanceof AdaptablePQEntryB<?,?>))
		{
			throw new IllegalArgumentException("Invalid Entry 1");
		}
		AdaptablePQEntryB<K,V> locator = (AdaptablePQEntryB<K,V>) entry;
		int j = locator.getIndex();
		if(j>=heap.size() || heap.get(j) != locator)
		{
			throw new IllegalArgumentException("Invalid Entry 2");
		}
		return locator;
	}
	
	protected void swap(int i, int j)
	{
		super.swap(i, j); //perform swap
		((AdaptablePQEntryB<K,V>) heap.get(i)).setIndex(j); //set index
		((AdaptablePQEntryB<K,V>) heap.get(j)).setIndex(i);
	}
	
	protected void bubble(int j)
	{
		if(j< 0 && Compare(heap.get(j),heap.get(Parent(j)), Color) < 0)
		{
			upHeap(j);
		}
		else
		{
			downHeap(j);
		}
	}
	
	/**
	 * inserts an entry into the bridge then decrements each goat and keeps track of each color goat in the bridge
	 */
	
	@Override
	public Entry<K,V> Insert(K key, V value) throws IllegalArgumentException
	{
		if(((Goat) value).getColor() == WHITE) // if the goat is white add 1
		{
			numWhite++;
		}
		else if(((Goat) value).getColor() == BLACK) // if the goat is black add 1
		{
			numBlack++;
		}
		else if(((Goat)value).getColor() == GRAY) // if the goat is gray add 1
		{
			numGray++;
		}
		else // inserting null
		{
			// do nothing
		}
		
		Iterator<Entry<K,V>> iter = heap.iterator(); // creates an iterator to iterate through the heap
		while(iter.hasNext()) // while there is a next position in the heap
		{
			Entry<K,V> entry = iter.next(); 
			Goat g = (Goat) entry.getValue();
			g.decrement();// decrease because 1 time unit goes by each insertion
				
				if(g.getWhiteCoins() <= 0) // if the goat runs out of white coins
				{
					iter.remove();//remove(entry);
					if(g.getColor() == WHITE) // if goat being removed is white
					{
						numWhite--;
					}
					else if(g.getColor() == BLACK) // if goat being removed is black
					{
						numBlack--;
					}
					else // if goat being removed is gray
					{
						numGray--;
					}
				}
				else if(g.getBlackCoins() <= 0) // if the goat runs out of black coins
				{
					iter.remove();//remove(entry);
					if(g.getColor() == WHITE) // if goat being removed is white
					{
						numWhite--;
					}
					else if(g.getColor() == BLACK) // if goat being removed is black
					{
						numBlack--;
					}
					else // if goat being removed is gray
					{
						numGray--;
					}

				}
				else if(g.getGrayCoins() <= 0) // if the goat runs out of gray coins
				{
					iter.remove();//remove(entry);
					if(g.getColor() == WHITE) // if goat being removed is white
					{
						numWhite--;
					}
					else if(g.getColor() == BLACK) // if goat being removed is black
					{
						numBlack--;
					}
					else // if goat being removed is gray
					{
						numGray--;
					}

				}
				else // if goat was not removed, create new key for it
				{
					KeyGoat newKey = new KeyGoat(g,Color); // creates a new key after the goat is decremented or removed
					replaceKey(entry, (K) newKey);
				}
				
			}
		

		
		
		Entry<K,V> newest = new AdaptablePQEntryB<>(key,value,heap.size());
		heap.add(newest);
		upHeap(heap.size()-1);
		return newest;
	}
	
	/**
	 * every time this method is called it is assumed that one time unit has passed for this bridge which means
	 * all the goats in this bridge will have its coins decremented by 1;
	 */
	@Override
	public Entry<K,V> removeMin()
	{
		Entry<K,V> entry = super.removeMin();
		int Color = ((Goat) entry.getValue()).getColor();
		
		if(Color == WHITE)// if color of goat being removed is white
		{
			numWhite--;
		}
		else if(Color == GRAY)// if color of goat being removed is gray
		{
			numGray--;
		}
		else if(Color == BLACK) // if color of goat being removed is black
		{
			numBlack--;
		}
		else // occurs if bridge is empty
		{
			//do nothing
		}
		return entry;
				
		
	}
	/**
	 * used to remove a dead goat from the heap
	 * @param entry
	 * @throws IllegalArgumentException
	 */
	public void remove(Entry<K,V> entry) throws IllegalArgumentException
	{
		AdaptablePQEntryB<K,V> locator = (AdaptablePQEntryB<K, V>) entry;
		int j = locator.getIndex();
		if(j == heap.size()-1)
		{
			heap.remove(heap.size()-1);
		}
		else
		{
			swap(j,heap.size()-1);
			bubble(j);
		}
	}
	/**
	 * used to update the key whenever the coins get decremented
	 * @param entry
	 * @param key
	 */
	public void replaceKey(Entry<K,V> entry, K key)
	{
		AdaptablePQEntryB<K,V> locator = (AdaptablePQEntryB<K, V>) entry;
		locator.setKey(key);
		bubble(locator.getIndex());
	}
	
	public int getWhite()
	{
		return numWhite;
		
	}
	public int getBlack()
	{
		return numBlack;
	}
	public int getGray()
	{
		return numGray;
	}
}
