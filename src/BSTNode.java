//BSTNode java program that represents a node of the BST prepared by Adam Yassine

public class BSTNode {

	// initialize object variables
	private Record record;
	private BSTNode leftChild;
	private BSTNode rightChild;
	private BSTNode parent;

	// constructor to initialize item variable
	public BSTNode(Record item) {
		this.record = item;
	}

	// return the record object
	public Record getRecord() {
		return record;
	}

	// store the given record in the node
	public void setRecord(Record d) {
		this.record = d;
	}

	// return the left child
	public BSTNode getLeftChild() {
		return leftChild;
	}

	// return the right child
	public BSTNode getRightChild() {
		return rightChild;
	}

	// return the parent
	public BSTNode getParent() {
		return parent;
	}

	// set the left child to specified value
	public void setLeftChild(BSTNode u) {
		this.leftChild = u;
	}

	// set the right child to specified value
	public void setRightChild(BSTNode u) {
		this.rightChild = u;
	}

	// set the parent to specified value
	public void setParent(BSTNode u) {
		this.parent = u;
	}

	// check if the node is a leaf or not
	public boolean isLeaf() {
		if (leftChild == null && rightChild == null) {
			return true; // if both children of the node are null then it is a leaf
		} else {
			return false; // otherwise return false
		}

	}

}
