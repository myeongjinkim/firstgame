package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.GameView;
import view.SelectCharView.EChar;
import entity.AllChar;
import entity.MyJFrame;

public class FightMonControl implements KeyListener{
	public boolean keyOk = true;
	public enum EAttackType {EUp, EDown, EEnter1,EEnter2,EEnter3}
	EAttackType eat=null;
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
				eat= EAttackType.EUp;
			}
		
			else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			{
				eat= EAttackType.EDown;
			}
			else if(e.getKeyCode()==KeyEvent.VK_ENTER&&turn)
			{
				turn=false;
				if(mySelect==1)
				{
					myCh.setIsattack(true);
					eat= EAttackType.EEnter1;
					keyOk=false;
				}
				else if(mySelect==2)
				{
					myCh.setIsskill(true);
					eat= EAttackType.EEnter2;
					keyOk=false;
				}
				else if(mySelect==3)
				{
					eat= EAttackType.EEnter3;
					mJfr.getJfr().remove(mJfr.getJpn1());
					mJfr.getJfr().remove(mJfr.getJpn2());
					mJfr.getJfr().remove(mJfr.getJpn3());
					mJfr.getJfr().remove(mJfr.getJpn4());
					mJfr.getJfr().remove(mJfr.getJlb1());
					mJfr.getJfr().remove(mJfr.getJlb2());
					mJfr.getJfr().remove(mJfr.getJlb3());
					mJfr.getJfr().remove(mJfr.getJlb4());
					mon.setNHp(mon.getHp());
					end=true;
					new GameView(myCh, mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo,myX,myY);
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
		if(eat!=null)
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
		eat=null;
	}
	public int moveSelect(int select)
	{
		
		if(eat== EAttackType.EUp)
		{
			if(select==1)
			{
				select=3;
			}
			else{
				select--;	
			}
			
		}
		else if(eat== EAttackType.EDown)
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
