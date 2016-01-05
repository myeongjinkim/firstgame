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

public class LoadGameView {
	AllChar myCh;
	public LoadGameView(MyJFrame mJfr,int Jfr_Xsize,int  Jfr_Ysize, int jfr_Xlo, int jfr_Ylo)
	{
		CharSaveDAO charSaveDAO = new CharSaveDAO();
		mJfr.setJpn1(new JPanel());
		mJfr.setJpn2(new JPanel());
		mJfr.setJpn3(new JPanel());
		mJfr.setJpn4(new JPanel());
		JButton jbt1=new JButton();
		JButton jbt2=new JButton();
		JButton jbt3=new JButton();
		JButton jbt4=new JButton("뒤로가기");
		
		mJfr.setJlb1(new JLabel());
		mJfr.setJlb2(new JLabel());
		mJfr.setJlb3(new JLabel());

		
		myCh = charSaveDAO.load(1);
		if(myCh!=null)
		{
			mJfr.getJlb1().setText(myCh.getName()+" Lv."+myCh.getLevel());
			if(myCh.getName().equals("어피치"))
			{
				jbt1.setIcon(new ImageIcon(".\\img\\apeach.png"));
			     
			}else if(myCh.getName().equals("무지"))
			{
				jbt1.setIcon(new ImageIcon(".\\img\\muji.png"));
				 
			}else{
				jbt1.setIcon(new ImageIcon(".\\img\\tube.png"));
				
			}
		}
		else
		{
			jbt1=new JButton("1번 슬롯");
		}
		
		myCh = charSaveDAO.load(2);
		if(myCh!=null)
		{
			mJfr.getJlb2().setText(myCh.getName()+" Lv."+myCh.getLevel());
			if(myCh.getName().equals("어피치"))
			{
				jbt2.setIcon(new ImageIcon(".\\img\\apeach.png"));
			     
			}else if(myCh.getName().equals("무지"))
			{
				jbt2.setIcon(new ImageIcon(".\\img\\muji.png"));
				 
			}else{
				jbt2.setIcon(new ImageIcon(".\\img\\tube.png"));
				
			}
		}
		else
		{
			jbt2=new JButton("2번 슬롯");
		}
		
		myCh = charSaveDAO.load(3);
		if(myCh!=null)
		{
			mJfr.getJlb3().setText(myCh.getName()+" Lv."+myCh.getLevel());
			if(myCh.getName().equals("어피치"))
			{
				jbt3.setIcon(new ImageIcon(".\\img\\apeach.png"));
			     
			}else if(myCh.getName().equals("무지"))
			{
				jbt3.setIcon(new ImageIcon(".\\img\\muji.png"));
				 
			}else{
				jbt3.setIcon(new ImageIcon(".\\img\\tube.png"));
				
			}
		}
		else
		{
			jbt3=new JButton("3번 슬롯");
		}
		mJfr.getJpn1().setLayout(new BorderLayout());
		mJfr.getJfr().add(mJfr.getJpn1());
		mJfr.getJlb1().setBounds(Jfr_Xsize/13+50, 40, 100, 30);
		mJfr.getJpn1().setBounds(Jfr_Xsize/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		mJfr.getJpn1().add(jbt1);
		jbt1.setBackground(Color.white);
		
		mJfr.getJpn2().setLayout(new BorderLayout());
		mJfr.getJfr().add(mJfr.getJpn2());
		mJfr.getJlb2().setBounds((Jfr_Xsize*5)/13+50, 40, 100, 30);
		mJfr.getJpn2().setBounds((Jfr_Xsize*5)/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		mJfr.getJpn2().add(jbt2);
		jbt2.setBackground(Color.white);
		
		mJfr.getJpn3().setLayout(new BorderLayout());
		mJfr.getJfr().add(mJfr.getJpn3());
		mJfr.getJlb3().setBounds((Jfr_Xsize*9)/13+50, 40, 100, 30);
		mJfr.getJpn3().setBounds((Jfr_Xsize*9)/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		mJfr.getJpn3().add(jbt3);
		jbt3.setBackground(Color.white);
		
		mJfr.getJpn4().setLayout(new BorderLayout());
		mJfr.getJfr().add(mJfr.getJpn4());
		mJfr.getJpn4().setBounds((Jfr_Xsize*10)/13, Jfr_Ysize-120, (Jfr_Xsize*2)/13, 50);
		mJfr.getJpn4().add(jbt4);
		jbt4.setBackground(Color.white);
		
		mJfr.getJfr().add(mJfr.getJlb1());
		mJfr.getJfr().add(mJfr.getJlb2());
		mJfr.getJfr().add(mJfr.getJlb3());
		
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false); 
		
		jbt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				myCh=charSaveDAO.load(1);
				if(myCh!=null)
				{
					mJfr.getJfr().remove(mJfr.getJlb1());
					mJfr.getJfr().remove(mJfr.getJlb2());
					mJfr.getJfr().remove(mJfr.getJlb3());
					mJfr.getJfr().remove(mJfr.getJpn1());
					mJfr.getJfr().remove(mJfr.getJpn2());
					mJfr.getJfr().remove(mJfr.getJpn3());
					mJfr.getJfr().remove(mJfr.getJpn4());
					mJfr.getJpn1().repaint();
					new GameView(myCh, mJfr, Jfr_Xsize, Jfr_Ysize,jfr_Xlo, jfr_Ylo,50,Jfr_Ysize-100);
				}
			}
		});
		jbt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myCh=charSaveDAO.load(2);
				if(myCh!=null)
				{
					mJfr.getJfr().remove(mJfr.getJlb1());
					mJfr.getJfr().remove(mJfr.getJlb2());
					mJfr.getJfr().remove(mJfr.getJlb3());
					mJfr.getJfr().remove(mJfr.getJpn1());
					mJfr.getJfr().remove(mJfr.getJpn2());
					mJfr.getJfr().remove(mJfr.getJpn3());
					mJfr.getJfr().remove(mJfr.getJpn4());
					mJfr.getJpn1().repaint();
					new GameView(myCh, mJfr, Jfr_Xsize, Jfr_Ysize,jfr_Xlo, jfr_Ylo,50,Jfr_Ysize-100);
				}
			}
		});
		jbt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myCh=charSaveDAO.load(3);
				if(myCh!=null)
				{
					mJfr.getJfr().remove(mJfr.getJlb1());
					mJfr.getJfr().remove(mJfr.getJlb2());
					mJfr.getJfr().remove(mJfr.getJlb3());
					mJfr.getJfr().remove(mJfr.getJpn1());
					mJfr.getJfr().remove(mJfr.getJpn2());
					mJfr.getJfr().remove(mJfr.getJpn3());
					mJfr.getJfr().remove(mJfr.getJpn4());
					mJfr.getJpn1().repaint();
					new GameView(myCh, mJfr, Jfr_Xsize, Jfr_Ysize,jfr_Xlo, jfr_Ylo,50,Jfr_Ysize-100);
				}
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
				mJfr.getJpn1().repaint();
				new MainMenuView(mJfr, Jfr_Xsize, Jfr_Ysize);
			}
		
		});
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false);
		
		
	}
}
