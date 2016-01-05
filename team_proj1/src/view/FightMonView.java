package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.FightMonControl;
import entity.AllChar;
import entity.MyJFrame;

public class FightMonView implements Runnable{
	MyJFrame mJfr;
	FightMonControl fightMonControl;
	 int selectMenu;
	 AllChar mon;
	 AllChar myCh;
	 int Jfr_Xsize;
	 int  Jfr_Ysize;
	 int Jfr_Xlo;
	 int Jfr_Ylo;
	 int myX;
	 int myY;
	 int motion=1;
	 boolean motion_ok=false;
	 int mmotion=1;
	 ImageIcon icon1;
	ImageIcon icon2;
	final ImageIcon icon3 = new ImageIcon(".\\img\\fightmon.png");
	ImageIcon icon4 = new ImageIcon(".\\img\\meetmon.jpg");
	final ImageIcon icon5 = new ImageIcon(".\\img\\attack.png");
	
	public FightMonView(AllChar myC, AllChar mo, MyJFrame mJf, 
			int Jfr_Xsiz, int  Jfr_Ysiz,int Jfr_Xl, int Jfr_Yl,int mX,int mY)
	{
		selectMenu=1;
		this.myCh=myC;
		this.mon=mo;
		this.mJfr=mJf;
		this.Jfr_Xsize=Jfr_Xsiz;
		this.Jfr_Ysize=Jfr_Ysiz;
		this.Jfr_Xlo=Jfr_Xl;
		this.Jfr_Ylo=Jfr_Yl;
		this.myX=mX;
		this.myY=mY;
		
		mJfr.getJfr().remove(mJfr.getJpn1());
		mJfr.getJfr().remove(mJfr.getJpn2());
		mJfr.getJfr().remove(mJfr.getJpn3());
		mJfr.getJfr().remove(mJfr.getJpn4());
		
		icon1 = new ImageIcon(".\\img\\apeach.png");
		icon2 = new ImageIcon(".\\img\\mushroom.PNG");
		mJfr.setJlb1(new JLabel());
		mJfr.setJlb2(new JLabel());
		mJfr.setJlb3(new JLabel());
		mJfr.setJlb4(new JLabel());
		mJfr.setJpn1(new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(icon1.getImage(), 0, 0, Jfr_Xsize/2-150, Jfr_Ysize/2-50, null);
			}
		});
		mJfr.setJpn2(new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(), 0, 0, Jfr_Xsize/2-200, Jfr_Ysize/2-100, null);
			}
		});
		mJfr.setJpn3( new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
                g.drawImage(icon3.getImage(), 0, 0, Jfr_Xsize/2-150, Jfr_Ysize/2-100, null);
             
                if(selectMenu==1)
                {
                	g.drawRect(10, 0, Jfr_Xsize/2-160, Jfr_Ysize/10-10); 
                }
                else if(selectMenu==2)
                {
                	g.drawRect(10, 50, Jfr_Xsize/2-160, Jfr_Ysize/10-10); 
                }
                else if(selectMenu==3)
                {
                	g.drawRect(10, 100, Jfr_Xsize/2-160, Jfr_Ysize/10-10); 
                }
                
              } 
        });
		mJfr.setJpn4(new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 9166120552525119084L;

			public void paintComponent(Graphics g) {
                g.drawImage(icon4.getImage(), 0, 0, Jfr_Xsize, Jfr_Ysize, null);
               
               } 
        });
		mJfr.setJpn5(new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 9166120552525119084L;

			public void paintComponent(Graphics g) {
                g.drawImage(icon5.getImage(), 0, 0, 150, 100, null);
               
               } 
        });
		mJfr.getJlb1().setText(myCh.getName()+" Lv."+myCh.getLevel());
		mJfr.getJlb2().setText(" 체력: "+myCh.getNHp()+"/"+myCh.getHp()+
				" 마력: "+myCh.getNMp()+"/"+myCh.getMp()+
				" 공격력: "+myCh.getAttack() +" 경험치: "+myCh.getNexe()+"/"+myCh.getMexe());
		mJfr.getJlb3().setText("몬스터 Lv."+mon.getLevel());
		mJfr.getJlb4().setText(" 체력: "+mon.getNHp()+"/"+mon.getHp()+" 공격력: "+mon.getAttack());
		
		mJfr.getJlb1().setBounds(110, 160, 300, 30);
		mJfr.getJlb2().setBounds(20, 380, 300, 30);
		
		mJfr.getJlb3().setBounds(Jfr_Xsize*3/4-20, 10, 200, 30);
		mJfr.getJlb4().setBounds(Jfr_Xsize*3/4-40, 220, 200, 30);
		
		mJfr.getJlb1().setBackground(Color.white);
		mJfr.getJlb2().setBackground(Color.white);
		mJfr.getJlb3().setBackground(Color.white);
		mJfr.getJlb4().setBackground(Color.white);
		
		
		mJfr.getJpn4().setBounds(0, 0, Jfr_Xsize, Jfr_Ysize);
		mJfr.getJpn4().setLayout(new BorderLayout());
		mJfr.getJpn4().setBackground(Color.white);
		mJfr.getJfr().add(mJfr.getJpn4());
		
		mJfr.getJpn1().setBounds(30, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
		mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
		mJfr.getJpn3().setBounds(300, Jfr_Ysize/2+50, Jfr_Xsize-100, Jfr_Ysize/2-50);
		mJfr.getJpn3().setLayout(new BorderLayout());
		if(myCh.getName().equals("어피치"))
		{
			mJfr.getJpn1().setBackground(Color.red);
		}
		else if(myCh.getName().equals("무지"))
		{
			mJfr.getJpn1().setBackground(Color.green);
		}
		else if(myCh.getName().equals("튜브"))
		{
			mJfr.getJpn1().setBackground(Color.blue);
		}else
		{
			System.out.println("캐릭터 오류");
		}
		mJfr.getJpn3().setBackground(Color.white);
		
		
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false);
		
		fightMonControl= new FightMonControl(myCh,mon, mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo,myX,myY);
		mJfr.getJfr().addKeyListener(fightMonControl); 
		Thread t = new Thread(this);
	    t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mJfr.getJfr().remove(mJfr.getJpn4());
		mJfr.getJfr().add(mJfr.getJpn1());
		mJfr.getJfr().add(mJfr.getJpn2());
		mJfr.getJfr().add(mJfr.getJpn3());
		mJfr.getJfr().add(mJfr.getJpn5());
		mJfr.getJfr().add(mJfr.getJlb1());
		mJfr.getJfr().add(mJfr.getJlb2());
		mJfr.getJfr().add(mJfr.getJlb3());
		mJfr.getJfr().add(mJfr.getJlb4());


		
		mJfr.getJfr().repaint();
		while(fightMonControl.end()!=true)
		{
			if(myCh.getNHp()<=0)
			{
				break;
			}
			if(mon.getNHp()<=0)
			{
				fightMonControl.monKill(myCh,mon);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJfr().remove(mJfr.getJpn3());
				mJfr.getJfr().remove(mJfr.getJpn4());
				mJfr.getJfr().remove(mJfr.getJpn5());
				mJfr.getJfr().remove(mJfr.getJlb1());
				mJfr.getJfr().remove(mJfr.getJlb2());
				mJfr.getJfr().remove(mJfr.getJlb3());
				mJfr.getJfr().remove(mJfr.getJlb4());
				new GameView(myCh, mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo,myX,myY);
				break;
			}
			mJfr.getJlb1().setText(myCh.getName()+" Lv."+myCh.getLevel());
			mJfr.getJlb2().setText(" 체력: "+myCh.getNHp()+"/"+myCh.getHp()+
					" 마력: "+myCh.getNMp()+"/"+myCh.getMp()+
					" 공격력: "+myCh.getAttack() +" 경험치: "+myCh.getNexe()+"/"+myCh.getMexe());
			mJfr.getJlb3().setText("몬스터 Lv."+mon.getLevel());
			mJfr.getJlb4().setText(" 체력: "+mon.getNHp()+"/"+mon.getHp()+" 공격력: "+mon.getAttack());
			icon4 = new ImageIcon(".\\img\\background2.jpg");
			mJfr.getJpn4().setBounds(0, 0, Jfr_Xsize, Jfr_Ysize);
			mJfr.getJfr().add(mJfr.getJpn4());
			mJfr.getJfr().repaint();
			if(fightMonControl.ismove())
			{
				selectMenu=fightMonControl.moveSelect(selectMenu);
				
				
				fightMonControl.wasmoved();
				
			}if(myCh.getIsskill()!=true)
			{
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(myCh.getNHp()>0&&mon.getNHp()>0&&myCh.getIsattack()==true)
			{
				
				mJfr.getJfr().add(mJfr.getJpn5());
				mJfr.getJpn5().setBounds(100, 50, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
				motion++;
				if(motion==2)
				{
					icon1 = new ImageIcon(".\\img\\apeachA2.png");
				}
				else if(motion==3)
				{
					icon1 = new ImageIcon(".\\img\\apeachA1.png");
				}
				else if(motion==4)
				{
					icon1 = new ImageIcon(".\\img\\apeachA2.png");
				}
				else if(motion==5)
				{
					icon1 = new ImageIcon(".\\img\\apeach.png");
				}
				else if(motion>5)
				{
					motion_ok=true;
					mJfr.getJfr().remove(mJfr.getJpn5());
				}
				if(motion_ok)
				{
					mmotion++;
					if(mmotion==2)
					{
						mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-70, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==3)
					{

						mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-90, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==4)
					{

						mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-70, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==5)
					{
						mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
						
					}
					else
					{
						motion=1;
						mmotion=1;
						motion_ok=false;
						fightMonControl.ourturn();
						myCh.setIsattack(false);
						mon.setIsattack(true);
					}
				}
				
				
				
			}
			
			if(mon.getNHp()>0&&myCh.getNHp()>0&&mon.getIsattack()==true)
			{
				mJfr.getJfr().add(mJfr.getJpn5());
				mJfr.getJpn5().setBounds(600, 270, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
				
				System.out.println(motion);
				if(motion==2)
				{
					mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 30, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroomA.jpg");
				}
				else if(motion==3)
				{
					mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroom.png");
				}
				else if(motion==4)
				{
					mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 30, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroomA.jpg");
				}
				else if(motion==5)
				{
					mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroom.png");
				}
				else if(motion>5)
				{
					motion_ok=true;
					mJfr.getJfr().remove(mJfr.getJpn5());
				}
				if(motion_ok)
				{
					mmotion++;
					if(mmotion==2)
					{
						mJfr.getJpn1().setBounds(20, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==3)
					{

						mJfr.getJpn1().setBounds(40, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==4)
					{

						mJfr.getJpn1().setBounds(20, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==5)
					{
						mJfr.getJpn1().setBounds(30, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
						
					}
					else
					{
						motion=1;
						mmotion=1;
						motion_ok=false;
						fightMonControl.monturn();
						mon.setIsattack(false);
						myCh.setIsattack(false);
						fightMonControl.turnoff(true);
					}
				}
				
			}
			if(myCh.getNHp()>0&&mon.getNHp()>0&&myCh.getNMp()>=10&&myCh.getIsskill()==true)
			{
	
				System.out.println(motion);
				myCh.setNMp(myCh.getNMp()-10);
				mJfr.getJfr().add(mJfr.getJpn5());
				mJfr.getJpn5().setBounds(100, 50, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
				motion++;
				if(motion==2)
				{
					icon1 = new ImageIcon(".\\img\\apeachA2.png");
				}
				else if(motion==3)
				{
					icon1 = new ImageIcon(".\\img\\apeachA1.png");
				}
				else if(motion==4)
				{
					icon1 = new ImageIcon(".\\img\\apeachA2.png");
				}
				else if(motion==5)
				{
					icon1 = new ImageIcon(".\\img\\apeachA1.png");
				}
				else if(motion==6)
				{
					icon1 = new ImageIcon(".\\img\\apeachA2.png");
				}
				else if(motion==7)
				{
					icon1 = new ImageIcon(".\\img\\apeachA1.png");
				}
				else if(motion==8)
				{
					icon1 = new ImageIcon(".\\img\\apeachA2.png");
				}
				else if(motion==9)
				{
					icon1 = new ImageIcon(".\\img\\apeachA1.png");
				}
				else if(motion==10)
				{
					icon1 = new ImageIcon(".\\img\\apeach.png");
				}
				
				else if(motion>10)
				{
					motion_ok=true;
					mJfr.getJfr().remove(mJfr.getJpn5());
				}
				if(motion_ok)
				{
					
					mmotion++;
					if(mmotion==2)
					{
						mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-70, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==3)
					{

						mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-90, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==4)
					{

						mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-70, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==5)
					{
						mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
						
					}
					else
					{
						motion=1;
						mmotion=1;
						motion_ok=false;
						fightMonControl.ourturn();
						myCh.setIsskill(false);
						mon.setIsattack(true);
					}
				}
				
				
				
			}
			if(mon.getNHp()>0&&myCh.getNHp()>0&&mon.getIsattack()==true)
			{
				mJfr.getJfr().add(mJfr.getJpn5());
				mJfr.getJpn5().setBounds(600, 270, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
				motion++;
				if(motion==2)
				{
					mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 30, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroomA.jpg");
				}
				else if(motion==3)
				{
					mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroom.png");
				}
				else if(motion==4)
				{
					mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 30, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroomA.jpg");
				}
				else if(motion==5)
				{
					mJfr.getJpn2().setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroom.png");
				}
				else if(motion>5)
				{
					motion_ok=true;
					mJfr.getJfr().remove(mJfr.getJpn5());
				}
				if(motion_ok)
				{
					mmotion++;
					if(mmotion==2)
					{
						mJfr.getJpn1().setBounds(20, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==3)
					{

						mJfr.getJpn1().setBounds(40, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==4)
					{

						mJfr.getJpn1().setBounds(20, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==5)
					{
						mJfr.getJpn1().setBounds(30, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
						
					}
					else
					{
						motion=1;
						mmotion=1;
						motion_ok=false;
						fightMonControl.monturn();
						mon.setIsattack(false);
						myCh.setIsattack(false);
						fightMonControl.turnoff(true);
					}
				}
				
				
			}
			
			
			
		}
		
		
		
	
		
	}

}
