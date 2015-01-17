package patterns;

abstract class Ducks {
	
	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;
	
	public Ducks() {
		
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void swim() {
		System.out.println("All ducks float, even decoys");
	}
	
	public abstract void display();
	
	public void setFlyBehavior(FlyBehavior fb) {      // Dynamics change
		flyBehavior = fb;
	}
}


interface QuackBehavior {
	public void quack();
}

interface FlyBehavior {
	public void fly();
}

class FlyWithWings implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying");
	}
}

class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}

class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("Quack");
	}
}

class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("Silence");
	}
}

class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}


class MallardDucks extends Ducks {
	
	public MallardDucks() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	public void display() {
		System.out.println("I'm real Mallard duck");
	}
}


public class Strategy {

	public static void main(String[] args) {
		
		Ducks mallard = new MallardDucks();
		mallard.display();
		mallard.performQuack();
		mallard.performFly();
		mallard.setFlyBehavior(new FlyNoWay());  // Dynamics change state
		mallard.performFly();

	}

}
