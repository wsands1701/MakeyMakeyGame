import java.util.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
public class mainProgram extends Applet implements KeyListener{
		int tank1x=100;
		int tank2x=600;
		int tank1y=100;
		int tank2y=100;
		int player1score;
		int player2score;
		

		
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	
	}
	public void init() {
		this.setSize(new Dimension(1000,800));
		addKeyListener(this);
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
	}

	public void paint(Graphics g) 
	{
		g.fillRect(tank1x, tank1y, 50, 50);
		g.fillRect(tank2x, tank2y, 50, 50);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}