//Record java program that represents the records stored in the internal nodes of the BST prepared by Adam Yassine

public class Record {

	// initialize instance variables
	private Key theKey;
	private String data;

	// constructor to initialize the key and data object variables
	public Record(Key k, String theData) {
		this.theKey = k;
		this.data = theData;
	}

	// return the key variable
	public Key getKey() {
		return this.theKey;
	}

	// return the data variable
	public String getDataItem() {
		return this.data;
	}
}
