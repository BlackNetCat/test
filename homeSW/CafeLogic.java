package homeSW;

abstract class Beverage {
	String description = "Unknown Beverage";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
	
}

class Espresso extends Beverage {
	
	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		
		return 2;
	}
	
}

class HouseBlend extends Beverage {
	
	public HouseBlend() {
		description = "House Blend";
	}

	@Override
	public double cost() {
		
		return .90;
	}
	
}

class DarkRoast extends Beverage {
	
	public DarkRoast() {
		description = "Dark Roast";
	}

	@Override
	public double cost() {
		
		return 1;
	}
	
}


abstract class CondimentDecorator extends Beverage{

	public abstract String getDescription();
	
}

class Mocha extends CondimentDecorator {

	Beverage beverage;
	
	public Mocha (Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		
		return beverage.getDescription() + ", Mocha";
	}
	
	public double cost(){
		return .2 + beverage.cost();
	}
	
}

class Milk extends CondimentDecorator {

	Beverage beverage;
	
	public Milk (Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		
		return beverage.getDescription() + ", Milk";
	}
	
	public double cost() {
		return .1 + beverage.cost();
	}
	
}

class Whip extends CondimentDecorator {

	Beverage beverage;
	
	public Whip (Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		
		return beverage.getDescription() + ", Whip";
	}
	
	public double cost() {
		return .15 + beverage.cost();
	}
	
}

public class CafeLogic {

	public static void main(String[] args) {
		
		/*Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $ " + beverage.cost()); 
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);       // Decor in object Mocha
		beverage2 = new Mocha(beverage2);       // again
		beverage2 = new Whip(beverage2);        // Decor in object Whip
		System.out.println(beverage2.getDescription() + " $ " + beverage2.cost()); 
		*/
		Beverage est = new Espresso();
		System.out.println(est.getDescription() + " " + est.cost() + " $");
		est = new Mocha(est);
		est = new Milk(est);
		est = new Whip(est);
		System.out.println(est.getDescription() + " " + est.cost() + " $");
		
		Beverage hbt = new HouseBlend();
		System.out.println(hbt.getDescription() + " " + hbt.cost() + " $");
		hbt = new Mocha(hbt);
		System.out.println(hbt.getDescription() + " " + hbt.cost() + " $");
		
		
		
		

	}

}