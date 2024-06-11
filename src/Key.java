// Key java program that represents the key of the items stored in the nodes of the BST prepared by Adam Yassine

public class Key {

	// initialize private variables
	private String label;
	private int type;

	// constructor to initialize key object and type variables
	public Key(String theLabel, int theType) {
		this.label = theLabel.toLowerCase();
		this.type = theType;
	}

	// return the string stored in the label variable
	public String getLabel() {
		return label;
	}

	// return the value of the type variable
	public int getType() {
		return type;
	}

	// Returns an integer depending on the comparison between the two keys
	public int compareTo(Key k) {
		if (this.label.equals(k.label) && this.type == k.type) {
			return 0; // if both the label and type are the same, return 0
		} else if ((this.label.compareTo(k.label) < 0) || (this.label.equals(k.label) && this.type < k.type)) {
			return -1; // if the labels are the same, but the type is less than this key, return -1
		} else {
			return 1; // else return 1 if this.key is greater
		}
	}

}
