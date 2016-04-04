package Zombie;

import javax.swing.JOptionPane;

public class Killer {
	//constructor
	String name,weapon;
	int strength;
	double speed;
	
	public Killer(String name) {
		this.name=name;
		weapon="knife";
		strength=1;
		speed=2.1;
		
	}
	
	public void setWeapon() {
		weapon=(String)JOptionPane.showInputDialog(null, "What's your weapon?");
	}
}
