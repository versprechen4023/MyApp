package myAPP;

import java.awt.MouseInfo;
import java.awt.PointerInfo;

//마우스위치
public class Mousewhere {

	public static void main(String[] args) {
		
		PointerInfo point = MouseInfo.getPointerInfo();
		
		while(true) {
			
			System.out.println(point.getLocation());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException error) {
				System.out.println("error");
				
			}
			
		}
				
		
	}

}
