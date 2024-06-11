// interface java program to store data into dictionary and perform operations on the files prepared by Adam Yassine

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Interface {

    // initialize constants for the different types of data
	private static final int DEFINE = 1; // string containing a definition of label
	private static final int TRANSLATE = 2; // translation of label to French
	private static final int SOUND = 3; // name of a sound file
	private static final int PLAY = 4; // name of a music file
	private static final int SAY = 5; // name of a voice file
	private static final int SHOW = 6; // name of an image file
	private static final int ANIMATE = 7; // name of an animated image file
	private static final int BROWSE = 8; // URL of a web page

	public static void main(String[] args) {
BSTDictionary dict = new BSTDictionary(); // create a new dictionary
		
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
			String label;
			int type;
			while ((label = fileReader.readLine()) != null && label.length() > 0) {
				String line = fileReader.readLine();
				String data = null;

				// retrieve the type based on the starting and ending formats
				if (line.startsWith("-") || line.endsWith(".gif")) {
					type = ANIMATE;
				} else if (line.startsWith("+") || line.endsWith(".jpg")) {
					type = PLAY;
				} else if (line.startsWith("*")) {
					type = SAY;
				} else if (line.startsWith("/")) {
					type = TRANSLATE;
				} else if (line.endsWith(".jpg")) {
					type = SHOW;
				} else if (line.endsWith(".html")) {
					type = BROWSE;
				} else {
					type = DEFINE;
				}

				// adjust data based on the type 
				switch (type) {
				case DEFINE: // 1
				case SHOW: // 6
				case ANIMATE: // 7
				case BROWSE: // 8
					data = line;
					break;
				case TRANSLATE: // 2
				case SOUND: // 3
				case PLAY: // 4
				case SAY: // 5
					data = line.substring(1);
					break;
				}
				
                // Put the record in the dictionary with its name, it's type and data inside 
				dict.put(new Record(new Key(label, type), data));

				 }
	            fileReader.close(); // Close file reader
			} catch (DictionaryException e) { // catch any dictionary or IO exceptions 
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		try { // test and catch input error handling
			boolean quitProgram = false;
			// initialize variable to read user commands
			StringReader keyboard = new StringReader();
			String line = keyboard.read("Enter next command: ");

			SoundPlayer playSound = new SoundPlayer(); // initialize multi-media reader objects
			PictureViewer viewPic = new PictureViewer();
			ShowHTML showHtml = new ShowHTML();
			StringTokenizer stringToken = new StringTokenizer(line, " ");
			String token = stringToken.nextToken();

			while (!quitProgram) { // keep running program/commands until the user types 'exit' 

				switch (token) {

				case "define": { // call the defineLabel private method to define w
					defineLabel(stringToken, dict);
                    break;
				}
				
				case "translate": { // call the defineLabel private method to translate w
					translateLabel(stringToken, dict);
					break;
				}
				
				case "sound": { // call the hearSound private method to sound w
					hearSound(stringToken, dict, playSound, SOUND);
                    break;
				}
				
				case "play": { // call the playSound private method to play w
					  playSound(stringToken, dict, playSound, PLAY);
                      break;
				}
				
				case "say": { // call the saySound private method to say w
					saySound(stringToken, dict, playSound, SAY);
                    break;
				}
			
				case "show": { // call the showImage private method to show w
					 showImage(stringToken, dict, viewPic, SHOW);
                     break;
				}
				
				case "animate": { // call the animateImage private method to animate w
					animateImage(stringToken, dict, viewPic, ANIMATE);
                    break;
				}
				
				case "browse": { // call the browseWeb private method to browse w
					browseWeb(stringToken, dict, showHtml);
                    break;
					
				}
				
				case "delete": { // call the deleteRec private method to delete w k
					 deleteRec(stringToken, dict);
                     break;

				}
				case "add": { // call the addRec private method to add w t c 
					 addRec(stringToken, dict);
                     break;
				}
				
				case "list": { // call the listPrefix private method to list all the prefix
					listPrefix(stringToken, dict);
                    break;
				}
				
				case "first": { // print all the attributes in the dictionary with the smallest key
					Record rec = dict.smallest(); // call the smallest method and list its attributes
					System.out.println(rec.getKey().getLabel() + "," + rec.getKey().getType() + "," + rec.getDataItem());
					break;
				}
			
				case "last": { // print all the attributes in the dictionary with the largest key
					Record rec = dict.largest(); // call the largest method method and print its attributes
					System.out.println(rec.getKey().getLabel() + "," + rec.getKey().getType() + "," + rec.getDataItem());
					break;
				}
				
				case "exit": { // end program
					quitProgram = true;
					break;
				}
				
				default:
					System.out.println("Invalid command.");
				}

				if (quitProgram) {
					break;
				}
				// reinitialize the variables for user input to be prompted the commands again
				line = keyboard.read("Enter next command: ");
				stringToken = new StringTokenizer(line, " ");
				token = stringToken.nextToken();
			}

		} catch (
		NoSuchElementException e) { // catch any possible NoSuchElementException
			System.out.println("Error: Improper call of a command.");
		}
    }
	 // private helper methods
	/* The private methods are declared as static since they operate on 
	 * class-level functionality and do not rely on instance-specific data or behavior
	 */
	
	// define a label in dictionary and print its corresponding data
    private static void defineLabel(StringTokenizer stringToken, BSTDictionary dict) {
    	String wDef = stringToken.nextToken(); // extract label using the String Token
		Record recDef = dict.get(new Key(wDef, DEFINE)); // get the record based on the label and data type
		if (recDef == null) { // print error message if record is not in the dictionary
			System.out.println("The word " + wDef + " is not in the dictionary"); 
		} else {

			System.out.println(recDef.getDataItem()); // print the data inside the record defined
		}
    }

    // translate a label in dictionary to French
    private static void translateLabel(StringTokenizer stringToken, BSTDictionary dict) {
        String wTrans = stringToken.nextToken(); // extract label using the String Token
        Record recTrans = dict.get(new Key(wTrans, TRANSLATE)); // get the record based on the label and data type
        if (recTrans == null) { // print error message if record is not in the dictionary
            System.out.println("There is no definition for the word " + wTrans);
        } else {
            System.out.println(recTrans.getDataItem()); // print the translation of the label
        }
    }
    
    private static void hearSound(StringTokenizer stringToken, BSTDictionary dict, SoundPlayer playSound, int type) {
        String wSound = stringToken.nextToken(); // extract label using the String Token
        Record recSound = dict.get(new Key(wSound, SOUND));  // get the record based on the label and data type
        if (recSound == null) { // print error message if record is not in the dictionary
            System.out.println("There is no sound file for " + wSound); 
        } else {
            try {
				playSound.play(recSound.getDataItem()); // play the sound of the record
			} catch (MultimediaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
        }
    }

    private static void playSound(StringTokenizer stringToken, BSTDictionary dict, SoundPlayer playSound, int type) {
        String wPlay = stringToken.nextToken(); // extract label using the String Token
        Record recPlay = dict.get(new Key(wPlay, PLAY));  // get the record based on the label and data type
        if (recPlay == null) { // print error message if record is not in the dictionary
            System.out.println("There is no music file for " + wPlay);
        } else {
            try {
				playSound.play(recPlay.getDataItem()); // play the sound of the record
			} catch (MultimediaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    private static void saySound(StringTokenizer stringToken, BSTDictionary dict, SoundPlayer playSound, int type) {
        String wSay = stringToken.nextToken(); // extract label using the String Token
        Record recSay = dict.get(new Key(wSay, SAY));  // get the record based on the label and data type
        if (recSay == null) { // print error message if record is not in the dictionary
            System.out.println("There is no voice file for " + wSay);
        } else {
            try {
				playSound.play(recSay.getDataItem()); // play the sound of the record
			} catch (MultimediaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    private static void showImage(StringTokenizer stringToken, BSTDictionary dict, PictureViewer viewPic, int type) {
        String wShow = stringToken.nextToken(); // extract label using the String Token
        Record recShow = dict.get(new Key(wShow, SHOW));  // get the record based on the label and data type
        if (recShow == null) { // print error message if record is not in the dictionary
            System.out.println("There is no image file for " + wShow);
        } else {
            try {
				viewPic.show(recShow.getDataItem()); // show the image of the record
			} catch (MultimediaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    private static void animateImage(StringTokenizer stringToken, BSTDictionary dict, PictureViewer viewPic, int type) {
		String wAnim = stringToken.nextToken(); // extract label using the String Token
		Record recAnim = dict.get(new Key(wAnim, ANIMATE));  // get the record based on the label and data type
		if (recAnim == null) { // print error message if record is not in the dictionary
			System.out.println("There is no animated image file for " + wAnim);
		} else {
			try {
				viewPic.show(recAnim.getDataItem()); // show the animation of the record
			} catch (MultimediaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }


    private static void browseWeb(StringTokenizer stringToken, BSTDictionary dict, ShowHTML showHtml) {
		String wBrowse = stringToken.nextToken(); // extract label using the String Token
		Record recBrowse = dict.get(new Key(wBrowse, BROWSE));  // get the record based on the label and data type
		if (recBrowse == null) { // print error message if record is not in the dictionary
			System.out.println("There is no webpage called " + wBrowse);
		} else {
			showHtml.show(recBrowse.getDataItem()); // show the web page of the record
		}
    }

    private static void deleteRec(StringTokenizer stringToken, BSTDictionary dict) {
		String wDel = stringToken.nextToken(); // extract label using the String Token
		String kDel = stringToken.nextToken();
		Record recDel = dict.get(new Key(wDel, Integer.parseInt(kDel)));  // get the record based on the label and data type
		if (recDel == null) { // print error message if record is not in the dictionary
			System.out.println("No record in the ordered dictionary has key (" + wDel + "," + kDel + ").");
		} else {
			try {
				dict.remove(recDel.getKey()); // delete the record from the dictionary
			} catch (DictionaryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    private static void addRec(StringTokenizer stringToken, BSTDictionary dict) {
		String wAdd = stringToken.nextToken(); // extract label using the String Token
		String tAdd = stringToken.nextToken(); // extract the data type
		String cAdd = stringToken.nextToken(); // extract the data content
		while (stringToken.hasMoreTokens()) {  // concatenate the tokens to the data content if more tokens exist
			cAdd += " " + stringToken.nextToken();

		}
		int type = Integer.parseInt(tAdd); // parse the data type
		Record recAdd = dict.get(new Key(wAdd, type));  // get the record based on the label and data type
		if (recAdd != null) { // print error message if record is already in the dictionary
			System.out.println("A record with the given key (" + wAdd + "," + tAdd
					+ ") is already in the ordered dictionary");
		} else {
			try {
				dict.put(new Record(new Key(wAdd, Integer.parseInt(tAdd)), cAdd)); // put/add the record to the dictionary
			} catch (NumberFormatException | DictionaryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    private static void listPrefix(StringTokenizer stringToken, BSTDictionary dict) {
    	String prefix = stringToken.nextToken(); // extract label using the String Token
		Record recList = dict.get(new Key(prefix, 1));  // get the record based on the label and data type
		// print error message if record is not in the dictionary
		if (recList == null || !recList.getKey().getLabel().startsWith(prefix)) {
			System.out.println("No label attributes in the ordered dictionary start with prefix " + prefix);
		}
		while (recList.getKey().getLabel().startsWith(prefix)) { // Iterate through dictionary to print labels starting with the given prefix
			System.out.print(recList.getKey().getLabel());

	        // Check if it's the last label or if the next label doesn't start with the prefix
			if (recList == dict.largest() || !dict.successor(recList.getKey()).getKey().getLabel().startsWith(prefix)) {
				System.out.println();
				break;
			} else {
				System.out.print(", ");
			}
			recList = dict.successor(recList.getKey()); // move to the next record

		}
    }

}
