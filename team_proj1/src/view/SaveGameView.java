package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.CharSaveDAO;
import entity.AllChar;
import entity.MyJFrame;

public class SaveGameView {
	AllChar myCh;
	JButton jbt1;
	JButton jbt2;
	JButton jbt3;
	JButton jbt4;
	public SaveGameView(MyJFrame mJfr, AllChar myC, int Jfr_Xsize, int Jfr_Ysize, 
			int jfr_Xlo, int jfr_Ylo, int myX, int myY)
	{
		mJfr.setJpn1(new JPanel());
		mJfr.setJpn2(new JPanel());
		mJfr.setJpn3(new JPanel());
		mJfr.setJpn4(new JPanel());
		mJfr.setJlb1(new JLabel());
		mJfr.setJlb2(new JLabel());
		mJfr.setJlb3(new JLabel());
		
		jbt1=new JButton();
		jbt2=new JButton();
		jbt3=new JButton();
		jbt4=new JButton("뒤로가기");
		
		CharSaveDAO charSaveDAO = new CharSaveDAO();
		
		String chName;
		myCh=charSaveDAO.load(1);
		if(myCh!=null)
		{
			mJfr.getJlb1().setText(myCh.getName()+" Lv."+myCh.getLevel());
			
			if(myCh.getName().equals("어피치"))
			{
				chName="apeach";
			     
			}else if(myCh.getName().equals("무지"))
			{
				chName="muji";
				 
			}else{
				chName="tube";
				
			}
			jbt1.setIcon(new ImageIcon(".\\img\\"+chName+".png"));
		}
		else
		{
			jbt1=new JButton("1번 슬롯");
		}
		myCh=charSaveDAO.load(2);
		if(myCh!=null)
		{
			mJfr.getJlb2().setText(myCh.getName()+" Lv."+myCh.getLevel());
			
			if(myCh.getName().equals("어피치"))
			{
				chName="apeach";
			     
			}else if(myCh.getName().equals("무지"))
			{
				chName="muji";
				 
			}else{
				chName="tube";
				
			}
			jbt2.setIcon(new ImageIcon(".\\img\\"+chName+".png"));
		}
		else
		{
			jbt2=new JButton("2번 슬롯");
		}
		myCh=charSaveDAO.load(3);
		if(myCh!=null)
		{
			mJfr.getJlb3().setText(myCh.getName()+" Lv."+myCh.getLevel());
			
			if(myCh.getName().equals("어피치"))
			{
				chName="apeach";
			     
			}else if(myCh.getName().equals("무지"))
			{
				chName="muji";
				 
			}else{
				chName="tube";
				
			}
			jbt3.setIcon(new ImageIcon(".\\img\\"+chName+".png"));
		}
		else
		{
			jbt3=new JButton("3번 슬롯");
		}
		
		mJfr.getJpn1().setLayout(new BorderLayout());
		mJfr.getJpn1().setBounds(Jfr_Xsize/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		mJfr.getJpn1().add(jbt1);
		mJfr.getJfr().add(mJfr.getJpn1());
		mJfr.getJlb1().setBounds(Jfr_Xsize/13+50, 40, 100, 30);
		
		jbt1.setBackground(Color.white);
		
		mJfr.getJpn2().setLayout(new BorderLayout());
		mJfr.getJpn2().setBounds((Jfr_Xsize*5)/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		mJfr.getJpn2().add(jbt2);
		mJfr.getJfr().add(mJfr.getJpn2());
		mJfr.getJlb2().setBounds((Jfr_Xsize*5)/13+50, 40, 100, 30);
		
		jbt2.setBackground(Color.white);
		
		mJfr.getJpn3().setLayout(new BorderLayout());
		mJfr.getJpn3().setBounds((Jfr_Xsize*9)/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		mJfr.getJpn3().add(jbt3);
		mJfr.getJfr().add(mJfr.getJpn3());
		mJfr.getJlb3().setBounds((Jfr_Xsize*9)/13+50, 40, 100, 30);
		jbt3.setBackground(Color.white);
		
		mJfr.getJpn4().setLayout(new BorderLayout());
		mJfr.getJpn4().add(jbt4);
		mJfr.getJfr().add(mJfr.getJpn4());
		mJfr.getJpn4().setBounds((Jfr_Xsize*10)/13, Jfr_Ysize-120, (Jfr_Xsize*2)/13, 50);
		jbt4.setBackground(Color.white);
		
		mJfr.getJfr().add(mJfr.getJlb1());
		mJfr.getJfr().add(mJfr.getJlb2());
		mJfr.getJfr().add(mJfr.getJlb3());
		
		mJfr.getJfr().repaint();
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false); 
		jbt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CharSaveDAO(myC,1);
				mJfr.getJlb1().setText(myC.getName()+" Lv."+myC.getLevel());
				if(myC.getName().equals("어피치"))
				{
					jbt1.setIcon(new ImageIcon(".\\img\\apeach.png"));
				     
				}else if(myC.getName().equals("무지"))
				{
					jbt1.setIcon(new ImageIcon(".\\img\\muji.png"));
					 
				}else{
					jbt1.setIcon(new ImageIcon(".\\img\\tube.png"));
					
				}
				mJfr.getJpn1().repaint();
			}
		});
		jbt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CharSaveDAO(myC,2);
				mJfr.getJlb2().setText(myC.getName()+" Lv."+myC.getLevel());
				if(myC.getName().equals("어피치"))
				{
					jbt2.setIcon(new ImageIcon(".\\img\\apeach.png"));
				     
				}else if(myC.getName().equals("무지"))
				{
					jbt2.setIcon(new ImageIcon(".\\img\\muji.png"));
					 
				}else{
					jbt2.setIcon(new ImageIcon(".\\img\\tube.png"));
					
				}
				mJfr.getJpn2().repaint();
			}
		});
		
		jbt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CharSaveDAO(myC,3);
				mJfr.getJlb3().setText(myC.getName()+" Lv."+myC.getLevel());
				if(myC.getName().equals("어피치"))
				{
					jbt3.setIcon(new ImageIcon(".\\img\\apeach.png"));
				     
				}else if(myC.getName().equals("무지"))
				{
					jbt3.setIcon(new ImageIcon(".\\img\\muji.png"));
					 
				}else{
					jbt3.setIcon(new ImageIcon(".\\img\\tube.png"));
					
				}
				mJfr.getJpn3().repaint();
			}
		});
		
		jbt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mJfr.getJfr().remove(mJfr.getJlb1());
				mJfr.getJfr().remove(mJfr.getJlb2());
				mJfr.getJfr().remove(mJfr.getJlb3());
				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJfr().remove(mJfr.getJpn3());
				mJfr.getJfr().remove(mJfr.getJpn4());
				new GameView(myC, mJfr, Jfr_Xsize, Jfr_Ysize,jfr_Xlo, jfr_Ylo,myX,myY);
			}
		
		});
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false);
		
		
		
	}
}
