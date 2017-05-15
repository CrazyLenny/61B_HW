package hw1;
/* OpenCommercial.java */

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();



    /* Replace this comment with your solution.  */
    String webURL;
    webURL = "www." + inputLine + ".com";
    System.out.println("I am input: " + webURL);    
    URL website = new URL("http://"+webURL);
    URLConnection con = website.openConnection();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(
                con.getInputStream()));
    //StringBuilder result = new StringBuilder();
    String read_line;
    List<String> listStrings = new ArrayList<String>();

    System.out.println("start printing normal order:");
    for (int i=0; i<5; i++){
    	read_line = in.readLine();
    	listStrings.add(read_line);
    	System.out.println(i);
        System.out.println(read_line);
    }

    System.out.println("start printing reverse:");
    for (int i=4; i>=0; i--){
    	System.out.println(i);
    	System.out.println(listStrings.get(i));
    }
    in.close();
    //System.out.println(result.length());
    //System.out.println(result);
    
    
    
    
    

  }
}
