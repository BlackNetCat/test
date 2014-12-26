
public class Student {
	
	public int id;
	private String surname;
	private String name;
	private int numberGroup;
	private int[] progress;
	
	//public Student(int i, String string, String string2, int j, int k, int l,
	//		int m, int n, int o) {
		
	//}


	public Student(int id, String surname, String name, int numberGroup, int k, int l,
					int m, int n, int o ) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.numberGroup = numberGroup;
		this.progress = progress;
	}




	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public int getNumberGroup() {
		return numberGroup;
	}
	public void setNumberGroup(short numberGroup) {
		this.numberGroup = numberGroup;
	}
	public int[] getProgress() {
		return progress;
	}
	public void setProgress(int[] progress) {
		this.progress = progress;
	}
	
	public void show() {
		System.out.println("id: " + getId());
		System.out.println("surname: " + getSurname());
		System.out.println("name: " + getName());
		System.out.println("numberGroup: " + getNumberGroup());
		System.out.println("progress: " + getProgress());
	}

	

}
