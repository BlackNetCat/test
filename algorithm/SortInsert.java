package algorithm;

import java.util.Arrays;

public class SortInsert {

	public static void main(String[] args) {
		
		int [] arr = {5,2,3,1,10,7};
		
		System.out.println(Arrays.toString(arr));   // print before sort
		
		for (int i = 1; i < arr.length; i ++) {
			int curEl = arr[i];
			int prevKey = i - 1;
			while (prevKey >= 0 && arr[prevKey] > curEl) {
				arr[prevKey+1] = arr[prevKey];
				arr[prevKey] = curEl;
				prevKey --;		
				
			}
		}
		
		System.out.println(Arrays.toString(arr));

	}

}

