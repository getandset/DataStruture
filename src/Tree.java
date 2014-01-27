/**
 * Created by lj on 14-1-8.
 */
public class Tree<T extends Comparable<? super T>> {
	private Node<T> root;

	private class Node<T> {
		T key;
		Node<T> right;
		Node<T> left;
		Node<T> parent;

		public Node (T key) {
			this.key = key;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		public Node (T key, Node<T> l, Node<T> r) {
			this.key = key;
			this.left = l;
			this.right = r;
			this.parent = null;
		}
	}

	public void insert (T key) {
		Node<T> x  = root;
		Node<T> parent = null;
		while (x!=null) {
			parent = x;
			if (x.key.compareTo(key)<0) {
				x = x.left;
			}
			else if (x.key.compareTo(key)>0) {
				x = x.right;
			}
			else
				return;
		}
		Node<T> newNode = new Node<T>(key);
		newNode.parent = parent;
		if (parent==null) {
			root = newNode;
		}
		else {
			x = newNode;
			if (x.key.compareTo(parent.key)>0)
				parent.right = x;
			else
				parent.left = x;
		}
	}

	public Node<T> insertByRecursion (Node<T> root, T key) {
		if (root==null) {
			root = new Node<T>(key);
			return root;
		}
		else {
			if (root.key.compareTo(key)<0) {
				root.left = insertByRecursion(root.left, key);
				root.left.parent = root;
			}
			else if (root.key.compareTo(key)>0) {
				root.right = insertByRecursion(root.right, key);
				root.right.parent = root;
			}
			else {}
		}
		return root;
	}

	public Node<T> search(T key) {
		Node<T> node = root;
		while (node!=null) {
			if (node.key.compareTo(key)>0) {
				node = node.right;
			}
			else if (node.key.compareTo(key)<0) {
				node = node.left;
			}
			else {
				return node;
			}
		}
		return null;
	}

	public void delete (T key) {
		Node<T> delete = search(key);
		if (delete==null) {
			return;
		}
		Node<T> node;
		Node<T> childNode;
		if (delete.left==null || delete.right==null) {
			node = delete;
		}
		else {
			node = successor(delete);
		}
		if (node.left!=null) {
			childNode = node.left;
		}
		else {
			childNode = node.right;
		}
		if (childNode!=null) {
			childNode.parent = node.parent;
		}
		if (node.parent==null) {
			root = childNode;
		}
		else {
			if (node==node.parent.left) {
				node.parent.left = childNode;
			}
			else {
				node.parent.right = childNode;
			}
		}
		if (node!=delete) {
			delete.key = node.key;
		}
	}

	public T successor (T key) {
		Node<T> node = search(key);
		if (node.right!=null) {
			return minmun(node.right);
		}
		Node<T> parent = node.parent;
		while (parent!=null && node==parent.right) {
			node = parent;
			parent = parent.parent;
		}
		if (parent==null) {
			return null;
		}
		return parent.key;
	}

	public Node<T> successor (Node<T> node) {
		if (node.right!=null) {
			return maxNode(node);
		}
		Node<T> parant = node.parent;
		while (parant!=null && node==parant.right) {
			node = parant;
			parant = parant.parent;
		}
		return parant;
	}

	public T predecessor (T key) {
		Node<T> node = root;
		if (node.left!=null) {
			return maxmun(node.left);
		}
		Node<T> parent = node.parent;
		while (parent!=null && node==parent.left) {
			node = parent;
			parent = parent.parent;
		}
		if (parent==null) {
			return null;
		}
		return parent.key;

	}

	public T maxmun (Node<T> root) {
		Node<T> node = root;
		while (root.right!=null) {
			node = node.right;
		}
		return node.key;
	}

	public Node<T> maxNode (Node<T> node) {
		while (node.right!=null) {
			node = node.right;
		}
		return node;
	}

	public T minmun (Node<T> root) {
		Node<T> node = root;
		while (root.left!=null) {
			node = node.left;
		}
		return node.key;
	}

	public void inoderWalk () {

	}

	public void inoderWalkByRecursion (Node<T> node) {
		if (node!=null) {
			inoderWalkByRecursion(node.left);
			System.out.println(node.key);
			inoderWalkByRecursion(node.right);
		}

	}

	public void preoderWalk () {

	}

	public void preoderWalkByRecursion (Node<T> node) {
		if (node!=null) {
			System.out.println(node.key);
			preoderWalkByRecursion(node.left);
			preoderWalkByRecursion(node.right);
		}
	}

	public void postoderWalk () {

	}

	public void postoderWalkByRecursion (Node<T> node) {
		if (node!=null) {
			postoderWalkByRecursion(node.left);
			postoderWalkByRecursion(node.right);
			System.out.println(node.key);
		}

	}
}
