
public class FaktorialWhile {

	public static void main(String[] args) {
		
		int input = 5;
        int factorial = 1;
        while (input > 0)
        {
          factorial = factorial * input;
          input--;
        }
        System.out.println("Factorial = " + factorial);
	}

	
}
