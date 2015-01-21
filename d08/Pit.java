package d08;

public class Pit {
	private static Pit uniqueInstance;
	
	private static boolean completePit;
	private static int sizePit;
	
	private Pit(){
		completePit = false;
		sizePit = 0;
	}
	
	
	
	public boolean isCompletePit() {
		return completePit;
	}
	
	public void setCompletePit(boolean completePit) {
		Pit.completePit = completePit;
	}


	public static Pit getInstance() {
		
	//	if ((uniqueInstance == null)) {		
		if ((uniqueInstance == null) || (sizePit >= 11)) {		
	//	if ((uniqueInstance == null) || (checkPit() == true)) {	
			uniqueInstance = new Pit();
		}
		return uniqueInstance;
	}
	
	public void setSizePit(int sizePit) {
		Pit.sizePit = sizePit;
	}

	public static int getSizePit() {
		return sizePit;
	}
	
		
	public boolean checkPit() {
		
		if (sizePit >= 10) {			
			completePit = true;		
		
		}
		else 
			completePit = false;
		
		return completePit;
	}	
	
}