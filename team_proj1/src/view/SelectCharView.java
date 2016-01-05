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

import entity.AllChar;
import entity.Apeach;
import entity.Muji;
import entity.MyJFrame;

public class SelectCharView{
	public enum EChar {EApeach, EMuji, ETube}
	EChar eChar = null;
	JButton jbt1;
	JButton jbt2;
	JButton jbt3;
	JButton jbt4;
	
	public SelectCharView(MyJFrame mJfr, int Jfr_Xsize, int  Jfr_Ysize, int Jfr_Xlo, int Jfr_Ylo)
	{ 
		jbt1=new JButton();
		jbt2=new JButton();
		jbt3=new JButton();
		jbt4=new JButton("뒤로가기");
		
		mJfr.setJpn4(new JPanel());
		
		jbt1.setIcon(new ImageIcon(".\\img\\apeach.png"));
		jbt2.setIcon(new ImageIcon(".\\img\\muji.png"));
		jbt3.setIcon(new ImageIcon(".\\img\\tube.png"));
			
		
		
		
		
		
		
		final ImageIcon icon1 = new ImageIcon(".\\img\\kakao.jpg");
		final ImageIcon icon2 = new ImageIcon(".\\img\\kakao.jpg");
		final ImageIcon icon3 = new ImageIcon(".\\img\\kakao.jpg");
		mJfr.setJpn1( new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
                g.drawImage(icon1.getImage(), 0, 0, Jfr_Xsize/4, Jfr_Ysize-200,  null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        });
		mJfr.setJpn2( new JPanel(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
                g.drawImage(icon2.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        });
		mJfr.setJpn3( new JPanel(){
			private static final long serialVersionUID = -8441283721470581695L;
			public void paintComponent(Graphics g) {
                g.drawImage(icon3.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        });
		
		
		mJfr.getJpn1().setLayout(new BorderLayout());
		mJfr.getJpn1().setBounds(Jfr_Xsize/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		//mJfr.getJpn1().add(mJfr.getBt1());
		//mJfr.getJpn1().setOpaque(false);
		//mJfr.getBt1().setBackground(Color.white);
		mJfr.getJfr().add(mJfr.getJpn1());
		mJfr.getJpn1().add(jbt1);
		jbt1.setBackground(Color.white);
		
		mJfr.getJpn2().setLayout(new BorderLayout());
		mJfr.getJfr().add(mJfr.getJpn2());
		mJfr.getJpn2().setBounds((Jfr_Xsize*5)/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		mJfr.getJpn2().add(jbt2);
		jbt2.setBackground(Color.white);
		
		mJfr.getJpn3().setLayout(new BorderLayout());
		mJfr.getJfr().add(mJfr.getJpn3());
		mJfr.getJpn3().setBounds((Jfr_Xsize*9)/13, 70, Jfr_Xsize/4, Jfr_Ysize-200);
		mJfr.getJpn3().add(jbt3);
		jbt3.setBackground(Color.white);
		
		mJfr.getJpn4().setLayout(new BorderLayout());
		mJfr.getJfr().add(mJfr.getJpn4());
		mJfr.getJpn4().setBounds((Jfr_Xsize*10)/13, Jfr_Ysize-120, (Jfr_Xsize*2)/13, 50);
		mJfr.getJpn4().add(jbt4);
		jbt4.setBackground(Color.white);
		
		mJfr.getJfr().setVisible(true);
		mJfr.getJfr().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mJfr.getJfr().setResizable(false); 
		jbt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				AllChar myCh = new Apeach();

				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJfr().remove(mJfr.getJpn3());
				mJfr.getJfr().remove(mJfr.getJpn4());
				myCh.setLevel(1);
				new GameView(myCh,mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo,50,Jfr_Ysize-100);
			}
			
		});
		jbt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				AllChar myCh = new Muji();
				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJfr().remove(mJfr.getJpn3());
				mJfr.getJfr().remove(mJfr.getJpn4());
				mJfr.getJfr().setVisible(false);
				myCh.setLevel(1);
				new GameView(myCh,mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo,50,Jfr_Ysize-100);
			}
			
		});
		jbt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				AllChar myCh = new Tube();
				mJfr.getJpn1().removeAll();
				mJfr.getJpn2().removeAll();
				mJfr.getJpn3().removeAll();
				mJfr.getJpn4().removeAll();
				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJfr().remove(mJfr.getJpn3());
				mJfr.getJfr().remove(mJfr.getJpn4());
				mJfr.getJfr().setVisible(false);
				myCh.setLevel(1);
				new GameView(myCh,mJfr, Jfr_Xsize, Jfr_Ysize,Jfr_Xlo, Jfr_Ylo,50,Jfr_Ysize-100);
				*/
			}
			
		});
		jbt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mJfr.getJfr().remove(mJfr.getJpn1());
				mJfr.getJfr().remove(mJfr.getJpn2());
				mJfr.getJfr().remove(mJfr.getJpn3());
				mJfr.getJfr().remove(mJfr.getJpn4());
				mJfr.getJpn1().repaint();
				new MainMenuView(mJfr, Jfr_Xsize,Jfr_Ysize);
			}
		
		});
		
		
		
	}
	
}
