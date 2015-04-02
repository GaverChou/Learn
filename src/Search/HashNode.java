package Search;

public class HashNode<K,V> {
	int count;
	HashNode<K,V> next;
	V value;
	K key;
	
	public HashNode() {
		super();
	}
	public HashNode(K key,V value) {
		super();
		this.key = key;
		this.value = value;
		count = 0;
	}
}
