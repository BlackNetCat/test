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
		System.out.println("���� �����");
	}
}

class KnifeBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("���� ���");
	}
}

class BowAndArrowBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("���� ��� � ������");
	}
}

class SwordBehavior implements WeaponBehavior {
	public void useWeapon() {
		System.out.println("���� ���");
	}
}

class King extends Character {
	
	public King() {
		weapon = new AxeBehavior();
	}

	@Override
	void fight() {
		System.out.println("������ ����� ���");
				
	}
	
}

class Queen extends Character {
	
	public Queen() {
		weapon = new KnifeBehavior();
	}

	@Override
	void fight() {
		System.out.println("�������� ������ ���");
				
	}
	
}

class Knight extends Character {
	
	public Knight() {
		weapon = new SwordBehavior();
	}

	@Override
	void fight() {
		System.out.println("������ ����� ���");
				
	}
	
}

class Troll extends Character {
	
	public Troll() {
		weapon = new BowAndArrowBehavior();
	}

	@Override
	void fight() {
		System.out.println("����� ����� ���");
				
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
