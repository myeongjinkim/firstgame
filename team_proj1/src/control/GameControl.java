package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.AllChar;
import entity.Apeach;
import entity.Muji;
import entity.Tube;

public class GameControl implements KeyListener{
		public boolean keyOk = true;
		public enum ECharMType {ELeft,EUp, ERight, EDown}
		ECharMType ecm=null;
		int cx,cy;
		int monX[], monY[];
		public GameControl()
		{
			makeMon();
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(keyOk)
				{
				if(e.getKeyCode()== KeyEvent.VK_LEFT)
				{
					ecm= ECharMType.ELeft;
				}
				else if(e.getKeyCode()== KeyEvent.VK_UP)
				{
					ecm= ECharMType.EUp;
				}
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					ecm= ECharMType.ERight;
				}
				else if(e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					ecm= ECharMType.EDown;
				}
			}
		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		public void maxSize(int Jfr_Xsize, int Jfr_Ysize)
		{
			cx=Jfr_Xsize;
			cy=Jfr_Ysize;
		}
		
		public boolean ismove()
		{
			if(ecm!=null)
			{
				keyOk=false;
				return true;
			}
			else
			{
				return false;
			}
			
		}
		public void wasmoved()
		{
			makeMon();
			keyOk=true;
			ecm=null;
		}
		private void makeMon() {
			// TODO Auto-generated method stub
			monX=new int[10];
			monY=new int[10];
			for(int a=0;a<10;a++)
			{
				monX[a]=((int)(Math.random()*16))*50;
				monY[a]=((int)(Math.random()*10))*50;
			}
		}
		public boolean meetmon(int myCharX, int myCharY){
			for(int a=0;a<10;a++)
			{
				if(monX[a]==myCharX&&monY[a]==myCharY)
				{
					return true;
				}
			}
			return false;
		}
		public void moveChar(AllChar myCh)
		{
			int x = 0,y=0;
			if(myCh.getName().equals("어피치"))
			{
				x= ((Apeach) myCh).getMX();
				y= ((Apeach) myCh).getMY();
						
			}
			else if(myCh.getName().equals("무지"))
			{
				x= ((Muji) myCh).getMX();
				y= ((Muji) myCh).getMY();	 
			}
			else if(myCh.getName().equals("튜브"))
			{
				x= ((Tube) myCh).getMX();
				y= ((Tube) myCh).getMY();	 
			}
				
			
			if(ecm== ECharMType.ELeft)
			{
				if(x>0&&(x!=50||y!=0))
				{
					setXY(myCh,x-10,y);
				}
			}
			else if(ecm== ECharMType.EUp)
			{
				if(y>0&&(x!=0||y!=50))
				{
					setXY(myCh,x,y-10);
				}
			}
			else if(ecm== ECharMType.ERight)
			{
				if(x<cx-100)
				{
					setXY(myCh,x+10,y);
				}
			}
			else if(ecm== ECharMType.EDown)
			{
				if(y<cy-100)
				{
					setXY(myCh,x,y+10);
				}
			}
		}
		public AllChar setMon(AllChar myCh) {
			// TODO Auto-generated method stub
			int level=0;
			if(myCh.getLevel()>=4)
			{
				level = (int) (Math.random()*7+myCh.getLevel()-3);
			}
			else
			{
				level = myCh.getLevel();
			}
			AllChar mon = new AllChar();
			mon.setLevel(level);
			return mon;
			
		}
		public void setXY(AllChar myCh,int x,int y)
		{
			if(myCh.getName().equals("어피치"))
			{
				 ((Apeach) myCh).setMX(x);
				 ((Apeach) myCh).setMY(y);
			}
			 else if(myCh.getName().equals("무지"))
			{
				 ((Muji) myCh).setMX(x);
				 ((Muji) myCh).setMY(y);
			}
			 else if(myCh.getName().equals("튜브"))
			 {
				 ((Tube) myCh).setMX(x);
				 ((Tube) myCh).setMY(y);
			}
		}
		
	
}

