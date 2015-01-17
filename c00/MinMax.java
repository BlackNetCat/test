
public class MinMax {

	static int[] array = {12,4,8,16,32};
	
public static void main(String[] args) {
			
	System.out.println("Minimal " + minimal(array));
	System.out.println("Maximal " + maximal(array));		    
	}
	
public static int minimal (int[] array){
	    int minVal = array[0];
	    for (int i = 1; i < array.length; i++) {
	    if(array[i] < minVal) 
	    	minVal = array[i];
	    }
	    return minVal; 
	    }
public static int maximal (int[] array){
    int maxVal = array[0];
    for (int i = 1; i < array.length; i++) {
    if(array[i] > maxVal) 
    	maxVal = array[i];
    }
    return maxVal;
	}
}
