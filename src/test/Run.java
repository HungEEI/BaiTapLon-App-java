package test;

import javax.swing.UIManager;

import view.HelloView;

public class Run {

	public static void main(String[] args) {		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new HelloView();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}
	
}