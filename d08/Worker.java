package d08;

public class Worker {
	int excavation = 1;
	String name;
	
		
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void toDig(Pit pit) {
	
		pit.setSizePit(Pit.getSizePit() + excavation);	
		
	}
}
