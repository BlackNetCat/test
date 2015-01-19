package algorithm;

import java.util.Arrays;

public class SortBubble {   // N elements  nead  N^2 iteration

	public static void main(String[] args) {
		
		int [] arr = {5,2,3,1,10,7};
		
		System.out.println(Arrays.toString(arr));   // print before sort
					
		
		for (int i = 0; i < arr.length-1; i++){
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					}			
			}
					
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
