package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.AllChar;
import entity.MyJFrame;
import view.SelectCharView.EChar;

public class FightMonControl implements KeyListener{
	public boolean keyOk = true;
	public enum EKeyType {EUp, EDown, EAttack,ESkill,EExit}
	EKeyType ekt=null;
	int mySelect;
	EChar eChar;
	MyJFrame mJfr;
	int Jfr_Xsize, Jfr_Ysize;
	int Jfr_Xlo, Jfr_Ylo;
	int myX, myY;
	AllChar myCh;
	AllChar mon;
	boolean turn=true;
	boolean end =false;
	public FightMonControl(AllChar myCh,AllChar mon,MyJFrame mJfr, int Jfr_Xsize, int  Jfr_Ysize,
			int Jfr_Xlo, int Jfr_Ylo,int myX,int myY) {
		// TODO Auto-generated constructor stub
		this.myCh=myCh;
		this.mon=mon;
		this.mJfr=mJfr;
		this.Jfr_Xsize=Jfr_Xsize;
		this.Jfr_Ysize=Jfr_Ysize;
		this.Jfr_Xlo=Jfr_Xlo;
		this.Jfr_Ylo=Jfr_Ylo;
		this.myX=myX;
		this.myY=myY;
		mySelect=1;
		
	}
	
	public AllChar getMon() {return mon;}

	public void setMon(AllChar mon) {this.mon = mon;}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(keyOk)
		{
			if(e.getKeyCode()== KeyEvent.VK_UP)
			{
				ekt= EKeyType.EUp;
			}
		
			else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			{
				ekt= EKeyType.EDown;
			}
			else if(e.getKeyCode()==KeyEvent.VK_ENTER&&turn)
			{
				turn=false;
				if(mySelect==1)
				{
					ekt= EKeyType.EAttack;
					myCh.setIsAttack(true);
					keyOk=false;
				}
				else if(mySelect==2)
				{
					ekt= EKeyType.ESkill;
					myCh.setIsSkill(true);
					keyOk=false;
				}
				else if(mySelect==3)
				{
					ekt= EKeyType.EExit;
					end=true;
					keyOk=false;
				}
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
	public boolean ismove()
	{
		if(ekt!=null)
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
		
		keyOk=true;
		ekt=null;
	}
	public int moveSelect(int select)
	{
		
		if(ekt== EKeyType.EUp)
		{
			if(select==1)
			{
				select=3;
			}
			else{
				select--;	
			}
			
		}
		else if(ekt== EKeyType.EDown)
		{
			if(select==3)
			{
				select=1;
			}
			else{
				select++;	
			}
		}
		mySelect=select;
		return select;
		
	}
	public void ourturn()
	{
		mon.attacked(myCh.getAttack());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void monturn()
	{
		myCh.attacked(mon.getAttack());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void monKill(AllChar myCh, AllChar mon)
	{
		if(mon.getNHp()<=0)
		{
			myCh.setNexe(myCh.getNexe()+5);
		}
		if(myCh.getNexe()>=myCh.getMexe())
		{
			myCh.levelUp();
		}
	}
	public void turnoff(boolean a)
	{
		turn =a;
		
	}
	

	public boolean end() {
		// TODO Auto-generated method stub
		return end;
	}
}
