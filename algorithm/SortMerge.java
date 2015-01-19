package algorithm;

import java.util.Arrays;

public class SortMerge {    // NOT READY
	
	static int [] arrA = {5,12,13,21,100,700};
	static int [] arrB = {0,0,2,5,10,17};
	static int [] result = new int[arrA.length + arrB.length];  // create new array with summ items of two arrays

	public static int[] merge (int [] arrA, int[] arrB) {
		int [] result = new int[arrA.length + arrB.length];  // create new array with summ items of two arrays
		int aindex = 0;
		int bindex = 0;
		
		while ((aindex + bindex) != result.length) {
			if (arrA[aindex] != 0 || arrB[bindex] != 0) {
				if (arrA[aindex] < arrB[bindex]) {
					result[aindex + bindex] = arrA[aindex++];
				
				}
				else  {
					result[aindex + bindex] = arrB[bindex++];
				
				}
			}
			else System.out.println("error");
			break;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(arrA));
		System.out.println(Arrays.toString(arrB));
		merge(arrA, arrB);
		System.out.println(Arrays.toString(result));

	}

}
