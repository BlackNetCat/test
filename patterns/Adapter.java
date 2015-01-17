package patterns;

interface Duck {
	public void quack();
	public void fly();
}

interface Turkey {
	public void gobble();
	public void fly();
}

class MallardDuck implements Duck {
	public void quack() {
		System.out.println("Quack");
	}

	@Override
	public void fly() {
		System.out.println("I'm flying");
		
	}
}

class WildTurkey implements Turkey {

	@Override
	public void gobble() {
		System.out.println("Gobble gobble");
		
	}

	@Override
	public void fly() {
		System.out.println("I'm flying a short distance");
		
	}
	
}

class TurkeyAdapter implements Duck {
	
	Turkey turkey;
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
		
	}

	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
		
	}
}


public class Adapter {
	
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
	

	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("The Turkey says ....");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\n The Duck says...");
		testDuck(duck);
		
		System.out.println("\n The TurkeyAdapter says ...");
		testDuck(turkeyAdapter);

	}

}