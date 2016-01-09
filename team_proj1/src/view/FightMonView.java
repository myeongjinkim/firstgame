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

public class FightMonView{
	
	FightMonControl fightMonControl;
	 int selectMenu=1;
	 int motion=1;
	 boolean motion_ok=false;
	 boolean first =true;
	 int mmotion=1;
	 ImageIcon icon1;
	ImageIcon icon2;
	final ImageIcon icon3 = new ImageIcon(".\\img\\fightMenu.png");
	ImageIcon icon4 = new ImageIcon(".\\img\\meetmon.jpg");
	final ImageIcon icon5 = new ImageIcon(".\\img\\attack.png");
	ImageIcon icon6 = new ImageIcon(".\\img\\victory.png");
	
	public FightMonView(AllChar myCh, AllChar mon, MyJFrame mJfr, 
			int Jfr_Xsize, int  Jfr_Ysize,int Jfr_Xlo, int Jfr_Ylo,int myX,int myY)
	{
		
		
		
		
		
		icon1 = new ImageIcon(".\\img\\apeach.png");
		icon2 = new ImageIcon(".\\img\\mushroom.PNG");
		JLabel Jlb1=new JLabel();
		JLabel Jlb2=new JLabel();
		JLabel Jlb3=new JLabel();
		JLabel Jlb4=new JLabel();
		JPanel Jpn1=new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(icon1.getImage(), 0, 0, Jfr_Xsize/2-150, Jfr_Ysize/2-50, null);
				
			}
		};
		JPanel Jpn2=new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(), 0, 0, Jfr_Xsize/2-200, Jfr_Ysize/2-100, null);
			}
		};
		JPanel Jpn3=new JPanel(){
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
        };
        JPanel Jpn4=new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 9166120552525119084L;

			public void paintComponent(Graphics g) {
				
					g.drawImage(icon4.getImage(), 0, 0, Jfr_Xsize, Jfr_Ysize, null);
				
               } 
        };
        JPanel Jpn5=new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 9166120552525119084L;

			public void paintComponent(Graphics g) {
                g.drawImage(icon5.getImage(), 0, 0, 150, 100, null);
               
               } 
        };
		Jlb1.setText(myCh.getName()+" Lv."+myCh.getLevel());
		Jlb2.setText(" 체력: "+myCh.getNHp()+"/"+myCh.getHp()+
				" 마력: "+myCh.getNMp()+"/"+myCh.getMp()+
				" 공격력: "+myCh.getAttack() +" 경험치: "+myCh.getNexe()+"/"+myCh.getMexe());
		Jlb3.setText("몬스터 Lv."+mon.getLevel());
		Jlb4.setText(" 체력: "+mon.getNHp()+"/"+mon.getHp()+" 공격력: "+mon.getAttack());
		
		Jlb1.setBounds(110, 160, 300, 30);
		Jlb2.setBounds(20, 380, 300, 30);
		
		Jlb3.setBounds(Jfr_Xsize*3/4-20, 10, 200, 30);
		Jlb4.setBounds(Jfr_Xsize*3/4-40, 220, 200, 30);
		
		Jlb1.setBackground(Color.white);
		Jlb2.setBackground(Color.white);
		Jlb3.setBackground(Color.white);
		Jlb4.setBackground(Color.white);
		
		
		Jpn4.setBounds(0, 0, Jfr_Xsize, Jfr_Ysize);
		Jpn4.setLayout(new BorderLayout());
		Jpn4.setBackground(Color.white);
		mJfr.getJfr().add(Jpn4);

		Jpn1.setBounds(30, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
		Jpn2.setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
		Jpn3.setBounds(300, Jfr_Ysize/2+50, Jfr_Xsize-100, Jfr_Ysize/2-50);
		Jpn3.setLayout(new BorderLayout());
		if(myCh.getName().equals("어피치"))
		{
			Jpn1.setBackground(Color.red);
		}
		else if(myCh.getName().equals("무지"))
		{
			Jpn1.setBackground(Color.green);
		}
		else if(myCh.getName().equals("튜브"))
		{
			Jpn1.setBackground(Color.blue);
		}else
		{
			System.out.println("캐릭터 오류");
		}
		Jpn3.setBackground(Color.white);
		
		
		
		
		fightMonControl= new FightMonControl(myCh,mon, mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo,myX,myY);
		mJfr.getJfr().addKeyListener(fightMonControl); 
		mJfr.getJfr().repaint();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mJfr.getJfr().remove(Jpn4);
		mJfr.getJfr().add(Jpn1);
		mJfr.getJfr().add(Jpn2);
		mJfr.getJfr().add(Jpn3);
		mJfr.getJfr().add(Jpn5);
		mJfr.getJfr().add(Jlb1);
		mJfr.getJfr().add(Jlb2);
		mJfr.getJfr().add(Jlb3);
		mJfr.getJfr().add(Jlb4);


		
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
					e.printStackTrace();
				}
				mJfr.getJfr().remove(Jpn1);
				mJfr.getJfr().remove(Jpn2);
				mJfr.getJfr().remove(Jpn3);
				mJfr.getJfr().remove(Jpn4);
				mJfr.getJfr().remove(Jlb1);
				mJfr.getJfr().remove(Jlb2);
				mJfr.getJfr().remove(Jlb3);
				mJfr.getJfr().remove(Jlb4);
				Jpn4=new JPanel(){
					
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void paintComponent(Graphics g) {
						
							g.drawImage(icon6.getImage(), 0, 0, Jfr_Xsize, Jfr_Ysize, null);
						
		               } 
		        };
				Jpn4.setBounds(0, 0, Jfr_Xsize, Jfr_Ysize);
				Jpn4.setLayout(new BorderLayout());
				Jpn4.setBackground(Color.white);
				mJfr.getJfr().add(Jpn4);
				mJfr.getJfr().repaint();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mJfr.getJfr().remove(Jpn4);
				
				break;

			}
			Jlb1.setText(myCh.getName()+" Lv."+myCh.getLevel());
			Jlb2.setText(" 체력: "+myCh.getNHp()+"/"+myCh.getHp()+
					" 마력: "+myCh.getNMp()+"/"+myCh.getMp()+
					" 공격력: "+myCh.getAttack() +" 경험치: "+myCh.getNexe()+"/"+myCh.getMexe());
			Jlb3.setText("몬스터 Lv."+mon.getLevel());
			Jlb4.setText(" 체력: "+mon.getNHp()+"/"+mon.getHp()+" 공격력: "+mon.getAttack());
			icon4 = new ImageIcon(".\\img\\background2.jpg");
			Jpn4.setBounds(0, 0, Jfr_Xsize, Jfr_Ysize);
			mJfr.getJfr().add(Jpn4);
			mJfr.getJfr().repaint();
			if(fightMonControl.ismove())
			{
				selectMenu=fightMonControl.moveSelect(selectMenu);
				
				
				fightMonControl.wasmoved();
				
			}
			if(myCh.getIsSkill()!=true)
			{
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(myCh.getNHp()>0&&mon.getNHp()>0&&myCh.getIsAttack()==true)
			{
				
				mJfr.getJfr().add(Jpn5);
				Jpn5.setBounds(100, 50, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
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
					mJfr.getJfr().remove(Jpn5);
				}
				if(motion_ok)
				{
					mmotion++;
					if(mmotion==2)
					{
						Jpn2.setBounds(Jfr_Xsize*3/4-70, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==3)
					{

						Jpn2.setBounds(Jfr_Xsize*3/4-90, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==4)
					{

						Jpn2.setBounds(Jfr_Xsize*3/4-70, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==5)
					{
						Jpn2.setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
						
					}
					else
					{
						motion=1;
						mmotion=1;
						motion_ok=false;
						fightMonControl.ourturn();
						myCh.setIsAttack(false);
						mon.setIsAttack(true);
					}
				}
				
				
				
			}
			
			if(mon.getNHp()>0&&myCh.getNHp()>0&&mon.getIsAttack()==true)
			{
				mJfr.getJfr().add(Jpn5);
				Jpn5.setBounds(600, 270, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
				
				if(motion==2)
				{
					Jpn2.setBounds(Jfr_Xsize*3/4-80, 30, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroomA.jpg");
				}
				else if(motion==3)
				{
					Jpn2.setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroom.png");
				}
				else if(motion==4)
				{
					Jpn2.setBounds(Jfr_Xsize*3/4-80, 30, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroomA.jpg");
				}
				else if(motion==5)
				{
					Jpn2.setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroom.png");
				}
				else if(motion>5)
				{
					motion_ok=true;
					mJfr.getJfr().remove(Jpn5);
				}
				if(motion_ok)
				{
					mmotion++;
					if(mmotion==2)
					{
						Jpn1.setBounds(20, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==3)
					{

						Jpn1.setBounds(40, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==4)
					{

						Jpn1.setBounds(20, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==5)
					{
						Jpn1.setBounds(30, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
						
					}
					else
					{
						motion=1;
						mmotion=1;
						motion_ok=false;
						fightMonControl.monturn();
						mon.setIsAttack(false);
						myCh.setIsAttack(false);
						fightMonControl.turnoff(true);
					}
				}
			}
			if(myCh.getNHp()>0&&mon.getNHp()>0&&myCh.getNMp()>=10&&myCh.getIsSkill()==true)
			{
				mJfr.getJfr().add(Jpn5);
				Jpn5.setBounds(100, 50, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
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
					mJfr.getJfr().remove(Jpn5);
				}
				if(motion_ok)
				{
					
					mmotion++;
					if(mmotion==2)
					{
						Jpn2.setBounds(Jfr_Xsize*3/4-70, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==3)
					{

						Jpn2.setBounds(Jfr_Xsize*3/4-90, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==4)
					{

						Jpn2.setBounds(Jfr_Xsize*3/4-70, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					}
					else if(mmotion==5)
					{
						Jpn2.setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
						
					}
					else
					{
						myCh.setNMp(myCh.getNMp()-10);
						motion=1;
						mmotion=1;
						motion_ok=false;
						fightMonControl.ourturn();
						myCh.setIsSkill(false);
						mon.setIsAttack(true);
					}
				}
				
				
				
			}
			if(mon.getNHp()>0&&myCh.getNHp()>0&&mon.getIsAttack()==true)
			{
				mJfr.getJfr().add(Jpn5);
				Jpn5.setBounds(600, 270, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
				motion++;
				if(motion==2)
				{
					Jpn2.setBounds(Jfr_Xsize*3/4-80, 30, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroomA.jpg");
				}
				else if(motion==3)
				{
					Jpn2.setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroom.png");
				}
				else if(motion==4)
				{
					Jpn2.setBounds(Jfr_Xsize*3/4-80, 30, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroomA.jpg");
				}
				else if(motion==5)
				{
					Jpn2.setBounds(Jfr_Xsize*3/4-80, 50, Jfr_Xsize/4, Jfr_Ysize/3);
					icon2 = new ImageIcon(".\\img\\mushroom.png");
				}
				else if(motion>5)
				{
					motion_ok=true;
					mJfr.getJfr().remove(Jpn5);
				}
				if(motion_ok)
				{
					mmotion++;
					if(mmotion==2)
					{
						Jpn1.setBounds(20, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==3)
					{

						Jpn1.setBounds(40, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==4)
					{

						Jpn1.setBounds(20, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
					}
					else if(mmotion==5)
					{
						Jpn1.setBounds(30, 190, Jfr_Xsize/4+50, Jfr_Ysize/3+50);
						
					}
					else
					{
						motion=1;
						mmotion=1;
						motion_ok=false;
						fightMonControl.monturn();
						mon.setIsAttack(false);
						myCh.setIsSkill(false);
						fightMonControl.turnoff(true);
					}
				}
			}
		}

		mJfr.getJfr().remove(Jpn1);
		mJfr.getJfr().remove(Jpn2);
		mJfr.getJfr().remove(Jpn3);
		mJfr.getJfr().remove(Jpn4);
		mJfr.getJfr().remove(Jlb1);
		mJfr.getJfr().remove(Jlb2);
		mJfr.getJfr().remove(Jlb3);
		mJfr.getJfr().remove(Jlb4);
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false);
	}
}
