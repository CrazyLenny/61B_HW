package hw2;

public class test {
	public static void main(String[] arg) throws Exception{
		System.out.println("Hello HW2!");
		String date = "2/26/1991";
		System.out.println("The date is: " + date);
		String[] date_split = date.split("/");
		System.out.println("split length: " + date_split.length);
		for(String i: date_split){
			System.out.println(i);
		}
		int result = Integer.parseInt(date_split[0]);
		System.out.println(result);
		System.out.println(date_split[1].length());
		for (int i =2; i<1; i++){
			System.out.println("hehe");
		}
	}
}


