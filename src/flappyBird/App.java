package flappyBird;

import javax.swing.*;

public class App {

	public static void main(String[] args) {
		int boardWidth = 360;
		int boardHeigth = 640;
		
		JFrame frame = new JFrame("Flappy bird");
		frame.setVisible(true);
		frame.setSize(boardWidth,boardHeigth);
		frame.setLocationRelativeTo(null); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
