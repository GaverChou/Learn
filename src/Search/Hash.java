package Search;

import java.util.ArrayList;

public class Hash {
	final static ArrayList<HashNode<Integer,Integer>> hashNodes = new ArrayList<HashNode<Integer,Integer>>(); 

	static int len = 1000;
	static int count = 0;
	public static void main(String[] args) {
		long timeStart = System.currentTimeMillis();
		long timeEnd;
		for (int i = 0; i < len; i++) {
			hashNodes.add(new HashNode<Integer,Integer>());
		};
		for (int i = 0; i < 100000; i++) {
//			timeStart = System.nanoTime();
			Insert(i, i);
//			timeEnd = System.nanoTime();
//			System.out.println("Insert a element need time : "+(timeEnd-timeStart) +"ns");
		}
		timeEnd = System.currentTimeMillis();
		System.out.println("build hash time : "+(timeEnd-timeStart)+"ms");
		timeStart = System.nanoTime();
		int findNUM = 100000-10;
		for (int i = 0; i < 100000; i++) {
			if (i==findNUM) {
				System.out.println(""+i);
				break;
			}
		}
		timeEnd = System.nanoTime();
		System.out.println("linear search coust time : "+(timeEnd-timeStart)/1000+"us");

		timeStart = System.nanoTime();
//		System.out.println(hashNodes.get(7542).next.value);
		HashNode<Integer,Integer> findNode = find(findNUM);
		System.out.println(findNode.value);
		timeEnd = System.nanoTime();
		System.out.println("hash search coust time : "+(timeEnd-timeStart)/1000+"us");
	}

	public static int getHash(int v){
		return v%len;
	}
	
	public static HashNode<Integer,Integer> find(int key){
		int adr = getHash(key);
		HashNode<Integer,Integer> rootNode = hashNodes.get(adr);
		if (rootNode.next==null) {
			return null;
		}else{
			do{
				if(rootNode.key!=null&&rootNode.key == key)  {  
	                return rootNode;  
	            }  else {  
	            	rootNode = rootNode.next;  
	            }  
			}while (rootNode!=null);
		}
		return null;
	}
	
	public static void Insert(int k,int v){
		int adr = getHash(k);
		HashNode<Integer,Integer> node = hashNodes.get(adr);
		if (node.next==null) {
			node.next = new HashNode<Integer, Integer>(k, v);
		}else {
			HashNode<Integer, Integer> temp = new HashNode<Integer, Integer>(k, v);
			temp.next = node.next;
			node.next = temp;
//			Insert(node.next,k,v);
		}
	}
	
	public static void Insert(HashNode<Integer, Integer> node,int k,int v){
		if (node.next==null) {
			node.next = new HashNode<Integer, Integer>(k, v);
		}else {
			Insert(node.next,k,v);
		}
	}
}
