import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StudentManager {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Student[] std = new Student[3];
		
		std[0]= new Student(1, "Ivanov", "Ivan", 1, 5, 5, 5, 4, 5);
		std[1]= new Student(2, "Petrov", "Petr", 1, 4, 4, 4, 3, 4);
		std[2]= new Student(3, "Sidorov", "Sidr", 2, 3, 3, 3, 2, 3);
		
		
		
	//	for(int i = 0; i < std.length; i++){
	//		std[i].show();
	//		}
		
		 BufferedReader d = new BufferedReader(new InputStreamReader(System.in));

	//        System.out.println("задай длинну массива Student");
	//            String[] std = new String[Integer.parseInt(d.readLine())];

	        System.out.println("Ок! А теперь, заполни его.");

	        for(int i = 0; i < std.length; i++) {
	            System.out.print("Индекс № " + i + ": ");
	//          std[i]= new String[Integer.parseInt(d.readLine())];
	      //      std[i].id = d.readLine();
	     //       std[i].surname = d.readLine();
	        }

	        System.out.println("\n введи индекс массива, чтобы увидеть его значение (=");
	            int n = Integer.parseInt(d.readLine());

	        System.out.print(std[n]);
	}

}
