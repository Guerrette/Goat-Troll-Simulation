/**
 * Taken directly from the book
 * Example of what every priority queue should contain
 * Used by the PriorityQueue class
 * @author Patrick
 *
 * @param <K>
 * @param <V>
 */
public interface PriorityQueue<K, V> 
{
	int Size();
	boolean isEmpty();
	Entry<K,V> Insert(K key, V value);
	Entry<K,V> Min();
	Entry<K,V> removeMin();
}
