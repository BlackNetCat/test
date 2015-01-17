
public class ArrayMin {

	public static void main(String[] args) {
		
		
		int[] numbers = {12,4,2,5,7,2,7,8};
		int min = numbers[0];
		for (int i = 0; i < numbers.length; i++){
			if(min>numbers[i]){
				min = numbers[i];
				
			}
			
			
			//do
			//{System.out.println(numbers[i]);
		//	}while (numbers[i]<=min);
			
		}
		System.out.println(min);
	}

}
