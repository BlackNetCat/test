package d05;

abstract class Character {
	WeaponBehavior weapon;
	
	public void useWeapon() {
		weapon.useWeapon();
	}
	abstract void fight();
	
	void setWeapon (WeaponBehavior w) {
		this.weapon = w;
	}
	
}

interface WeaponBehavior {
	void useWeapon();
}


class AxeBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("взял топор");
	}
}

class KnifeBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("взял нож");
	}
}

class BowAndArrowBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("взял лук и стрелы");
	}
}

class SwordBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("взял меч");
	}
}

class King extends Character {
	
	public King() {
		weapon = new AxeBehavior();
	}

	@Override
	void fight() {
		System.out.println("Король начал бой");
				
	}
	
}

class Queen extends Character {
	
	public Queen() {
		weapon = new KnifeBehavior();
	}

	@Override
	void fight() {
		System.out.println("Королева начала бой");
				
	}
	
}

class Knight extends Character {
	
	public Knight() {
		weapon = new SwordBehavior();
	}

	@Override
	void fight() {
		System.out.println("Рыцарь начал бой");
				
	}
	
}

class Troll extends Character {
	
	public Troll() {
		weapon = new BowAndArrowBehavior();
	}

	@Override
	void fight() {
		System.out.println("Троль начал бой");
				
	}
	
}

public class Fighter {
	
	
	public static void main(String[] args) {
		King k1 = new King();
		k1.getClass();
		k1.useWeapon();
		k1.fight();
		k1.setWeapon(new KnifeBehavior());
		k1.useWeapon();
		k1.fight();

	}

}
