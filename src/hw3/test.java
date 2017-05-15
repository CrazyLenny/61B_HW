package hw3;

public class test {
	  public static void smoosh(int[] ints) {
		    // Fill in your solution here.  (Ours is twelve lines long, not counting
		    // blank lines or lines already present in this file.)
			  int move_limit = ints.length;
			  int limit = ints.length;
			  int n = 0;
			  while (n < move_limit) {
				  for ( int j = 0; j+1<move_limit; j++){
					  if (ints[j] == ints[j+1] ) {
						  for( int i = j; i+1 < ints.length; i++){
							  ints[i] = ints[i+1];
						  }
						  ints[ints.length-1] = -1;
						  move_limit--;
					  }
				  }
				  n++;
			  }
		  }
	
	
	public static void main(String[] args) {
		System.out.println("Hello Test!");
		int[] ints = {1,1,1,1};

		smoosh(ints);
		for (int number: ints){
			System.out.println(number);
		}
		System.out.println("array length: " + ints.length);
	
	    System.out.println("\nLet's squish linked lists!\n");

	    String result;
	    int i;
	    int[] test5 = {1,2,2,3,4,4,4,5};
	    SList list5 = new SList();
	    for (i = 0; i < test5.length; i++) {
	      list5.insertEnd(new Integer(test5[i]));
	    }
	    System.out.println("squishing " + list5.toString() + ":");
	    list5.squish();
	    result = list5.toString();
	    System.out.println(result);
	    System.out.println(list5.getHeaditem());
	    System.out.println(list5.nth(4));

		
		
		
		
		
	
	}
}
