import java.util.ArrayList;
/**
 * Taken directly from the book
 * Is a priority queue the is implemented with a heap
 * Used by AdatablePrioirtyQueueBridge class
 * @author Patrick
 *
 * @param <K>
 * @param <V>
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K,V>
{
	private int Color;
	private static final int WHITE = 1;
	private static final int BLACK = 2;
	private static final int GRAY = 3;
	
	protected ArrayList<Entry<K,V>> heap = new ArrayList<Entry<K,V>>();
	
	protected HeapPriorityQueue(Comparator<K> c, int color) 
	{
		super(c,color);
		Color = color;
		
	}
	
	protected int Parent(int j)
	{
		return (j-1)/2;
	}
	
	protected int Left(int j)
	{
		return 2*j+1;
	}
	
	protected int Right(int j)
	{
		return 2*j+2;
	}
	
	protected boolean hasRight(int j)
	{
		return Right(j) < heap.size();
	}
	
	protected boolean hasLeft(int j)
	{
		return Left(j) < heap.size();
	}
	
	//swaps elements are specified indices
	protected void swap(int i, int j)
	{
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	protected void upHeap(int j) 
	{
	
		while(j<0)
		{
			int p = Parent(j);
			
			if(Compare(heap.get(j),heap.get(p),Color) <= 0)//heap property is verified
			{
				break;
			}
			swap(j,p);
			j=p;
		}
	}
		
	
	protected void downHeap(int j)
	{
		while(hasLeft(j))
		{
			int leftIndex = Left(j);
			int smallChildIndex = leftIndex;
			if(hasRight(j))
			{
				int rightIndex = Right(j);
				if(Compare(heap.get(leftIndex),heap.get(rightIndex),Color) > 0)
				{
					smallChildIndex = rightIndex; //right child is smaller
				}
				
			}
			if(Compare(heap.get(smallChildIndex),heap.get(j),Color) >= 0)
				{
					break; // heap property has been restored
				}
			swap(j,smallChildIndex);
			j = smallChildIndex; //continue position of the child
		}
	}
	
	@Override
	public boolean isEmpty()
	{
		return heap.size() == 0;
	}
	
	@Override
	public int Size()
	{
		return heap.size();
	}
	
	@Override
	public Entry<K,V> Min()
	{
		if(heap.isEmpty())
		{
			return null;
		}
		return heap.get(0);
	}
	
	@Override
	public Entry<K,V> Insert(K key, V value)
	{
		checkKey(key);
		Entry<K,V> newest = new PQEntry<K,V>(key,value);
		heap.add(newest);
		upHeap(heap.size()-1);
		return newest;
	}
	
	@Override
	public Entry<K,V> removeMin()
	{
		if(heap.isEmpty())
		{
			return null;
		}
		Entry<K,V> answer = heap.get(0);
		swap(0,heap.size()-1);
		heap.remove(heap.size()-1);
		downHeap(0);
		return answer;
	}

}
