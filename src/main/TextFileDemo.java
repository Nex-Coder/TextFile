package main;
import java.io.File;
import java.io.FileNotFoundException;

import lib.TextFile;

public class TextFileDemo {

	public static void main(String[] args) throws FileNotFoundException {
		TextFile txt1 = new TextFile(TextFile.fileToArrayList(new File("C:\\txt\\test.txt")));
		
		
		System.out.println(txt1.getAll());
		
		System.out.println(txt1.occurance(0));
		
	}
}
