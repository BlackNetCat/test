
public class Maximal {

	static int result=0;
	
	public static void main(String[] args) {
	
	maxABCD(21,4,8,9);	
	System.out.println("Maximal " + result);

	}
	public static int maxXY(int x, int y) {
		
		if (x > y) 
			result = x;
		else {
			result = y;
		}
		return result;		
	}
	
	public static int maxABCD (int a, int b, int c, int d){
		if (maxXY(a,b) > maxXY(c,d)) 
			result = maxXY(a,b);		
		else result = maxXY(c,d);
		return result;		
	}
}
