import java.util.*;

import com.sun.prism.paint.Color;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.color.*;


public class mainProgram extends Applet implements KeyListener, ActionListener{
		//initialized tank position varibles
		int tank1x=100;
		int tank2x=600;
		int tank1y=100;
		int tank2y=100;
		
		//initialized player score counter
		int player1score=0;
		int player2score=0;
		
		//initalized bullet locations
		int b1x=-10;
		int b1y=-10;
		int b2x=-10;
		int b2y=-10;
		
		//created tank rectangels for colition dectection
		Rectangle tank1;
		Rectangle tank2;
		
		//created bullet rectangles for colition dectection
		Rectangle bullet1;
		Rectangle bullet2;
		
		//created bullet booleans to track if they have been fired, and have completed their path
		boolean t1fired=false;
		boolean t2fired=false;
		boolean t1completed=true;
		boolean t2completed=true;
		
		//created timer for bullet movement
		Timer t= new Timer(10, this);

	public static void main(String[] args) 
	{
	
	}
	public void init() {
		
		//set bacground size, color, and initilzed key listenting
		this.setSize(new Dimension(1000,800));
		this.setBackground(java.awt.Color.red);
		addKeyListener(this);
		
	}
//these 2 methods fire when each of the bullets are fired, starts timer, and sets bullets in the right location
	public void b1fired() {
		b1x=tank1x+10;
		b1y=tank1y+20;
		t1fired=true;
		t.start();
	}
	public void b2fired() {
		b2x=tank2x+10;
		b2y=tank2y+20;
		t2fired=true;
		t.start();
	}
	public void actionPerformed(ActionEvent e) {
		 
		//each timer tick update bullet 1,2 and tank 1,2 locations
		 bullet1 = new Rectangle(b1x, b1y, 10, 10);
		 bullet2 = new Rectangle(b2x, b2y, 10, 10);
		 tank1 = new Rectangle(tank1x, tank1y, 50, 50);
		 tank2 = new Rectangle(tank2x, tank2y, 50, 50);
		 
		 //checks for bullet colitions
		 if(tank2.contains(bullet1)) {
			 player1score++;
			 repaint();
			 b1x=-10;
			 b1y=-10;
			 t1fired=false;
			 t1completed=true;
			 if(!t2fired) {
			 t.stop();
			 } 
		 }
		 if(tank1.contains(bullet2)) {
			 player2score++;
			 repaint();
			 b2x=-10;
			 b2y=-10;
			 t2fired=false;
			 t2completed=true;
			 if(!t1fired) {
			 t.stop();
			 }
		 }
		 
		 //checks to make sure bullet is still in the play range and hasnt already been fired.
		 if(b1x<=1000&&t1fired) {	
		 b1x+=5; 
		 repaint();
		 }
		 if(b1x>1000&&t1fired){
			 b1x=-10;
			 b1y=-10;
			 t1fired=false;
			 t1completed=true;
			 //if bullet 1 is the only one fired, stop the timer
			 if(!t2fired) {
			 t.stop();
			 }
		 }
		
		 if(b2x>=0&&t2fired) {	
		 b2x-=5; 
		 repaint();
		 }
		 if(b2x<0&&t2fired){
			 b2x=-10;
			 b2y=-10;
			 t2fired=false;
			 t2completed=true;
			 if(!t1fired) {
			 t.stop();
			 } 
		 }
	 	 			     }

	public void keyPressed(KeyEvent e) {
		
	//tracks key presses
	if(e.getKeyCode()==KeyEvent.VK_UP) {
		 tank2y-=10; 
		 repaint();
	 }
		
	 if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		 tank2y+=10;
		 repaint();
	 }
	 
	 if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		 tank2x+=10;
		 repaint();	
	 }
	 
	 if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		 tank2x-=10;
		 repaint();
	 }
	 
	 if(e.getKeyCode()==KeyEvent.VK_W) {
		 tank1y-=10;
		 repaint();
	 }
	 
	 if(e.getKeyCode()==KeyEvent.VK_S) {
		 tank1y+=10;
		 repaint();
	 }
	 
	 if(e.getKeyCode()==KeyEvent.VK_D) {
		 tank1x+=10;
		 repaint();
	 }
	 
	 if(e.getKeyCode()==KeyEvent.VK_A) {
		 tank1x-=10;
		 repaint();
	 }
	 
	 if(e.getKeyCode()==KeyEvent.VK_SPACE) {
		 if(t1completed) {
		 b1fired();
		 t1completed=false;
		 }
	 }
	 if(e.getKeyCode()==KeyEvent.VK_L) {
		 if(t2completed) {
		 b2fired();
		 t2completed = false;
		 }
	 }
	}

	public void paint(Graphics g) 
	{
		//draws all sprites to the screen
		g.fillRect(tank1x, tank1y, 50, 50);
		g.fillRect(tank2x, tank2y, 50, 50);
		g.fillRect(tank1x+50, tank1y+20, 20, 10);
		g.fillRect(tank2x-20, tank2y+20, 20, 10);
		g.fillRect(b1x, b1y, 10, 10);
		g.fillRect(b2x, b2y, 10, 10);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g.drawString("Player 1 Score: "+player1score, 0, 20);
		g.drawString("Player 2 Score: "+player2score, 600, 20);
		
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		
	
	}
	
	public void keyTyped(KeyEvent arg0) {
	
		
	}
}