package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.GameControl;
import entity.AllChar;
import entity.Apeach;
import entity.Muji;
import entity.MyJFrame;
import entity.Tube;

public class GameView implements Runnable{
	GameControl gamecontrol;
	
	MyJFrame mJfr;
	int Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo;
	int myX, myY;
	AllChar myCh;
	JButton jbt1;
	JButton jbt2;
	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon icon3;
	final ImageIcon icon4 = new ImageIcon(".\\img\\background.jpg");
	boolean end=false;
	int walk=1;
	public GameView(AllChar myC,MyJFrame mJf, int Jfr_Xsize, int  Jfr_Ysize,
			int Jfr_Xlo, int Jfr_Ylo,int myX,int myY)
	{
		this.myCh=myC;
		this.Jfr_Xsize=Jfr_Xsize;
		this.Jfr_Ysize=Jfr_Ysize;
		this.Jfr_Xlo=Jfr_Xlo;
		this.Jfr_Ylo=Jfr_Ylo;
		this.mJfr=mJf;
		this.myX=myX;
		this.myY=myY;
		 msetXY(myX,myY);
		 jbt1=new JButton();
		 jbt2=new JButton();
		 mJfr.setJpn1(new JPanel());
		 mJfr.setJpn2(new JPanel());
		 mJfr.setJpn2(new JPanel()
		 { 
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override 
		    protected void paintComponent(Graphics g)
			{ 
				mJfr.getJfr().requestFocusInWindow();
				g.clearRect(0, 0, getWidth(), getHeight()); 
				g.drawImage(icon4.getImage(), 0, 0, Jfr_Xsize, Jfr_Ysize, null);
				if(myCh.getName().equals("어피치"))
				{
					icon1 = new ImageIcon(".\\img\\apeachW1.png");
					icon2 = new ImageIcon(".\\img\\apeachW2.png");
					icon3 = new ImageIcon(".\\img\\apeachW3.png");
				     
				}else if(myCh.getName().equals("무지"))
				{
					icon1 = new ImageIcon(".\\img\\mujiW1.jpg");
					icon2 = new ImageIcon(".\\img\\mujiW2.png");
					icon3 = new ImageIcon(".\\img\\mujiW3.png");
					 
				}else if(myCh.getName().equals("튜브")){
					g.setColor(Color.blue);
					
				}else
				{
					System.out.println("캐릭터 선택오류");
				}
				if(walk==1)
				{
					g.drawImage(icon1.getImage(), mgetX(), mgetY(), 70, 70, null);
				}
				else if(walk==2)
				{
					g.drawImage(icon3.getImage(), mgetX(), mgetY(), 70, 70, null);
				}
				else if(walk==3)
				{
					g.drawImage(icon3.getImage(), mgetX(), mgetY(), 70, 70, null);
				}
				else if(walk==4)
				{
					g.drawImage(icon2.getImage(), mgetX(), mgetY(), 70, 70, null);
				}
				else if(walk==5)
				{
					g.drawImage(icon1.getImage(), mgetX(), mgetY(), 70, 70, null);
				}
		    	
			} 
		  });

		  
		  jbt1.setIcon(new ImageIcon(".\\img\\save1.png"));
		  mJfr.setJpn1(new JPanel());
		  mJfr.getJpn1().setLayout(new BorderLayout());
		  mJfr.getJpn1().setBounds(0, 0, 50, 50);
		  mJfr.getJpn1().add(jbt1);
		  
		  mJfr.getJpn2().setBounds(0, 0, Jfr_Xsize, Jfr_Ysize);
		  
		 mJfr.getJfr().add(mJfr.getJpn1());
		mJfr.getJfr().add(mJfr.getJpn2());
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false); 
		jbt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				end=true;
				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJfr().remove(mJfr.getJpn3());
				mJfr.getJfr().remove(mJfr.getJpn4());
				new SaveGameView(mJfr, myCh, Jfr_Xsize, Jfr_Ysize, 
						Jfr_Xlo, Jfr_Ylo,mgetX(), mgetY());
			}
			
		});
	    
		mJfr.getJfr().add(mJfr.getJpn1());
		mJfr.getJfr().add(mJfr.getJpn2());
		
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false);
		
	    gamecontrol = new GameControl();
	    mJfr.getJfr().addKeyListener(gamecontrol); 

	    gamecontrol.maxSize(Jfr_Xsize, Jfr_Ysize);
	    Thread t = new Thread(this);
	    t.start();
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

		mJfr.getJfr().add(mJfr.getJpn1());
		mJfr.getJfr().add(mJfr.getJpn2());
		
		while (true){
			if(end)
			{
				break;
			}
			mJfr.getJfr().repaint();
			
			if(gamecontrol.ismove())
			{
				for(int a=5;a>0;a--)
				{
					gamecontrol.moveChar(myCh);
					mJfr.getJfr().repaint();
					try {
						walk++;
						if(walk>5)
						{
							walk=walk-5;
						}
						Thread.sleep(60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(gamecontrol.meetmon(mgetX(), mgetY())){
					AllChar mon = gamecontrol.setMon(myCh);
					
					mJfr.getJfr().remove(mJfr.getJpn1());
					mJfr.getJfr().remove(mJfr.getJpn2());
					new FightMonView(myCh,mon, mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo,mgetX(),mgetY());
					break;
				}
				gamecontrol.wasmoved();
			}
			try{ 
		            Thread.sleep(120); 
		        }catch (Exception ex){ } 
	       
		}
		mJfr.getJfr().remove(mJfr.getJpn1());
		mJfr.getJfr().remove(mJfr.getJpn2());
	}
	public void msetXY(int x, int y)
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
	public int mgetX()
	{
		 if(myCh.getName().equals("어피치"))
			{
				 return ((Apeach) myCh).getMX();
				
			}
			 else if(myCh.getName().equals("무지"))
			{
				return ((Muji) myCh).getMX();
				 
			}
			 else if(myCh.getName().equals("튜브"))
			 {
				 return ((Tube) myCh).getMX();
				 
			}
			 else{
				 return 0;
			}
	}
	public int mgetY()
	{
		 if(myCh.getName().equals("어피치"))
			{
				 return ((Apeach) myCh).getMY();
				
			}
			 else if(myCh.getName().equals("무지"))
			{
				return ((Muji) myCh).getMY();
				 
			}
			 else if(myCh.getName().equals("튜브"))
			 {
				 return ((Tube) myCh).getMY();
				 
			}
			 else{
				 return 0;
			}
	}
	
	

}
