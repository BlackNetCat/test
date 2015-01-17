
public class ArraySumMin {

		
	public static void main(String[] args) {
		int myArray[] = {23,48,12,14,-65,78,12,58,1,-5};
		int negativeAmount = 0;
		int n = myArray.length;
		for (int i = 0; i < n; i++) {
			if (myArray[i] < 0) {
			negativeAmount += myArray[i];
			}
		}
		System.out.println(negativeAmount);
		

	}

}
