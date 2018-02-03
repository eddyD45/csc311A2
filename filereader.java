import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class filereader {
	public static void main (String args []) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a file name to read: "); //to use for any file ever in the future 
		String filename = new String(sc.nextLine());
		sc.close();
		
//		try {
//			BufferedReader read = new BufferedReader(new FileReader(filename));
//			read.mark(10000);									//leaving a mark to the start of file to go back there if necessary
//			String fileLine = read.readLine();
//			int totalNumbers = 0;
//			
//			while (fileLine != null) {							//finding total numbers in file to make an array of the appropriate size
//				totalNumbers++;
//				fileLine = read.readLine();
//			}
//			
//			int[] numberArray = new int [totalNumbers];
//			int count = 0;
//			read.reset();
//			fileLine = read.readLine();
//			
//			while(fileLine != null) {							//with the array of proper size, populate it using numbers from file
//				int temp = Integer.parseInt(fileLine);
//				numberArray[count] = temp;
//				count++;
//				fileLine = read.readLine();
//				
//			}
//			
//			
//			read.close();
		int [] numberArray = intfileToArray(filename);
		System.out.println("Printing array...");
		System.out.println("");
		
		for (int i = 0; i < numberArray.length; i++) {
			System.out.println(numberArray[i]);
		}	
			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}


	public static int[] intfileToArray (String filename) throws IOException {
		try {
			BufferedReader read = new BufferedReader(new FileReader(filename));
			read.mark(10000);									//leaving a mark to the start of file to go back there if necessary
			String fileLine = read.readLine();
			int totalNumbers = 0;
		
			while (fileLine != null) {							//finding total numbers in file to make an array of the appropriate size
				totalNumbers++;
				fileLine = read.readLine();
			}
		
			int[] numberArray = new int [totalNumbers];
			int count = 0;
			read.reset();
			fileLine = read.readLine();
		
			while(fileLine != null) {							//with the array of proper size, populate it using numbers from file
				int temp = Integer.parseInt(fileLine);
				numberArray[count] = temp;
				count++;
				fileLine = read.readLine();
			
			}
			
			read.close();
			return numberArray;
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		

	}
}
