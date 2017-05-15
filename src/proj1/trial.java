package proj1;

public class trial {

	public static void main (String args[]) {
		System.out.println("begin!");
		int[] test_list = new int[7];
		System.out.println(test_list.length);
		int[][][] int_list = new int[3][2][2];
		for (int i=0;i<int_list.length;i++){
			for (int j=0;j<int_list[0].length;j++){
				for (int k=0;k<int_list[0][0].length;k++){
					int_list[i][j][k] = k;
					System.out.print(int_list[i][j][k] + " ");
				}
				System.out.println("");
			}
		}
		String a = "haha!\n";
		String b = "kexin!";
		a += b;
		
		System.out.println(a);
		int i = -1;
		assert i == -1;
		System.out.println(i);
		short aa = 1;
		short bb = 2;
		System.out.println("yes!"+aa);		
		System.out.println(bb);
	}
}
