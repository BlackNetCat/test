
public class Array {

	public static void main(String[] args) {
		int[] myArray = new int[10];
		//int min = myArray[0];
		for (int i = 0; i < myArray.length; i++) {
			
			myArray[i] = i*2+1;
					
		}
		
		for (int i = 0; i < myArray.length; i++){
			System.out.print(myArray[i] + ", ");
		}

	}

}
