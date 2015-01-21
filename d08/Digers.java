package d08;

import java.util.ArrayList;

public class Digers {	

	static ArrayList<Pit> pits = new ArrayList<Pit>();	
	

	public static void addPit () {
		
		if (Pit.getInstance().checkPit() == true) {		
		
			pits.add(Pit.getInstance());
			System.out.println("Pit  " + pits.get(0).checkPit());
			System.out.println("Pit complete, begin new... ");	
			
			
			
		}
		else {
			 System.out.println("pit is not ready");
		}
		
	}
	
		
	public static void printPit() {		
		
		System.out.println("Overview pits : ");
		System.out.println("-------------------------");
		
		if (pits.size() == 0){
			System.out.println("No pits");
		}
		else {
			for (int i = 0; i < pits.size(); i++) {
				
				System.out.println("Pit # " + i + " " + " = " + pits.get(i).getSizePit());					
				System.out.println("Pit # " + i + " " + " = " + pits.get(i).checkPit());
				System.out.println(pits.get(i).getInstance().toString());
				
				
				}
			
			}
	}		
	
	
	public static void start (Worker worker) {
		
		int countExcavation = 32;
		for (int i = 0; i < countExcavation; i++) {
			worker.toDig(Pit.getInstance());	
			
			System.out.println("Pit's size is : " + Pit.getInstance().getSizePit() + " " + worker.getName());	
			System.out.println("Pit's size is : " + Pit.getInstance().isCompletePit() + " " + worker.getName());	
			
			if (Pit.getInstance().checkPit() == true) {
		
				addPit();			
				
			}				
	
		}		
		
		
	}
	
	public static void main(String[] args) {		
	
		Worker  w1 = new Worker();		
		Worker  w2 = new Worker();	
		Worker  w3 = new Worker();	
		w1.setName("John");
		w2.setName("Tom");
		w3.setName("Clark");
		start(w1);
		
	//	start(w2);
	//	start(w3);
		printPit();
	
	}

}
