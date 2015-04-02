/**
 * @author GaverChou E-mail:1123666456@qq.com
 * @version Create on 2015-3-25 ����9:31:01
 * @description 
 */
package tree;

public class BinaryTree<K, V> {
	BinaryTree<K, V> left = null;
	BinaryTree<K, V> right = null;
	private V value;
	private K key;

	public BinaryTree(V value, K key) {
		super();
		this.value = value;
		this.key = key;
	}

	public static <K, V> int getNodeNum(BinaryTree<K, V> node) {
		if (node == null) {
			return 0;
		}
		return getNodeNum(node.left) + getNodeNum(node.right) + 1;
	}

	public static <K, V> int getNodeDeep(BinaryTree<K, V> node) {
		if (node == null) {
			return 0;
		}
		int left = getNodeDeep(node.left) + 1;
		int right = getNodeDeep(node.right) + 1;
		return right>left?right:left;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String str = this.value + "\t";
		String left = this.left == null ? "" : this.left.toString() + "\t";
		String right = this.right == null ? "" : this.right.toString();
		return str + left + right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree<String, Integer> bNode = new BinaryTree<String, Integer>(0,
				"" + 0);
		BinaryTree<String, Integer> bRNode = new BinaryTree<String, Integer>(1,
				"" + 1);
		BinaryTree<String, Integer> bRLNode = new BinaryTree<String, Integer>(1,
				"" + 1);
		BinaryTree<String, Integer> bRLLNode = new BinaryTree<String, Integer>(1,
				"" + 1);
		bRNode.left = bRLNode;
		bRNode.right = bRLLNode;
		BinaryTree<String, Integer> bLNode = new BinaryTree<String, Integer>(2,
				"" + 2);
		bNode.left = bLNode;
		bNode.right = bRNode;
		System.out.println(getNodeNum(bNode));
		System.out.println(getNodeDeep(bNode));
//		System.out.println(-9%10);
//		Math.random();
		}

}
