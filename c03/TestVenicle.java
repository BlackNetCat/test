package c03;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

abstract class Vehicle implements Serializable{
	int coorX, coorY;
	int year;
	int price;
	int speed;
	
	
	public int getCoorX() {
		return coorX;
	}
	public void setCoorX(int coorX) {
		this.coorX = coorX;
	}
	public int getCoorY() {
		return coorY;
	}
	public void setCoorY(int coorY) {
		this.coorY = coorY;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	abstract void print();     // метод асбтрактный и птому все птомки должны его реализовать		
	
}

class Car extends Vehicle {
	
	void print(){
		System.out.println("Car");
	}
	
}

class Plane extends Vehicle{
	int passenger;
	int latitude;
	
	
	public int getLatitude() {
		return latitude;
	}


	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}


	public int getPassenger() {
		return passenger;
	}


	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}


	void print() {
		System.out.println("Plane");
	}
	
}

class Ship extends Vehicle {
	
	int passenger;
	int homeDock;
	
	
	public int getPassenger() {
		return passenger;
	}


	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}


	public int getHomeDock() {
		return homeDock;
	}



	public void setHomeDock(int homeDock) {
		this.homeDock = homeDock;
	}



	void print() {
		System.out.println("Ship");
	}
	
}

class BatMobile extends Car {
	
	void print(){
		System.out.println("Bat Mobile");
	}
	
	void jump() {
		System.out.println("I'm Jumped");
		
		}
	void bulletProof() {
		System.out.println("I'm Bullet Proof");
	}
	
	
}

class PhantomMobile extends Car {
	
	void print(){
		System.out.println("Phantom Mobile");
	}
	
	void fly() {
		System.out.println("I can Fly");
		
	}
	
	void swim() {
		System.out.println("I can swim");
		
	}
	
}



public class TestVenicle {
	
	static Scanner reader = new Scanner(System.in);
	
	static int NUM_OF_RANDOM = 10;
	static Vehicle [] masv = new Vehicle[NUM_OF_RANDOM];
	
	
	static Vehicle randVehicle(int r){
	
		Vehicle veh=null;
		switch(r) {
		case 1: 
				veh = new Car();
				veh.setPrice(10000);
				veh.setSpeed(140);
				veh.setYear(2015);
		
		break;
		case 2: veh = new Plane(); 
				veh.setPrice(100000);
				veh.setSpeed(1400);
				veh.setYear(2015);	
				
				if (veh instanceof Plane){
					((Plane) veh).setPassenger(30);      // восходящее преобразование
				}
				
				if (veh instanceof Plane){
					((Plane) veh).setLatitude(2000);     // восходящее преобразование
				}
				
		break;
		case 3: veh = new Ship();
				veh.setPrice(80000);
				veh.setSpeed(60);
				veh.setYear(2015);
				
				if (veh instanceof Ship){
					((Ship) veh).setPassenger(100);      // восходящее преобразование
				}
		break;
		case 4: veh = new BatMobile();
				veh.setPrice(50000);
				veh.setSpeed(240);
				veh.setYear(2015);
		break;
		case 5: veh = new PhantomMobile();
				veh.setPrice(90000);
				veh.setSpeed(200);
				veh.setYear(2015);
		break;
		default: veh = new Car();
		}
		return veh;
	}


	static void addRandomVehicle(int num) {
		
		for (int i = 0; i < masv.length; i++) {
			masv[i]=randVehicle((int) (Math.random()*6));
		}
		
	}

	static void printVehicle() {
		
		for (int i = 0; i < masv.length; i++) {
			
			if (masv[i] != null)  {
				masv[i].print();
				System.out.println("X is " + masv[i].getCoorX() + " ");
				System.out.println("Y is " + masv[i].getCoorY() + " ");
				System.out.println("Price is " + masv[i].getPrice() + " USD");
				System.out.println("Speed is " + masv[i].getSpeed() + " km/h");
				System.out.println("Made in " + masv[i].getYear() + " years");
				if (masv[i] instanceof Plane) {     // rtti преобразование типа во время выполнения программы
					System.out.println("Latitude is " + (((Plane) masv[i]).getLatitude()) + " km above the earth"); // нисходящее преобразование 
				}
				if (masv[i] instanceof Plane) {     // rtti преобразование типа во время выполнения программы
					System.out.println("Passenger is " + (((Plane) masv[i]).getPassenger()) + " ");   // нисходящее преобразование 
				}
				
				if (masv[i] instanceof Ship) {      // rtti преобразование типа во время выполнения программы
					System.out.println("Passengers is " + (((Ship) masv[i]).getPassenger()) + " ");    // нисходящее преобразование 
				}
				
				if (masv[i] instanceof BatMobile) {
					System.out.println("----------");
					((BatMobile)masv[i]).bulletProof();
					System.out.println("----------");
				} 
				
				if (masv[i] instanceof BatMobile) {
					System.out.println("----------");
					((BatMobile)masv[i]).jump();
					System.out.println("----------");
				} 
				
				if (masv[i] instanceof PhantomMobile) {
					System.out.println("----------");
					((PhantomMobile)masv[i]).fly();
					System.out.println("----------");
				} 
				if (masv[i] instanceof PhantomMobile) {
					System.out.println("----------");
					((PhantomMobile)masv[i]).swim();
					System.out.println("----------");
				} 
				System.out.println("*************");
				
			}	
			else {
				System.out.println("No to view");				
			}
		}
		
		
	}

	static void moveVehicle (){
		System.out.println("select Vehicle for edit [0-9]");
		int s = reader.nextInt();
	
		System.out.println("Input coordinate X");
		int x = reader.nextInt();
		masv[s].setCoorX(x);
		
		System.out.println("Input coordinate Y");
		int y = reader.nextInt();
		masv[s].setCoorY(y);
		
		System.out.println("Coordinate changed");
		
	}
 
	public static void printMenu() {
		System.out.println("Menu, press key : 0-Exit, 1-add random Vehicle, 2-print Vehicle,\n"
			+ "3-move Vehicle, 4-Save, 5-Load ");	
	}

	 public static void serialData() throws IOException {
		 
		  FileOutputStream fos = new FileOutputStream("D://pro/a.txt");
		  ObjectOutputStream oos = new ObjectOutputStream(fos);
	
		  Vehicle ts = new Car();
		  
		  ts = masv[0];
		  oos.writeObject(ts);
		  oos.flush();
		  oos.close();
		 
	 } 
	 
	 static void deserialData() throws IOException, ClassNotFoundException {
		 FileInputStream fis = new FileInputStream("D://pro/a.txt");
		  ObjectInputStream oin = new ObjectInputStream(fis);
	
		  Vehicle ts = (Vehicle) oin.readObject();
		  
		
			  System.out.println("Coordinate X = "+ ts.getCoorX());
			  System.out.println("Coordinate Y = "+ ts.getCoorY());
			  System.out.println("Price = "+ ts.getPrice());
			  System.out.println("Spedd = "+ ts.getSpeed());
			  System.out.println("Year = "+ ts.getYear());
			  System.out.println("*************************");
	
		
	 }
	 
	static void menu () throws IOException, ClassNotFoundException {
			
			while (reader.hasNextInt()){
				int typing = reader.nextInt();
				switch (typing){ 
				case 0:
					System.out.println("Exit");
				break;
				case 1: {
					addRandomVehicle(NUM_OF_RANDOM);			
					System.out.println("Random Vehicle Create");	
					printMenu();
			        }
				break; 
				case 2: {
					printVehicle();
					System.out.println("Print Vehicle complete");	
					printMenu();
					}
				break; 
				case 3: 
					moveVehicle();
					System.out.println("Car added");
					printMenu();
					
				break; 
				case 4: 		
					serialData();		
//					writeFile();		
					printMenu();
				break; 
				case 5: 	
					deserialData();
//					readFile();		
					printMenu();
				break; 
				
				default: System.out.println("No such choice");
				printMenu();
				}
			
			}
		}	

	
	/*static void writeFile() throws IOException {			
	
		String pArray[] = { "2015 ", "2016"  };
		
	
		File fsymb = new File("D://pro/a.txt");
	
		FileWriter fw = null;
		try {
	
			fw = new FileWriter(fsymb);
			
			for (String a : pArray) {
	
			fw.write(a);
			}
			} catch (IOException e) {
			System.err.println("ошибка записи: " + e);
			} finally {
			try {
	
			if (fw != null) {
			fw.close();
			}
			} catch (IOException e) {
			System.err.println("ошибка закрытия потока: " + e);
			}
			}
			
		}
	
	static void readFile () {
		String file = "D://pro/a.txt";
			File f = new File(file); // объект для связи с файлом на диске
				int b, count = 0;
			FileReader is = null;     // FileInputStream is = null; // альтернатива
		
		try {
			is = new FileReader(f);    // is = new FileInputStream(f);
			
		while ((b = is.read()) != -1) {   // чтение
			System.out.print((char) b);
			count++;
		}
			System.out.print("\n число байт = " + count + "\n");
		} catch (IOException e) {
			System.err.println("Ошибка файла: " + e );
		} finally {
			try {
				if (is != null) {
				is.close(); // закрытие потока ввода
		}
		} catch (IOException e) {
			System.err.println("ошибка закрытия: " + e);
		}
		}
		
	}*/


	public static void main(String[] args) throws IOException, ClassNotFoundException {
				
		printMenu();
		menu();			
		
		

	}

}