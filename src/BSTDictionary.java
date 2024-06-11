// BSTDictionary java program that implements an ordered dictionary using a binary search tree prepared by Adam Yassine

public class BSTDictionary implements BSTDictionaryADT {

	// initialize private object variables
	private BinarySearchTree bst;
	
	// constructor to initialize BST object
	public BSTDictionary() {
		bst = new BinarySearchTree();
	}
	
	// returns Record with key k, or null if the Record is not in dictionary
	public Record get (Key k) {
		return bst.get(bst.getRoot(), k).getRecord();
		
	}
	
	// inserts d into the ordered dictionary
	// throws a DictionaryException if a record with the same key as d is already in dictionary
	public void put (Record d) throws DictionaryException {
		bst.insert(bst.getRoot(), d);
		
	}
	
	// removes the Record with Key k from the dictionary 
	// throws a dictionaryException if Record is not in dictionary
	public void remove (Key k) throws DictionaryException {
		bst.remove(bst.getRoot(), k);
	}
	
	// returns the successor of k and returns null if given Key has no successor
	public Record successor (Key k) {
		BSTNode p = bst.successor(bst.getRoot(), k);
		if (p == null) {
			return null;
		} else {
			return p.getRecord();
		}
	}
	
	// returns the predecessor of k and returns null if the given Key has no predecessor
	public Record predecessor (Key k) {
		BSTNode p = bst.predecessor(bst.getRoot(), k);
		if (p == null) {
			return null;
		} else {
			return p.getRecord();
		}
	}
	
	// returns Record with smallest key in dictionary and returns null if dictionary is empty
	public Record smallest () {
		BSTNode p = bst.smallest(bst.getRoot());
		if (p == null) {
			return null;
		} else {
			return p.getRecord();
		}
	}
	
	// returns the Record with largest key in dictionary and returns null if dictionary is empty
	public Record largest () {
		BSTNode p = bst.largest(bst.getRoot());
		if (p == null) {
			return null;
		} else {
			return p.getRecord();
		}
	}

}
