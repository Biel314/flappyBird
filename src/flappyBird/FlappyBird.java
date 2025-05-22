package flappyBird;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class FlappyBird extends JPanel implements ActionListener, KeyListener{
	 int boardWidth = 360;
	 int boardHeigth = 640;
	 
	 
	 Image backgroundImg;
	 Image birdImg;
	 Image topPipeImg;
	 Image bottomPipeImg;
	 
	 int birdX = boardWidth/8;
	 int birdY = boardHeigth/2;
	 int birdWidth = 34;
	 int birdHeigth = 24;
	 
	 class Bird{
		 int x = birdX;
		 int y = birdY;
		 int width = birdWidth;
		 int heigth = birdHeigth;
		 Image img;
		 
		 Bird(Image img){
			 this.img = img;
		 }
	 }
	 
	 //lgc do jogo
	 Bird bird;
	 int velocityY = -9;
	 int gravity = 1;
	 
	 Timer gameLoop;
	 
	 FlappyBird(){
		 setPreferredSize(new Dimension(boardWidth, boardHeigth));
		 //setBackground(Color.blue);
		 
		 setFocusable(true);
		 addKeyListener(this);
		 
		 backgroundImg = new ImageIcon(getClass().getResource("flappybirdbg.png")).getImage();
		 birdImg = new ImageIcon(getClass().getResource("flappybird.png")).getImage();
		 topPipeImg = new ImageIcon(getClass().getResource("toppipe.png")).getImage();
		 bottomPipeImg = new ImageIcon(getClass().getResource("bottompipe.png")).getImage();
		 
		 bird = new Bird(birdImg);
		 
		 gameLoop = new Timer(1000/60, this);
		 gameLoop.start();
	 }
	 
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 draw(g);
	 }
	 
	 public void draw(Graphics g) {
		 System.out.println("Draw");
		 //fundo
		 g.drawImage(backgroundImg, 0 ,0, boardWidth, boardHeigth, null);
		 
		 //Bird
		 g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.heigth, null);
	 }
	 
	 public void move() {
		 //bird
		 velocityY += gravity;
		 bird.y +=velocityY;
		 bird.y = Math.max(bird.y, 0);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			velocityY = -9;
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
}
