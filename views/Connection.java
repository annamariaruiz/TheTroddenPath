package views;

import models.Wheel;

public class Connection {
	
	public void spinWheel() {
		int spunNumber = Wheel.spinWheel();
		//animation to move that many spaces
	}
	
	public void sellFamily() {
		controllers.Controller.checkForFam();
	}
	
	public void giveUp() {
		controllers.Controller.giveUp();
	}
}
