package lib;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class TextFile {
	//Fields
	private ArrayList<String> textFile = new ArrayList<String>();
	private static Scanner scnr;


	// Constructors

	public TextFile(ArrayList<String> strs) throws FileNotFoundException {
		this.textFile = strs;
	}

	/**
	 * Initialises the array in many ways. It will set and store the class variable for the file path and put it into a scanner.
	 * Later it will find the appropriate length of the file in lines and declare the array length. Then it will store the lines
	 * one at at a time into the corresponding array index (i.e. line 1 will be stored in index 0. Then prints out the results.
	 * @param initfile Path to the text file.
	 * @throws FileNotFoundException In-case the void method encounters no file.
	 */
	public TextFile(File file) throws FileNotFoundException {
		scnr = new Scanner(file); // sets the file up in the scanner.

		// Loops through all the lines while the scanner has any.
		while(scnr.hasNextLine()){
			this.textFile.add(scnr.nextLine());
		}

		scnr.close();
	} 

	//methods


	public static ArrayList<String> fileToArrayList(File tmpFile) throws FileNotFoundException {
		ArrayList<String> tmpTextFile = new ArrayList<String>();
		scnr = new Scanner(tmpFile); // sets the file up in the scanner.

		// Loops through all the lines while the scanner has any.
		while(scnr.hasNextLine()){
			tmpTextFile.add(scnr.nextLine());
		}

		scnr.close();
		return tmpTextFile;

	}

	/**
	 * gReturns the array by adding it all to a formatted String ready for printing.
	 * @return returns the array in a formatted string.
	 */
	public String getAll() {
		String textFileAll = "";

		for (int i=0; i < textFile.size(); i++) {
			textFileAll += "Line " + (i+1) + ": " + textFile.get(i) + "\n";
		}

		return textFileAll;
	}

	/**
	 * gets the specified line from the array.
	 * @param x the line from the array (from 0).
	 * @return the line as a string.
	 */
	public String getLine(int x) {
		return "Line " + (x+1) + ": " + textFile.get(x);
	}

	/**
	 * gets the specified line from the array.
	 * @param x The line from the array (from 0).
	 * @param newLine The string to set the line to.
	 */
	public void setLine(String newLine, int x) {
		textFile.set(x, newLine);
	}

	// TODO JavaDoc the methods below.

	public String[] findAllLines(String str) {
		String[] linesFound = new String[this.textFile.size()];
		for (int i = 0; i < this.textFile.size(); ++i) {
			if (this.textFile.get(i).contains(str) == true) {
				linesFound[i] = this.textFile.get(i);
			} else {
				linesFound[i] = "Not found!";
			}
		}

		return linesFound;
	}

	public boolean falsifyString(String str) {
		for (int i = 0; i < this.textFile.size(); ++i) {
			if (this.textFile.get(i).contains(str) == true) {
				return true;
			}
		}
		return false;
	}

	public int stringCount(String str) {
		int count = 0;
		for (int i = 0; i < this.textFile.size(); ++i) {
			if (this.textFile.get(i).contains(str) == true) {
				++count;
			}
		}
		return count;
	}

	// CAN BE UPGRADED LATER TO ACCOUNT FOR PUNCTUATION (to remove it).
	public String occurance(int line) {
		String str = this.textFile.get(line);
		String[] strgs = str.split(" ");


		// Replaces the second or further instance of a string with "";
		for (int i = 0; i < strgs.length; ++i) {
			if (strgs[i] != null) {
				for (int ii = 0; ii < i; ii++) {
					if (strgs[ii].equals(strgs[i])) {
						strgs[i] = "";
					}
				}
			} else {
				i = -1;
			}
		}



		//creates the new area without empty elements to return finally.
		String strgsFinal = "Strings in occurance: ";
		for (int i = 0; i < strgs.length; i++) {
			if (strgs[i] != ""){strgsFinal += "[" + strgs[i] + "], ";}
		}
		strgsFinal.substring(0, (strgsFinal.length()-2));
		return strgsFinal.substring(0, (strgsFinal.length()-2)) + ".";
	}
}

