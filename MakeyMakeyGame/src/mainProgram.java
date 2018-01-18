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
		int tank1x=100;
		int tank2x=600;
		int tank1y=100;
		int tank2y=100;
		int player1score;
		int player2score;
		int b1x=-10;
		int b1y=-10;
		int b2x=-10;
		int b2y=-10;
		boolean t1fired=false;
		boolean t2fired=false;
		boolean t1completed=true;
		boolean t2completed=true;
		Timer t= new Timer(10, this);;

		
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	
	}
	public void init() {
		
		this.setSize(new Dimension(1000,800));
		this.setBackground(java.awt.Color.red);
		addKeyListener(this);
	}
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
		 if(b1x<=1000&&t1fired) {	
		 b1x+=5; 
		 repaint();
		 }
		 if(b1x>1000&&t1fired){
			 b1x=-10;
			 b1y=-10;
			 t1fired=false;
			 t1completed=true;
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
	 if(e.getKeyCode()==KeyEvent.VK_UP) {
		 tank1y-=10;
		 repaint();
	 }
	 if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		 tank1y+=10;
		 repaint();
		
	 }
	 if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		 tank1x+=10;
		 repaint();
		
	 }
	 if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		 tank1x-=10;
		 repaint();
		
	 }
	 if(e.getKeyCode()==KeyEvent.VK_W) {
		 tank2y-=10;
		 repaint();
	 }
	 if(e.getKeyCode()==KeyEvent.VK_S) {
		 tank2y+=10;
		 repaint();
		
	 }
	 if(e.getKeyCode()==KeyEvent.VK_D) {
		 tank2x+=10;
		 repaint();
		
	 }
	 if(e.getKeyCode()==KeyEvent.VK_A) {
		 tank2x-=10;
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
		
		g.fillRect(tank1x, tank1y, 50, 50);
		g.fillRect(tank2x, tank2y, 50, 50);
		g.fillRect(tank1x+50, tank1y+20, 20, 10);
		g.fillRect(tank2x-20, tank2y+20, 20, 10);
		g.fillRect(b1x, b1y, 10, 10);
		g.fillRect(b2x, b2y, 10, 10);
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated methsod stub
	
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}