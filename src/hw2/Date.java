package hw2;
/* Date.java */

import java.io.*;

class Date {

  /* Put your private data fields here. */
	private int month;
	private int day;
	private int year;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
	  if(isValidDate(month, day, year)){
		  this.month = month;
		  this.day = day;
		  this.year = year;
	  } else {
		  System.out.println("enter date is not valid!");
		  System.exit(0);
	  }
  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
	  int month;
	  int day;
	  int year;
	  String[] date_split = s.split("/");
	  if(date_split.length != 3) {
		  System.out.println("input date is not valid! the format is month/day/year");
		  System.exit(0);
	  } else{
		  if (date_split[0].length() > 2) {
			  System.out.println("input date is not valid!");
			  System.exit(0);
		  } else if(date_split[1].length() > 2){
			  System.out.println("input date is not valid!");
			  System.exit(0);
		  } else if (date_split[2].length() > 4){
			  System.out.println("input date is not valid!");
			  System.exit(0);
		  } else { // input date format is checked
			  	   // need to check date validity
			  month = Integer.parseInt(date_split[0]);
			  day = Integer.parseInt(date_split[1]);
			  year = Integer.parseInt(date_split[2]);
			  if(isValidDate(month, day, year)){
				  this.month = month;
				  this.day = day;
				  this.year = year;
			  } else {
				  System.out.println("enter date is not valid!");
				  System.exit(0);
			  }
		  }
	  }
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
	  if (year % 4 == 0) {
		  if (year % 100 == 0) {
			  if (year % 400 == 0){
				  return true;
			  } 
			  return false;
		  }
		  return true;
	  } 
	  return false;
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
	  int days;
	  if (isLeapYear(year)){
		  switch(month) {
		  case 2:
			  days = 29;
			  break;
		  case 4:
		  case 6:
		  case 9:
		  case 11:
			  days = 30;
			  break;
		  default:
			  days = 31;
			  break;
		  }
	  } else {
		  switch(month) {
		  case 2:
			  days = 28;
			  break;
		  case 4:
		  case 6:
		  case 9:
		  case 11:
			  days = 30;
			  break;
		  default:
			  days = 31;
			  break;
		  }
	  }
    return days;                           
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
	  int dayOfMonth = daysInMonth(month,year);
	  if (year <= 0) {
		  return false;
	  }
	  if (day > dayOfMonth){
		  return false;
	  }
	  return true;
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
	  String toPrint = this.month + "/" + this.day + "/" + this.year;
    return toPrint;                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
	  if(this.year > d.year) {
		  return false;
	  } else if(this.year == d.year) {
		  if (this.month > this.month){
			  return false;
		  } else if(this.month == d.month){
			  if(this.day >= d.day) {
				  return false;
			  } else {
				  return true;
			  }
		  } else {
			  return true;
		  }
	  } else {
		  return true;
	  }
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
	  if(this.year > d.year) {
		  return true;
	  } else if(this.year == d.year) {
		  if (this.month > this.month){
			  return true;
		  } else if(this.month == d.month){
			  if(this.day > d.day) {
				  return true;
			  } else {
				  return false;
			  }
		  } else {
			  return false;
		  }
	  } else {
		  return false;
	  }
}

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
	  int count = 1; // start a recursion
	  int total_day = 0;
	  while(count<this.month){
		  total_day = total_day + daysInMonth(count,this.year);
		  count++;
	  }
	  total_day = total_day + this.day;
    return total_day;                           // replace this line with your solution
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
	  int delta_day = 0;
	  if(this.isAfter(d)) {
		  if(Date.isLeapYear(d.year)){
			  delta_day = delta_day + 366 - d.dayInYear() + this.dayInYear();
		  } else {
			  delta_day = delta_day + 365 - d.dayInYear() + this.dayInYear();
		  }
		  
		  for(int i = d.year+1; i<this.year; i++ ){
			  if(isLeapYear(i)){
				  delta_day = delta_day + 366;
			  } else{
				  delta_day = delta_day + 365;
			  }
		  }
	  } else if(this.isBefore(d)) {
		  if(Date.isLeapYear(this.year)){
			  delta_day = delta_day + 366 - this.dayInYear() + d.dayInYear();
		  } else {
			  delta_day = delta_day + 365 - this.dayInYear() + d.dayInYear();
		  }
		  
		  for(int i = this.year+1; i<d.year; i++ ){
			  if(isLeapYear(i)){
				  delta_day = delta_day + 366;
			  } else{
				  delta_day = delta_day + 365;
			  }
		  }
		  delta_day = -delta_day;
	  } else{
		  return 0;
	  }
	  
    return delta_day;                           // replace this line with your solution
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);
    //d1 = new Date(2,30,1990);
    System.out.println("\nTesting days in year");
    d1 = new Date("1/2/2000");
    int result = d1.dayInYear();
    System.out.println(result);
    
    
    
    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */
    System.out.println("\nTesting isLeapYear.");
    System.out.println("");

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));
    

    
    
    

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
