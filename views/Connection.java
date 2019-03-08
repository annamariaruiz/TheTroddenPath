package views;

import models.Wheel;

public class Connection {
	
	public int spinWheel() {
		int spunNumber = Wheel.spinWheel();
		return spunNumber;
		//animation to move that many spaces
		
	}
	
	public void sellFamily() {
		controllers.Controller.checkForFam();
	}
	
	public void giveUp() {
		controllers.Controller.giveUp();
	}
}
