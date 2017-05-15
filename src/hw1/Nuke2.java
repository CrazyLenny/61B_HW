package hw1;

import java.util.Scanner;

public class Nuke2 {
	
	public static void main(String[] arg ) throws Exception{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("please enter a string:");
		String myString = keyboard.nextLine();
		String newString ="";
		//System.out.println(myString.length());
		for (int i=0; i<myString.length(); i++){
			if (i!=1){
				newString = newString + myString.charAt(i);
			}
		}
		
		System.out.println(newString);

		
	}

}
