/**
 * taken directly from the book
 * Used by HeapPriorityQueue class
 * @author Patrick
 *
 * @param <K>
 * @param <V>
 */
public class AbstractPriorityQueue<K, V> implements PriorityQueue<K,V>
{
	protected static class PQEntry<K,V> implements Entry<K,V>
	{
		private K k;
		private V v;
		
		//constructor
		public PQEntry(K key, V value)
		{
			k = key;
			v = value;
		}

		@Override
		public K getKey() 
		{
			return k;
		}

		@Override
		public V getValue() 
		{
			return v;
		}
		
		protected void setKey(K key)
		{
			k = key;
		}
		
		protected void setValue(V value)
		{
			v = value;
		}
		///////////////////////End of PQEntry Class///////////////////////////////////////////////////
	}
	
	private Comparator<K> comp; // defines order of keys
	private int Color;
	
	//constructor
	protected AbstractPriorityQueue(Comparator<K> c, int color)
	{
		comp = c;
		Color = color;
	}
	
	protected int Compare(Entry<K,V> a, Entry<K,V> b, int color)
	{
		comp.Compare1(a.getKey(), b.getKey());
		return  0; //comp.Compare(a.getKey(),b.getKey(), Color);
	}
	
	protected boolean checkKey(K key) throws IllegalArgumentException
	{
		try
		{
			System.out.println("Using checkKey method in AbsractPriorityQueue. PleaseFix");
			return false; //comp.Compare(key,key, Color) == 0; // see if key can be compared to itself
		}
		
		catch(ClassCastException e)
		{
			throw new IllegalArgumentException("Incompatible Key");
		}
	}
	
	public int getColor()
	{
		return Color;
	}
	
	@Override
	public int Size() 
	{
		System.out.println("Calling from super class. Please Fix");
		return 0;
	}

	@Override
	public boolean isEmpty() 
	{
		System.out.println("Calling from super class. Please Fix");
		return false;
	}

	@Override
	public Entry<K, V> Insert(K key, V value) 
	{
		System.out.println("Calling from super class. Please Fix");
		return null;
	}

	@Override
	public Entry<K, V> Min() 
	{
		System.out.println("Calling from super class. Please Fix");
		return null;
	}

	@Override
	public Entry<K, V> removeMin() 
	{
		System.out.println("Calling from super class. Please Fix");
		return null;
	}
	
	
}
