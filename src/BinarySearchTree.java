// BinarySearchTree java program that represents a binary search tree prepared by Adam Yassine

public class BinarySearchTree {

	// initialize private variables
	private BSTNode root;
	
	// constructor to initialize leaf node as the root of the tree
	public BinarySearchTree() {
		this.root = new BSTNode(null);
	}
	
	// return the root node of the BST
	public BSTNode getRoot() {
		return root;
	}
	
	// returns the node storing the given key
	public BSTNode get(BSTNode r, Key k) {
		if (r == null) { 
			return null;
		}
		if (r.isLeaf() == true) { // if root node r is a leaf, return r
			return r;
		}
		else {
			// otherwise, return r if the node r is equal to the key
			if (r.getRecord().getKey().compareTo(k) == 0) {
				return r;
			}
			// call the right child recursively if key of r is smaller than given key
			else if (r.getRecord().getKey().compareTo(k) < 0) {
				return get(r.getRightChild(), k);
			}
			else {
				// otherwise, recursively call the left child
				return get(r.getLeftChild(), k);
			}
		}
	}
	
	// adds record to BST with root r (same as put operation)
	public void insert(BSTNode r, Record d) throws DictionaryException {
		// use the get method to find the nodePos's position
		BSTNode nodePos = get(r, d.getKey());
		if (nodePos.isLeaf() == false) { // throw an exception if it is not a leaf
			throw new DictionaryException("");
		}
		else { // otherwise insert the new node 
			nodePos.setRecord(d);
			BSTNode leftNode = new BSTNode(null); // create 2 leaf nodes and set them as children for the new node
			BSTNode rightNode = new BSTNode(null);
			nodePos.setLeftChild(leftNode); // set the children of p and its parent
			leftNode.setParent(nodePos);
			nodePos.setRightChild(rightNode);
			rightNode.setParent(nodePos);
		}
	}
	
	// removes the node with the given key from the tree with root r
	public void remove (BSTNode r, Key k) throws DictionaryException {
		// use the get method to find the nodePos's position
		BSTNode nodePos = get(r, k);
		if (nodePos.isLeaf()) { // throw an exception if p is a leaf
			throw new DictionaryException("");
		} else {
			// if either the left or right child of the node are leafs
			if (nodePos.getLeftChild().isLeaf() || nodePos.getRightChild().isLeaf()) {
				BSTNode c;
				if (nodePos.getLeftChild().isLeaf()) { // set the other child to c
					c = nodePos.getRightChild();
				} else {
					c = nodePos.getLeftChild();
				}
				BSTNode pp = nodePos.getParent(); 
				if (pp != null) { // if the parent of the current node is not null
					c.setParent(pp);
					if (nodePos.equals(pp.getLeftChild())) {
						pp.setLeftChild(c);
					} else {
						pp.setRightChild(c);
					} // set the parent of current node as the parent of c
					 // and vice versa for the parent 
				} else {
					root = c; // set c as the root
				}
			} else { // otherwise if both children are not leaf nodes
				// replace the node with the smallest value from the right child
				BSTNode s = smallest(nodePos.getRightChild());
				nodePos.setRecord(s.getRecord());
				remove(s, s.getRecord().getKey()); // recursively remove the smallest of the right child
			}
		}
	}
	
	// returns node storing the successor of the given key in the tree with root r
	public BSTNode successor(BSTNode r, Key k) {
		BSTNode nodePos = get(r, k);
		// get the smallest from the right child if position is neither a leaf node or its left and right child isn't 
		if (nodePos.isLeaf() == false && nodePos.getRightChild().isLeaf() == false) {
			return smallest(nodePos.getRightChild());
		}
		else {
			nodePos = nodePos.getParent();
			while (nodePos != null && nodePos.getRecord().getKey().compareTo(k) < 0) {
				// go to parent node until the node's key is greater than k
				nodePos = nodePos.getParent();
			}
			return nodePos; //return p if not found
		}
	}
	
	// returns node storing the predecessor of the given key in the tree with root r
	public BSTNode predecessor(BSTNode r, Key k) {
		BSTNode nodePos = get(r, k); 
		// get the largest from the right child if position is neither a leaf node or its left and right child isn't 
		if (nodePos.isLeaf() == false && nodePos.getLeftChild().isLeaf() == false) {
			return largest(nodePos.getLeftChild());
		}
		else {
			nodePos = nodePos.getParent();
			while (nodePos != null && nodePos.getRecord().getKey().compareTo(k) > 0) {
				// go to parent node until the node's key is smaller than k
				nodePos = nodePos.getParent();
			}
			return nodePos; //return p if not found
		}
	}
	
	// returns the node with the smallest key in tree with root r
	public BSTNode smallest(BSTNode r) {
		if (r == null) {
			return null;
		} else {
			BSTNode nodePos = r;
			while (nodePos.isLeaf() == false) {
				nodePos = nodePos.getLeftChild(); // repeatedly reach the leftmost node
			}
			return nodePos.getParent(); // otherwise return the node above the empty leaf node
		}
	}
	
	// returns the node with the largest key in tree with root r
	public BSTNode largest (BSTNode r) {
		if (r == null) {
			return null;
		} else {
			BSTNode nodePos = r;
			while (nodePos.isLeaf() == false) {
				nodePos = nodePos.getRightChild(); // repeatedly reach the rightmost node 
			}
			return nodePos.getParent(); // otherwise return the node above the empty leaf node
		}
	}
	
}
